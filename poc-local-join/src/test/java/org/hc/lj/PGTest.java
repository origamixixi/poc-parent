package org.hc.lj;

import com.alibaba.fastjson2.JSON;
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
    public void selectAll() {
        String sql = """
                select *
                from appointment_test a
                inner join patient_test p on a.patient_no::varchar = p.patient_key
                inner join cases_test e on a.patient_no = e.patient_no
                inner join case_patient_condition_test r on a.patient_no = r.patient_no
                """;
        log.info("result: {}", JSON.toJSONString(jdbcTemplate.queryForList(sql)));
    }
}
