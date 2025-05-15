package org.hc.ssjds.service;

import org.hc.ssjds.GlobalThreadPool;
import org.hc.ssjds.entity.*;
import org.hc.ssjds.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ImpactOfDifferentResultSetService {

    @Autowired
    private Patient2000000500Repository patient2000000500Repository;

    @Autowired
    private Patient20000003000Repository patient20000003000Repository;

    @Autowired
    private Patient200000010000Repository patient200000010000Repository;

    @Autowired
    private Appointment5000000500Repository appointment5000000500Repository;

    @Autowired
    private Appointment50000003000Repository appointment50000003000Repository;

    @Autowired
    private Appointment500000010000Repository appointment500000010000Repository;

    public List<Appointment5000000500> queryResultSet500And500(String hkidPrefix, Integer pageNo, Integer pageSize) {
        CompletableFuture<List<Patient2000000500>> cf1 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(0, 500);
            return patient2000000500Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<List<Appointment5000000500>> cf2 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(0, 500);
            return appointment5000000500Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<Void> cf = CompletableFuture.allOf(cf1, cf2);
        return cf.thenApply(v -> {
            List<Integer> patientNos = cf1.join().stream().map(Patient2000000500::getPatientKey).map(Integer::parseInt).toList();
            List<Appointment5000000500> result =  cf2.join().stream().filter(appointment -> patientNos.contains(appointment.getPatientNo())).toList();
            return result;
        }).join();
    }

    public List<Appointment50000003000> queryResultSet3000And3000(String hkidPrefix, Integer pageNo, Integer pageSize) {
        CompletableFuture<List<Patient20000003000>> cf1 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(0, 500);
            return patient20000003000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<List<Appointment50000003000>> cf2 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(0, 500);
            return appointment50000003000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<Void> cf = CompletableFuture.allOf(cf1, cf2);
        return cf.thenApply(v -> {
            List<Integer> patientNos = cf1.join().stream().map(Patient20000003000::getPatientKey).map(Integer::parseInt).toList();
            List<Appointment50000003000> result =  cf2.join().stream().filter(appointment -> patientNos.contains(appointment.getPatientNo())).toList();
            return result;
        }).join();
    }

    public List<Appointment500000010000> queryResultSet10000And10000(String hkidPrefix, Integer pageNo, Integer pageSize) {
        CompletableFuture<List<Patient200000010000>> cf1 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(0, 500);
            return patient200000010000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<List<Appointment500000010000>> cf2 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(0, 500);
            return appointment500000010000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<Void> cf = CompletableFuture.allOf(cf1, cf2);
        return cf.thenApply(v -> {
            List<Integer> patientNos = cf1.join().stream().map(Patient200000010000::getPatientKey).map(Integer::parseInt).toList();
            List<Appointment500000010000> result =  cf2.join().stream().filter(appointment -> patientNos.contains(appointment.getPatientNo())).toList();
            return result;
        }).join();
    }

}
