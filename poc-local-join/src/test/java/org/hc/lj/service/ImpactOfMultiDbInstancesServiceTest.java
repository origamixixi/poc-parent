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
public class ImpactOfMultiDbInstancesServiceTest {

    @Autowired
    private ImpactOfMultiDbInstancesService impactOfMultiDbInstancesService;

    @Test
    public void queryTwoDatabaseInstanceInvolved() {
        impactOfMultiDbInstancesService.queryTwoDatabaseInstanceInvolved("A%");
    }

    @Test
    public void queryThreeDatabaseInstanceInvolved() {
        impactOfMultiDbInstancesService.queryThreeDatabaseInstanceInvolved("A%");
    }

    @Test
    public void queryFourDatabaseInstanceInvolved() {
        impactOfMultiDbInstancesService.queryFourDatabaseInstanceInvolved("A%");
    }
}
