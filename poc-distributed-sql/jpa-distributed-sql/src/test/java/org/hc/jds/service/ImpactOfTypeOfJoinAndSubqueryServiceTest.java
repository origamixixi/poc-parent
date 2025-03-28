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
public class ImpactOfTypeOfJoinAndSubqueryServiceTest {

    @Autowired
    private ImpactOfTypeOfJoinAndSubqueryService impactOfTypeOfJoinAndSubqueryService;

    @Test
    public void queryTypeOfJoin() {
        impactOfTypeOfJoinAndSubqueryService.queryTypeOfJoin("A%");
    }

    @Test
    public void queryTypeOfLeftJoin() {
        impactOfTypeOfJoinAndSubqueryService.queryTypeOfLeftJoin("A%");
    }

    @Test
    public void queryTypeOfSub() {
        impactOfTypeOfJoinAndSubqueryService.queryTypeOfSub("A%");
    }

}
