package org.hc.jds;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.hc.jds.entity.CasePatientCondition;
import org.hc.jds.entity.db4.CasePatientCondition2000000;
import org.hc.jds.repository.db4.CasePatientCondition2000000Repository;
import org.hc.jds.repository.db4.CasePatientConditionTestRepository;
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
public class CasePatientConditionTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CasePatientConditionTestRepository casePatientConditionTestRepository;

    @Autowired
    private CasePatientCondition2000000Repository casePatientCondition2000000Repository;

    @Test
    public void findAll() {
        List<org.hc.jds.entity.db4.CasePatientConditionTest> casePatientConditionTests = casePatientConditionTestRepository.findAll();
        log.info("appointmentTest: {}", JSON.toJSONString(casePatientConditionTests));
    }


    @Test
    public void insertCasePatientCondition() {
        insertCasePatientConditions(50, 1000, CasePatientCondition2000000.class, casePatientCondition2000000Repository::saveAll);
    }

    private <T extends CasePatientCondition> void insertCasePatientConditions(int aggregatedSize, int totalRecords, Class<T> clazz, Consumer<Collection<T>> saveFunction) {
        // init table
        jdbcTemplate.execute("delete from " + getTableName(clazz));

        int batchSize = 1000;

        Random random = new Random();
        List<Integer> aIndices = new ArrayList<>();

        // Generate all indices and randomly select 'aggregatedSize' indices for 'A' prefixed data
        for (int i = 0; i < totalRecords; i++) {
            aIndices.add(i);
        }
        Collections.shuffle(aIndices);
        aIndices = aIndices.subList(0, aggregatedSize);

        List<T> casePatientConditions = new ArrayList<>();
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

        for (int i = 0; i < totalRecords; i++) {
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

            T casePatientCondition = createCasePatientCondition(prefix, counter, clazz);
            casePatientConditions.add(casePatientCondition);

            // Insert batch
            if (casePatientConditions.size() >= batchSize) {
                // Shuffle the list to randomize the order within the batch
                Collections.shuffle(casePatientConditions);

                // Save all records in the current batch to the database
                saveFunction.accept(casePatientConditions);

                casePatientConditions.clear();
                log.info("Batch completed.");
            }
        }

        // Insert remaining records
        if (!casePatientConditions.isEmpty()) {
            // Shuffle the list to randomize the order within the batch
            Collections.shuffle(casePatientConditions);

            // Save all records in the current batch to the database
            saveFunction.accept(casePatientConditions);

            log.info("Remaining batch completed.");
        }

        log.info("Insert operation completed.");
    }

    private <T> T createCasePatientCondition(String prefix, int counter, Class<T> clazz) {
        CasePatientCondition casePatientCondition = new CasePatientCondition();
        char prefixChar = prefix.charAt(0);
        int patientKeyPrefix = prefixChar - 'A' + 1; // Calculate the prefix number based on the character
        String patientNo = String.format("%08d", patientKeyPrefix * 10000000L + counter); // Ensure patientNo is 8 digits with leading zeros
        casePatientCondition.setPatientNo(Integer.parseInt(patientNo)); // Ensure the first digit is the prefix number
        casePatientCondition.setHospital("VH");
        casePatientCondition.setCaseNo("TKG" + patientNo + "T");
        casePatientCondition.setPc1L1("ABDP");
        casePatientCondition.setPc2L1("AF");
        casePatientCondition.setPc3L1("ALW");
        casePatientCondition.setPc4L1("CAU");
        casePatientCondition.setPc5L1("DM");
        casePatientCondition.setPc6L1("ERTD");
        casePatientCondition.setPc1L2("");
        casePatientCondition.setPc2L2("");
        casePatientCondition.setPc3L2("");
        casePatientCondition.setPc4L2("");
        casePatientCondition.setPc5L2("");
        casePatientCondition.setPc6L2("");
        casePatientCondition.setUpdateBy("AWUSER");
        casePatientCondition.setUpdateDatetime(Timestamp.valueOf("2025-03-17 16:07:43.730"));
        casePatientCondition.setCaseSpecialty("DIET");

        return JSON.parseObject(JSON.toJSONString(casePatientCondition), clazz);
    }

    private String getTableName(Class<?> clazz) {
        Table tableAnnotation = clazz.getAnnotation(Table.class);
        if (tableAnnotation != null) {
            return tableAnnotation.name();
        }
        throw new IllegalArgumentException("Class " + clazz.getName() + " does not have a @Table annotation.");
    }
}
