package org.hc.ssjds;

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
        String sql = "";

        sql = "select * from appointment_test";
        log.info("result: {}", JSON.toJSONString(jdbcTemplate.queryForList(sql)));

        sql = "select * from patient_test";
        log.info("result: {}", JSON.toJSONString(jdbcTemplate.queryForList(sql)));

        sql = "select * from cases_test";
        log.info("result: {}", JSON.toJSONString(jdbcTemplate.queryForList(sql)));

        sql = "select * from case_patient_condition_test";
        log.info("result: {}", JSON.toJSONString(jdbcTemplate.queryForList(sql)));
    }
}
