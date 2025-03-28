package org.hc.jds;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.hc.jds.entity.Patient;
import org.hc.jds.entity.db1.Patient10000;
import org.hc.jds.entity.db1.Patient2000000;
import org.hc.jds.entity.db1.Patient10000000;
import org.hc.jds.repository.db1.Patient10000000Repository;
import org.hc.jds.repository.db1.Patient10000Repository;
import org.hc.jds.repository.db1.Patient2000000Repository;
import org.hc.jds.repository.db1.PatientTestRepository;
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
public class PatientTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PatientTestRepository patientTestRepository;

    @Autowired
    private Patient10000Repository patient10000Repository;

    @Autowired
    private Patient2000000Repository patient2000000Repository;

    @Autowired
    private Patient10000000Repository patient10000000Repository;

    @Test
    public void findAll() {
        List<org.hc.jds.entity.db1.PatientTest> patientTests = patientTestRepository.findAll();
        log.info("patientTest: {}", JSON.toJSONString(patientTests));
    }

    @Test
    public void insertPatient10000() {
        insertPatients(500, 10_000, Patient10000.class, patient10000Repository::saveAll);
    }

    @Test
    public void insertPatient2000000() {
        insertPatients(3_000, 2_000_000, Patient2000000.class, patient2000000Repository::saveAll);
    }

    @Test
    public void insertPatient10000000() {
        insertPatients(10_000, 10_000_000, Patient10000000.class, patient10000000Repository::saveAll);
    }

    private <T extends Patient> void insertPatients(int aggregatedSize, int totalPatients, Class<T> clazz, Consumer<Collection<T>> saveFunction) {
        // init table
        jdbcTemplate.execute("delete from " + getTableName(clazz));

        int batchSize = 1000;

        Random random = new Random();
        List<Integer> aIndices = new ArrayList<>();

        // Generate all indices and randomly select 'aggregatedSize' indices for 'A' prefixed data
        for (int i = 0; i < totalPatients; i++) {
            aIndices.add(i);
        }
        Collections.shuffle(aIndices);
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
                Collections.shuffle(patients);

                // Save all patients in the current batch to the database
                saveFunction.accept(patients);

                patients.clear();
                log.info("Batch completed.");
            }
        }

        // Insert remaining patients
        if (!patients.isEmpty()) {
            // Shuffle the list to randomize the order within the batch
            Collections.shuffle(patients);

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
