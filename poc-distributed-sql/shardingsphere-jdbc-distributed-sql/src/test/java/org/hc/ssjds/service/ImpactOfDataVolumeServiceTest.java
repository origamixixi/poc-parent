package org.hc.ssjds.service;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ImpactOfDataVolumeServiceTest {

    @Autowired
    private ImpactOfDataVolumeService impactOfDataVolumeService;

    @Test
    public void testQueryAppointment100000AndPatient10000() {
        impactOfDataVolumeService.queryAppointment100000AndPatient10000("A%");
    }

    @Test
    public void testQueryAppointment5000000AndPatientPatient2000000() {
        impactOfDataVolumeService.queryAppointment5000000AndPatient2000000("A%");

    }

    @Test
    public void testQueryAppointment50000000AndPatient10000000() {
        impactOfDataVolumeService.queryAppointment50000000AndPatient10000000("A%");
    }
}
