package org.hc.lj;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.hc.lj.entity.Cases;
import org.hc.lj.entity.Cases2000000;
import org.hc.lj.repository.Cases2000000Repository;
import org.hc.lj.repository.CasesTestRepository;
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
public class CasesTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CasesTestRepository casesTestRepository;

    @Autowired
    private Cases2000000Repository cases2000000Repository;

    @Test
    public void findAll() {
        List<org.hc.lj.entity.CasesTest> casesTests = casesTestRepository.findAll();
        log.info("casesTest: {}", JSON.toJSONString(casesTests));
    }

    @Test
    public void insertCases2000000() {
        insertCases(3_000, 2_000_000, Cases2000000.class, cases2000000Repository::saveAll);
    }

    private <T extends Cases> void insertCases(int aggregatedSize, int totalCases, Class<T> clazz, Consumer<Collection<T>> saveFunction) {
        // init table
        jdbcTemplate.execute("delete from " + getTableName(clazz));

        int batchSize = 1000;

        Random random = new Random();
        List<Integer> aIndices = new ArrayList<>();

        // Generate all indices and randomly select 'aggregatedSize' indices for 'A' prefixed data
        for (int i = 0; i < totalCases; i++) {
            aIndices.add(i);
        }
        Collections.shuffle(aIndices);
        aIndices = aIndices.subList(0, aggregatedSize);

        List<T> casess = new ArrayList<>();
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

        for (int i = 0; i < totalCases; i++) {
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

            T cases = createCase(prefix, counter, clazz);
            casess.add(cases);

            // Insert batch
            if (casess.size() >= batchSize) {
                // Shuffle the list to randomize the order within the batch
//                Collections.shuffle(casess);

                // Save all cases in the current batch to the database
                saveFunction.accept(casess);

                casess.clear();
                log.info("Batch completed.");
            }
        }

        // Insert remaining cases
        if (!casess.isEmpty()) {
            // Shuffle the list to randomize the order within the batch
//            Collections.shuffle(casess);

            // Save all cases in the current batch to the database
            saveFunction.accept(casess);

            log.info("Remaining batch completed.");
        }

        log.info("Insert operation completed.");
    }

    private <T> T createCase(String prefix, int counter, Class<T> clazz) {
        Cases cases = new Cases();
        char prefixChar = prefix.charAt(0);
        int patientKeyPrefix = prefixChar - 'A' + 1; // Calculate the prefix number based on the character
        String patientNo = String.format("%08d", patientKeyPrefix * 10000000L + counter);// Ensure caseNo is 8 digits with leading zeros
        cases.setCaseNo("TKG" + patientNo + "T");
        cases.setHospital("VH");
        cases.setOpcode("TKG1");
        cases.setOpsPatientNo(0);
        cases.setType("B");
        cases.setRegDatetime(Timestamp.valueOf("2024-11-13 15:22:06.617"));
        cases.setSpecialty("TKG1");
        cases.setSubSpecialty("TJR4");
        cases.setStatus("A");
        cases.setStatusDatetime(Timestamp.valueOf("2025-03-19 19:47:41.563"));
        cases.setSecurity((short) 0);
        cases.setSpSecurity((short) 0);
        cases.setHospSecurity((short) 0);
        cases.setMovementCount(null);
        cases.setDischargeStatus(null);
        cases.setDischargeDatetime(null);
        cases.setDischargeDestination(null);
        cases.setPayCode("");
        cases.setReference("");
        cases.setCreateBy("AWUSER");
        cases.setCreateDatetime(Timestamp.valueOf("2024-11-13 15:22:06.620"));
        cases.setUpdateBy("AWUSER");
        cases.setUpdateDatetime(Timestamp.valueOf("2025-03-19 19:47:41.563"));
        cases.setUploaded("Y");
        cases.setPatientNo(Integer.parseInt(patientNo)); // Ensure patientNo is calculated based on prefix and counter
        cases.setPpCode("NONE");

        return JSON.parseObject(JSON.toJSONString(cases), clazz);
    }

    private String getTableName(Class<?> patientClass) {
        Table tableAnnotation = patientClass.getAnnotation(Table.class);
        if (tableAnnotation != null) {
            return tableAnnotation.name();
        }
        throw new IllegalArgumentException("Class " + patientClass.getName() + " does not have a @Table annotation.");
    }
}
