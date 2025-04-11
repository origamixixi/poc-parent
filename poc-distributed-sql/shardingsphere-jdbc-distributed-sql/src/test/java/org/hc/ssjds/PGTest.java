package org.hc.ssjds;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class PGTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void fix() {
        int bPatientKey = 6253665;
        for (int counter = 501; counter <= 10000; counter++) {
            bPatientKey++;
            String key = "2" + String.format("%07d", bPatientKey);
            int oldPatientKey = Integer.parseInt("1" + String.format("%07d", counter));
            int newPatientKey = Integer.parseInt(key);
            String caseNo = "TKG" + key + "T";
            String sql = String.format("""
                    update appointment_50000000 set patient_no = %s, case_no = '%s', ops_patient_no = %s where patient_no = %s;
                    """, newPatientKey, caseNo, newPatientKey, oldPatientKey);
            System.out.println(sql);
            jdbcTemplate.execute(sql);
//            break;
        }
    }
}
