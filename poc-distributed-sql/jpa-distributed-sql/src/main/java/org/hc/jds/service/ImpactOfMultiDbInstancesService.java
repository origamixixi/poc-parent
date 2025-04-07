package org.hc.jds.service;

import org.hc.jds.GlobalThreadPool;
import org.hc.jds.entity.db1.Patient20000003000;
import org.hc.jds.entity.db2.Appointment50000003000;
import org.hc.jds.entity.db3.Cases2000000;
import org.hc.jds.entity.db4.CasePatientCondition2000000;
import org.hc.jds.repository.db1.Patient20000003000Repository;
import org.hc.jds.repository.db2.Appointment50000003000Repository;
import org.hc.jds.repository.db3.Cases2000000Repository;
import org.hc.jds.repository.db4.CasePatientCondition2000000Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ImpactOfMultiDbInstancesService {

    @Autowired
    private Patient20000003000Repository patient20000003000Repository;

    @Autowired
    private Appointment50000003000Repository appointment50000003000Repository;

    @Autowired
    private Cases2000000Repository cases2000000Repository;

    @Autowired
    private CasePatientCondition2000000Repository casePatientCondition2000000Repository;

    public List<Appointment50000003000> queryTwoDatabaseInstance(String hkidPrefix) {
        CompletableFuture<List<Patient20000003000>> cf1 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(0, 1000);
            return patient20000003000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<List<Appointment50000003000>> cf2 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(0, 1000);
            return appointment50000003000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<Void> cf = CompletableFuture.allOf(cf1, cf2);
        return cf.thenApply(v -> {
            List<Patient20000003000> result1 = cf1.join();
            List<Appointment50000003000> result2 = cf2.join();
            return result2;
        }).join();
    }

    public List<Appointment50000003000> queryThreeDatabaseInstance(String hkidPrefix) {
        CompletableFuture<List<Patient20000003000>> cf1 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(0, 1000);
            return patient20000003000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<List<Appointment50000003000>> cf2 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(0, 1000);
            return appointment50000003000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<List<Cases2000000>> cf3 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(0, 1000);
            return cases2000000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<Void> cf = CompletableFuture.allOf(cf1, cf2, cf3);
        return cf.thenApply(v -> {
            List<Patient20000003000> result1 = cf1.join();
            List<Appointment50000003000> result2 = cf2.join();
            List<Cases2000000> result3 = cf3.join();
            return result2;
        }).join();
    }

    public List<Appointment50000003000> queryFourDatabaseInstance(String hkidPrefix) {
        CompletableFuture<List<Patient20000003000>> cf1 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(0, 1000);
            return patient20000003000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<List<Appointment50000003000>> cf2 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(0, 1000);
            return appointment50000003000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<List<Cases2000000>> cf3 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(0, 1000);
            return cases2000000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture.allOf(cf1, cf2, cf3).join();
        CompletableFuture<List<CasePatientCondition2000000>> cf4 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(0, 1000);
            return casePatientCondition2000000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<Void> cf = CompletableFuture.allOf(cf1, cf2, cf3, cf4);
        return cf.thenApply(v -> {
            List<Patient20000003000> result1 = cf1.join();
            List<Appointment50000003000> result2 = cf2.join();
            List<Cases2000000> result3 = cf3.join();
            List<CasePatientCondition2000000> result4 = cf4.join();
            return result2;
        }).join();
    }

}
