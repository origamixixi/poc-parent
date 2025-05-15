package org.hc.ssjds.service;

import org.hc.ssjds.GlobalThreadPool;
import org.hc.ssjds.entity.*;
import org.hc.ssjds.repository.Appointment50000003000Repository;
import org.hc.ssjds.repository.CasePatientCondition2000000Repository;
import org.hc.ssjds.repository.Cases2000000Repository;
import org.hc.ssjds.repository.Patient20000003000Repository;
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

    public List<Appointment50000003000> queryTwoDatabaseInstance(String hkidPrefix, Integer pageNo, Integer pageSize) {
        CompletableFuture<List<Patient20000003000>> cf1 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(pageNo, pageSize);
            return patient20000003000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<List<Appointment50000003000>> cf2 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(pageNo, pageSize);
            return appointment50000003000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<Void> cf = CompletableFuture.allOf(cf1, cf2);
        return cf.thenApply(v -> {
            List<Integer> patientNos = cf1.join().stream().map(Patient20000003000::getPatientKey).map(Integer::parseInt).toList();
            List<Appointment50000003000> result =  cf2.join().stream().filter(appointment -> patientNos.contains(appointment.getPatientNo())).toList();
            return result;
        }).join();
    }

    public List<Appointment50000003000> queryThreeDatabaseInstance(String hkidPrefix, Integer pageNo, Integer pageSize) {
        CompletableFuture<List<Patient20000003000>> cf1 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(pageNo, pageSize);
            return patient20000003000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<List<Appointment50000003000>> cf2 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(pageNo, pageSize);
            return appointment50000003000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<List<Cases2000000>> cf3 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(pageNo, pageSize);
            return cases2000000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<Void> cf = CompletableFuture.allOf(cf1, cf2, cf3);
        return cf.thenApply(v -> {
            List<Integer> patientNos = cf1.join().stream().map(Patient20000003000::getPatientKey).map(Integer::parseInt).toList();
            List<Integer> patientNos3 = cf3.join().stream().map(Cases2000000::getPatientNo).toList();
            List<Appointment50000003000> result =  cf2.join().stream()
                    .filter(appointment -> patientNos.contains(appointment.getPatientNo()))
                    .filter(appointment -> patientNos3.contains(appointment.getPatientNo()))
                    .toList();
            return result;
        }).join();
    }

    public List<Appointment50000003000> queryFourDatabaseInstance(String hkidPrefix, Integer pageNo, Integer pageSize) {
        CompletableFuture<List<Patient20000003000>> cf1 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(pageNo, pageSize);
            return patient20000003000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<List<Appointment50000003000>> cf2 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(pageNo, pageSize);
            return appointment50000003000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<List<Cases2000000>> cf3 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(pageNo, pageSize);
            return cases2000000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture.allOf(cf1, cf2, cf3).join();
        CompletableFuture<List<CasePatientCondition2000000>> cf4 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(pageNo, pageSize);
            return casePatientCondition2000000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<Void> cf = CompletableFuture.allOf(cf1, cf2, cf3, cf4);
        return cf.thenApply(v -> {
            List<Integer> patientNos = cf1.join().stream().map(Patient20000003000::getPatientKey).map(Integer::parseInt).toList();
            List<Integer> patientNos3 = cf3.join().stream().map(Cases2000000::getPatientNo).toList();
            List<Integer> patientNos4 = cf4.join().stream().map(CasePatientCondition2000000::getPatientNo).toList();
            List<Appointment50000003000> result =  cf2.join().stream()
                    .filter(appointment -> patientNos.contains(appointment.getPatientNo()))
                    .filter(appointment -> patientNos3.contains(appointment.getPatientNo()))
                    .filter(appointment -> patientNos4.contains(appointment.getPatientNo()))
                    .toList();
            return result;
        }).join();
    }

}
