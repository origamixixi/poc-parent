package org.hc.ssjds.service;

import org.hc.ssjds.GlobalThreadPool;
import org.hc.ssjds.entity.Appointment50000000;
import org.hc.ssjds.entity.Appointment50000003000;
import org.hc.ssjds.entity.Patient10000000;
import org.hc.ssjds.entity.Patient20000003000;
import org.hc.ssjds.repository.Appointment50000003000Repository;
import org.hc.ssjds.repository.Patient20000003000Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ImpactOfDifferentJoinAndSubqueryService {

    @Autowired
    private Patient20000003000Repository patient20000003000Repository;

    @Autowired
    private Appointment50000003000Repository appointment50000003000Repository;

    public List<Appointment50000003000> queryTypeOfJoin(String hkidPrefix) {
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
            List<Integer> patientNos = cf1.join().stream().map(Patient20000003000::getPatientKey).map(Integer::parseInt).toList();
            List<Appointment50000003000> result =  cf2.join().stream().filter(appointment -> patientNos.contains(appointment.getPatientNo())).toList();
            return result;
        }).join();
    }

    public List<Appointment50000003000> queryTypeOfLeftJoin(String hkidPrefix) {
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
            List<Patient20000003000> join = cf1.join();
            List<Appointment50000003000> result =  cf2.join();
            return result;
        }).join();
    }

    public List<Appointment50000003000> queryTypeOfSub(String hkidPrefix) {
        return CompletableFuture.supplyAsync(() -> {
            return patient20000003000Repository.queryLikeHKIDPrefix(hkidPrefix, null);
        }, GlobalThreadPool.getExecutor()).thenApply(v -> {
            List<Integer> patientNos = v.stream().map(Patient20000003000::getPatientKey).map(Integer::parseInt).toList();
            Pageable pageable = PageRequest.of(0, 1000);
            return appointment50000003000Repository.queryInHKID(patientNos, pageable);
        }).join();
    }
}
