package org.hc.lj;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.hc.lj.entity.*;
import org.hc.lj.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.*;
import java.util.function.Consumer;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class PatientTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PatientTestRepository patientTestRepository;

    @Autowired
    private Patient10000Repository patient10000Repository;

    @Autowired
    private Patient2000000500Repository patient2000000500Repository;

    @Autowired
    private Patient20000003000Repository patient20000003000Repository;

    @Autowired
    private Patient200000010000Repository patient200000010000Repository;

    @Autowired
    private Patient10000000Repository patient10000000Repository;


    @Test
    public void findAll() {
//        RowMapper<Patient2000000500> rowMapper = new BeanPropertyRowMapper<>(Patient2000000500.class);
//        List<Patient2000000500> patient2000000500s = jdbcTemplate.query("SELECT * FROM patient_2000000_500 p WHERE p.patient_key LIKE '1%' ORDER BY p.patient_key LIMIT 200", rowMapper);
//        List<org.hc.lj.entity.PatientTest> patientTests = patientTestRepository.findAll();
        RowMapper<Appointment5000000500> rowMapper = new BeanPropertyRowMapper<>(Appointment5000000500.class);
        List<Appointment5000000500> query = jdbcTemplate.query("SELECT * FROM appointment_5000000_500 a where a.patient_no::varchar LIKE '1%' order by a.patient_no limit 200", rowMapper);
        log.info("patientTest: {}", JSON.toJSONString(query));
    }

    @Test
    public void insertPatientTest() {
        insertPatients(100, 10_00, org.hc.lj.entity.PatientTest.class, patientTestRepository::saveAll);
    }

    /**
     * Insert 10,000 patient records into the database.
     */
    @Test
    public void insertPatient10000() {
        insertPatients(500, 10_000, Patient10000.class, patient10000Repository::saveAll);
    }

    /**
     * Insert 2,000,000 patient records into the database.
     */
    @Test
    public void insertPatient20000003000() {
        insertPatients(3_000, 2_000_000, Patient20000003000.class, patient20000003000Repository::saveAll);
    }
    @Test
    public void insertPatient2000000500() {
        insertPatients(500, 2_000_000, Patient2000000500.class, patient2000000500Repository::saveAll);
    }
    @Test
    public void insertPatient200000010000() {
        insertPatients(10_000, 2_000_000, Patient200000010000.class, patient200000010000Repository::saveAll);
    }

    /**
     * Insert 10,000,000 patient records into the database.
     */
    @Test
    public void insertPatient10000000() {
        insertPatients(3, 10, Patient10000000.class, patient10000000Repository::saveAll);
    }

    private <T extends Patient> void insertPatients(int aggregatedSize, int totalPatients, Class<T> clazz, Consumer<Collection<T>> saveFunction) {
        // Initialize the table by deleting all existing records.
        jdbcTemplate.execute("delete from " + getTableName(clazz));
        // Define the batch size for inserting patients
        int batchSize = 1000;

        Random random = new Random();
        List<Integer> aIndices = new ArrayList<>();

        // Generate all indices and randomly select 'aggregatedSize' indices for 'A' prefixed data
        for (int i = 0; i < totalPatients; i++) {
            aIndices.add(i);
        }
        // aIndices = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        // aIndices = [3, 1, 4, 0, 2, 7, 5, 9, 8, 6]
        Collections.shuffle(aIndices);
        // aIndices = [3, 1, 4]
        aIndices = aIndices.subList(0, aggregatedSize);

        List<T> patients = new ArrayList<>();
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

        for (int i = 0; i < totalPatients; i++) {
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

            T patient = createPatient(prefix, counter, clazz);
            patients.add(patient);

            // Insert batch
            if (patients.size() >= batchSize) {
                // Shuffle the list to randomize the order within the batch
//                Collections.shuffle(patients);

                // Save all patients in the current batch to the database
                saveFunction.accept(patients);

                patients.clear();
                log.info("Batch completed.");
            }
        }

        // Insert remaining patients
        if (!patients.isEmpty()) {
            // Shuffle the list to randomize the order within the batch
//            Collections.shuffle(patients);

            // Save all patients in the current batch to the database
            saveFunction.accept(patients);

            log.info("Remaining batch completed.");
        }

        log.info("Insert operation completed.");
    }

    private <T> T createPatient(String prefix, int counter, Class<T> clazz) {
        Patient patient = new Patient();
        char prefixChar = prefix.charAt(0);
        int patientKeyPrefix = prefixChar - 'A' + 1; // Calculate the prefix number based on the character
        String patientKey = String.format("%08d", patientKeyPrefix * 10000000L + counter); // Ensure patientKey is 8 digits with leading zeros
        patient.setPatientKey(patientKey); // Ensure the first digit is the prefix number
        patient.setHkid(prefix + String.format("%07d", counter)); // Ensure HKID is 8 characters long
        patient.setPatientName("Patient " + prefix + String.format("%07d", counter));
        patient.setSex("M");
        patient.setDob(Timestamp.valueOf("1999-11-09 00:00:00.000"));
        patient.setExactDobFlag("Y");
        patient.setMaritalStatus("U");
        patient.setRace("UN");
        patient.setPatientType("DH1");
        patient.setPcsCount(0);
        patient.setAccessCode(2147483647);
        patient.setUpdateHospital("VH");
        patient.setSourceSystem("OPAS");
        patient.setUpdateBy("AWUSER");
        patient.setSourceSystemDtm(Timestamp.valueOf("2024-11-12 16:37:50.480"));
        patient.setSystemDtm(Timestamp.valueOf("2024-11-12 16:38:08.237"));
        patient.setRowUpdateDatetime(Timestamp.valueOf("2025-03-20 17:52:32.754"));
        patient.setFiller("9 A");

        return JSON.parseObject(JSON.toJSONString(patient), clazz);
    }

    private String getTableName(Class<?> patientClass) {
        Table tableAnnotation = patientClass.getAnnotation(Table.class);
        if (tableAnnotation != null) {
            return tableAnnotation.name();
        }
        throw new IllegalArgumentException("Class " + patientClass.getName() + " does not have a @Table annotation.");
    }
}
