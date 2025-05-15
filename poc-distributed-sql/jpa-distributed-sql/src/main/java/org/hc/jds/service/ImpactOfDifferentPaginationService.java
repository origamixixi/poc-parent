package org.hc.jds.service;

import org.hc.jds.GlobalThreadPool;
import org.hc.jds.entity.db1.Patient20000003000;
import org.hc.jds.entity.db2.Appointment50000003000;
import org.hc.jds.repository.db1.Patient20000003000Repository;
import org.hc.jds.repository.db2.Appointment50000003000Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ImpactOfDifferentPaginationService {

    @Autowired
    private Patient20000003000Repository patient20000003000Repository;
    @Autowired
    private Appointment50000003000Repository appointment50000003000Repository;

    public List<Appointment50000003000> queryPagination50(String hkidPrefix, Integer pageNo, Integer pageSize) {
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

    public List<Appointment50000003000> queryPagination1000(String hkidPrefix, Integer pageNo, Integer pageSize) {
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

    public List<Appointment50000003000> queryPagination10000(String hkidPrefix, Integer pageNo, Integer pageSize) {
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
}
