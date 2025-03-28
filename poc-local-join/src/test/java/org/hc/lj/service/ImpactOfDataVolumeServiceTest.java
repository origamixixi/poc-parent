package org.hc.lj.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ImpactOfDataVolumeServiceTest {

    @Autowired
    private ImpactOfDataVolumeService impactOfDataVolumeService;

    @Test
    public void testQueryAppointment100000AndPatient10000() {
        long start = System.currentTimeMillis();
        impactOfDataVolumeService.queryAppointment100000AndPatient10000("A%");
        long end = System.currentTimeMillis();
        log.info("{}", end - start);
    }

    @Test
    public void testQueryAppointment5000000AndPatientPatient2000000() {
        impactOfDataVolumeService.queryAppointment5000000AndPatientPatient2000000("A%");
    }

    @Test
    public void testQueryAppointment50000000AndPatient10000000() {
        impactOfDataVolumeService.queryAppointment50000000AndPatient10000000("A%");
    }
}
