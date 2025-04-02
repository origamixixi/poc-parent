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
public class ImpactOfDifferentJoinAndSubqueryServiceTest {

    @Autowired
    private ImpactOfDifferentJoinAndSubqueryService impactOfDifferentJoinAndSubqueryService;

    @Test
    public void queryTypeOfJoin() {
        impactOfDifferentJoinAndSubqueryService.queryTypeOfJoin("A%");
    }

    @Test
    public void queryTypeOfLeftJoin() {
        impactOfDifferentJoinAndSubqueryService.queryTypeOfLeftJoin("A%");
    }

    @Test
    public void queryTypeOfSub() {
        impactOfDifferentJoinAndSubqueryService.queryTypeOfSub("A%");
    }

}
