package org.hc.jds.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ImpactOfDatabaseInstanceInvolvedServiceTest {

    @Autowired
    private ImpactOfDatabaseInstanceInvolvedService impactOfDatabaseInstanceInvolvedService;

    @Test
    public void queryTwoDatabaseInstanceInvolved() {
        impactOfDatabaseInstanceInvolvedService.queryTwoDatabaseInstanceInvolved("A%");
    }

    @Test
    public void queryThreeDatabaseInstanceInvolved() {
        impactOfDatabaseInstanceInvolvedService.queryThreeDatabaseInstanceInvolved("A%");
    }

    @Test
    public void queryFourDatabaseInstanceInvolved() {
        impactOfDatabaseInstanceInvolvedService.queryFourDatabaseInstanceInvolved("A%");
    }
}
