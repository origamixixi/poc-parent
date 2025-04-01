package org.hc.lj;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.hc.lj.entity.*;
import org.hc.lj.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.*;
import java.util.function.Consumer;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class AppointmentTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AppointmentTestRepository appointmentTestRepository;

    @Autowired
    private Appointment100000Repository appointment100000Repository;

    @Autowired
    private Appointment5000000500Repository appointment5000000500Repository;

    @Autowired
    private Appointment50000003000Repository appointment50000003000Repository;

    @Autowired
    private Appointment500000010000Repository appointment500000010000Repository;

    @Autowired
    private Appointment50000000Repository appointment50000000Repository;

    @Test
    public void findAll() {
        List<org.hc.lj.entity.AppointmentTest> appointmentTest = appointmentTestRepository.findAll();
        log.info("appointmentTest: {}", JSON.toJSONString(appointmentTest));
    }

    @Test
    public void insertAppointment100000() {
        insertAppointments(500, 100_000, Appointment100000.class, appointment100000Repository::saveAll);
    }

    @Test
    public void insertAppointment50000003000() {
        insertAppointments(3_000, 5_000_000, Appointment50000003000.class, appointment50000003000Repository::saveAll);
    }
    @Test
    public void insertAppointment5000000500() {
        insertAppointments(500, 5_000_000, Appointment5000000500.class, appointment5000000500Repository::saveAll);
    }
    @Test
    public void insertAppointment500000010000() {
        insertAppointments(10_000, 5_000_000, Appointment500000010000.class, appointment500000010000Repository::saveAll);
    }

    @Test
    public void insertAppointment50000000() {
        insertAppointments(10_000, 50_000_000, Appointment50000000.class, appointment50000000Repository::saveAll);
    }

    private <T extends Appointment> void insertAppointments(int aggregatedSize, int totalAppointments, Class<T> clazz, Consumer<Collection<T>> saveFunction) {
        // init table
        jdbcTemplate.execute("delete from " + getTableName(clazz));

        int batchSize = 1000;

        Random random = new Random();
        List<Integer> aIndices = new ArrayList<>();

        // Generate all indices and randomly select 'aggregatedSize' indices for 'A' prefixed data
        for (int i = 0; i < totalAppointments; i++) {
            aIndices.add(i);
        }
        Collections.shuffle(aIndices);
        aIndices = aIndices.subList(0, aggregatedSize);

        List<T> appointments = new ArrayList<>();
        Map<String, Integer> prefixCounters = new HashMap<>();
        prefixCounters.put("A", 0);
        prefixCounters.put("B", 0);
        prefixCounters.put("C", 0);
        prefixCounters.put("D", 0);
        prefixCounters.put("E", 0);
        prefixCounters.put("F", 0);
        prefixCounters.put("G", 0);
        prefixCounters.put("H", 0);
        prefixCounters.put("I", 0);

        List<String> availablePrefixes = new ArrayList<>(Arrays.asList("B", "C", "D", "E", "F", "G", "H", "I"));

        for (int i = 0; i < totalAppointments; i++) {
            String prefix;
            int counter;
            if (aIndices.contains(i)) {
                prefix = "A";
                counter = prefixCounters.get("A") + 1;
                prefixCounters.put("A", counter);
            } else {
                if (availablePrefixes.isEmpty()) {
                    throw new RuntimeException("No available prefixes left");
                }
                prefix = availablePrefixes.get(random.nextInt(availablePrefixes.size()));
                counter = prefixCounters.get(prefix) + 1;
                prefixCounters.put(prefix, counter);
                if (prefixCounters.get(prefix) >= 9999999) {
                    availablePrefixes.remove(prefix);
                }
            }

            T appointment = createAppointment(prefix, counter, clazz, i);
            appointments.add(appointment);

            // Insert batch
            if (appointments.size() >= batchSize) {
                // Shuffle the list to randomize the order within the batch
                Collections.shuffle(appointments);

                // Save all appointments in the current batch to the database
                saveFunction.accept(appointments);

                appointments.clear();
                log.info("Batch completed.");
            }
        }

        // Insert remaining appointments
        if (!appointments.isEmpty()) {
            // Shuffle the list to randomize the order within the batch
            Collections.shuffle(appointments);

            // Save all appointments in the current batch to the database
            saveFunction.accept(appointments);

            log.info("Remaining batch completed.");
        }

        log.info("Insert operation completed.");
    }

    private <T extends Appointment> T createAppointment(String prefix, int counter, Class<T> clazz, int index) {
        Appointment appointment = new Appointment();
        char prefixChar = prefix.charAt(0);
        int patientKeyPrefix = prefixChar - 'A' + 1; // Calculate the prefix number based on the character
        String patientNo = String.format("%08d", patientKeyPrefix * 10000000L + counter); // Ensure patientNo is 8 digits with leading zeros
        appointment.setApptSeq(index + 1);
        appointment.setOpsPatientNo(Integer.parseInt(patientNo));
        appointment.setCaseNo("TKG" + patientNo + "T");
        appointment.setSpecialty("TKG1");
        appointment.setSubSpecialty("TQR4");
        appointment.setSlotDatetime(Timestamp.valueOf("2025-03-19 19:00:00.000"));
        appointment.setStatus("A");
        appointment.setCaseType("N");
        appointment.setBookType("B");
        appointment.setPriority("0641");
        appointment.setSourceCode("4");
        appointment.setSourceHospital("VH");
        appointment.setSourceSpecialty("TKG1");
        appointment.setMemo("");
        appointment.setTreatmentType("N");
        appointment.setTreatmentUnit(1);
        appointment.setAttnStatus("Y");
        appointment.setAttnTime(Timestamp.valueOf("2025-03-19 19:47:41.407"));
        appointment.setPatientGenericStatus("EP");
        appointment.setBookedBy("ODCUSER");
        appointment.setBookingDatetime(Timestamp.valueOf("2025-03-19 19:39:51.057"));
        appointment.setSpSecurity(1);
        appointment.setCreateHosp("VH");
        appointment.setCreateBy("AWUSER");
        appointment.setCreateDatetime(Timestamp.valueOf("2025-03-19 19:39:51.057"));
        appointment.setUpdateBy("AWUSER");
        appointment.setUpdateDatetime(Timestamp.valueOf("2025-03-19 19:47:41.407"));
        appointment.setUploaded("O");
        appointment.setPatientNo(Integer.parseInt(patientNo));
        appointment.setPrivateField("N");
        appointment.setAttnByWs("HAHOPAS001");
        appointment.setHospital("VH");
        appointment.setConsultStatus("");
        appointment.setPriorityType("");

        return JSON.parseObject(JSON.toJSONString(appointment), clazz);
    }

    private String getTableName(Class<?> appointmentClass) {
        Table tableAnnotation = appointmentClass.getAnnotation(Table.class);
        if (tableAnnotation != null) {
            return tableAnnotation.name();
        }
        throw new IllegalArgumentException("Class " + appointmentClass.getName() + " does not have a @Table annotation.");
    }
}
