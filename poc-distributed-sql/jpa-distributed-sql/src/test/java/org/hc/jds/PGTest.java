package org.hc.jds;

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
    public void fix2() {
        String prefix = "B";
        int bPatientKey = 1247702;
        for (int counter = 501; counter <= 10000; counter++) {
            bPatientKey++;
            String oldPatientKey = "1" + String.format("%07d", counter);
            String newPatientKey = "2" + String.format("%07d", bPatientKey);
            String hkid = prefix + String.format("%07d", bPatientKey);
            String patientName = "Patient " + prefix + String.format("%07d", bPatientKey);
            String sql = String.format("""
                    update patient_10000000 set patient_key = '%s', hkid = '%s', patient_name = '%s' where patient_key = '%s';
                    """, newPatientKey, hkid, patientName, oldPatientKey);
            System.out.println(sql);
            jdbcTemplate.execute(sql);
//            break;
        }
//        jdbcTemplate.execute("update patient200000010000 set patient_key = 'A00000001' where patient_key = 'A00000002'");
    }
}
