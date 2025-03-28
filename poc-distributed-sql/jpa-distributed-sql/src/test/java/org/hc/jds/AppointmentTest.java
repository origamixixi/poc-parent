package org.hc.jds;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.hc.jds.entity.Appointment;
import org.hc.jds.entity.db2.Appointment100000;
import org.hc.jds.entity.db2.Appointment5000000;
import org.hc.jds.entity.db2.Appointment50000000;
import org.hc.jds.repository.db2.Appointment100000Repository;
import org.hc.jds.repository.db2.Appointment50000000Repository;
import org.hc.jds.repository.db2.Appointment5000000Repository;
import org.hc.jds.repository.db2.AppointmentTestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class AppointmentTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AppointmentTestRepository appointmentTestRepository;

    @Autowired
    private org.hc.jds.repository.db1.Appointment100000Repository  db1Appointment100000Repository;

    @Autowired
    private org.hc.jds.repository.db1.Appointment5000000Repository db1Appointment5000000Repository;

    @Autowired
    private org.hc.jds.repository.db1.Appointment50000000Repository db1Appointment50000000Repository;

    @Autowired
    private Appointment100000Repository appointment100000Repository;

    @Autowired
    private Appointment5000000Repository appointment5000000Repository;

    @Autowired
    private Appointment50000000Repository appointment50000000Repository;

    @Test
    public void findAll() {
        List<org.hc.jds.entity.db2.AppointmentTest> appointmentTest = appointmentTestRepository.findAll();
        log.info("appointmentTest: {}", JSON.toJSONString(appointmentTest));
    }

    @Test
    public void insertAppointment100000() {
        insertAppointments(500, 10_000,
                Appointment100000.class, appointment100000Repository::saveAll,
                org.hc.jds.entity.db1.Appointment100000 .class, db1Appointment100000Repository::saveAll);
    }

    @Test
    public void insertAppointment5000000() {
        insertAppointments(3_000, 5_000_000,
                Appointment5000000.class, appointment5000000Repository::saveAll,
                org.hc.jds.entity.db1.Appointment5000000 .class, db1Appointment5000000Repository::saveAll);
    }

    @Test
    public void insertAppointment50000000() {
        insertAppointments(10_000, 50_000_000,
                Appointment50000000.class, appointment50000000Repository::saveAll,
                org.hc.jds.entity.db1.Appointment50000000 .class, db1Appointment50000000Repository::saveAll);
    }

    private <T,V extends Appointment> void insertAppointments(int aggregatedSize, int totalAppointments,
                                                            Class<T> clazz, Consumer<Collection<T>> saveFunction,
                                                            Class<V> clazz2, Consumer<Collection<V>> saveFunction2) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // init table
        jdbcTemplate.execute("delete from " + getTableName(clazz));
        jdbcTemplate.execute("delete from " + getTableName(clazz2));

        int batchSize = 1000;

        Random random = new Random();
        List<Integer> aIndices = new ArrayList<>();

        // Generate all indices and randomly select 'aggregatedSize' indices for 'A' prefixed data
        for (int i = 0; i < totalAppointments; i++) {
            aIndices.add(i);
        }
        Collections.shuffle(aIndices);
        aIndices = aIndices.subList(0, aggregatedSize);

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

        List<T> appointments = new ArrayList<>();
        List<V> appointments2 = new ArrayList<>();
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

            AtomicInteger atomicInteger1 = new AtomicInteger(i);
            CompletableFuture<Void> cf1 = CompletableFuture.runAsync(() -> {
                T appointment = (T) createAppointment(prefix, counter, clazz, atomicInteger1.get());
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
            }, executorService);

            AtomicInteger atomicInteger2 = new AtomicInteger(i);
            CompletableFuture<Void> cf2 = CompletableFuture.runAsync(() -> {
                V appointment2 = (V) createAppointment(prefix, counter, clazz2, atomicInteger2.get());
                appointments2.add(appointment2);

                // Insert batch
                if (appointments2.size() >= batchSize) {
                    // Shuffle the list to randomize the order within the batch
                    Collections.shuffle(appointments2);

                    // Save all appointments in the current batch to the database
                    saveFunction2.accept(appointments2);

                    appointments2.clear();
                    log.info("Batch completed.");
                }
            }, executorService);

            CompletableFuture.allOf(cf1,cf2).join();
        }

        // Insert remaining appointments
        if (!appointments.isEmpty()) {
            // Shuffle the list to randomize the order within the batch
            Collections.shuffle(appointments);

            // Save all appointments in the current batch to the database
            saveFunction.accept(appointments);

            log.info("Remaining batch completed.");
        }

        // Insert remaining appointments
        if (!appointments2.isEmpty()) {
            // Shuffle the list to randomize the order within the batch
            Collections.shuffle(appointments2);

            // Save all appointments in the current batch to the database
            saveFunction2.accept(appointments2);

            log.info("Remaining batch completed.");
        }

        log.info("Insert operation completed.");
    }

    private Appointment createAppointment(String prefix, int counter, Class clazz, int index) {
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

        return (Appointment) JSON.parseObject(JSON.toJSONString(appointment), clazz);
    }

    private String getTableName(Class<?> appointmentClass) {
        Table tableAnnotation = appointmentClass.getAnnotation(Table.class);
        if (tableAnnotation != null) {
            return tableAnnotation.name();
        }
        throw new IllegalArgumentException("Class " + appointmentClass.getName() + " does not have a @Table annotation.");
    }
}
