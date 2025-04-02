package org.hc.lj.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ImpactOfDifferentPaginationServiceTest {

    @Autowired
    private ImpactOfDifferentPaginationService impactOfDifferentPaginationService;

    @Test
    public void testQuery50() {
        impactOfDifferentPaginationService.query50("A%");
    }

    @Test
    public void testQuery1000() {
        impactOfDifferentPaginationService.query1000("A%");
    }

    @Test
    public void testQuery10000() {
        impactOfDifferentPaginationService.query10000("A%");
    }
}
