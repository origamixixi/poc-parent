package org.hc.jds.service;

import org.hc.jds.GlobalThreadPool;
import org.hc.jds.entity.db1.Patient10000;
import org.hc.jds.entity.db1.Patient10000000;
import org.hc.jds.entity.db1.Patient20000003000;
import org.hc.jds.entity.db1.Patient2000000500;
import org.hc.jds.entity.db2.Appointment100000;
import org.hc.jds.entity.db2.Appointment50000000;
import org.hc.jds.entity.db2.Appointment50000003000;
import org.hc.jds.entity.db2.Appointment5000000500;
import org.hc.jds.repository.db1.Patient10000000Repository;
import org.hc.jds.repository.db1.Patient10000Repository;
import org.hc.jds.repository.db1.Patient20000003000Repository;
import org.hc.jds.repository.db1.Patient2000000500Repository;
import org.hc.jds.repository.db2.Appointment100000Repository;
import org.hc.jds.repository.db2.Appointment50000000Repository;
import org.hc.jds.repository.db2.Appointment50000003000Repository;
import org.hc.jds.repository.db2.Appointment5000000500Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class ImpactOfDifferentDataSizeService {

    @Autowired
    private Patient10000Repository patient10000Repository;

    @Autowired
    private Patient20000003000Repository patient20000003000Repository;

    @Autowired
    private Patient10000000Repository patient10000000Repository;

    @Autowired
    private Appointment100000Repository appointment100000Repository;

    @Autowired
    private Appointment50000003000Repository appointment50000003000Repository;

    @Autowired
    private Appointment50000000Repository appointment50000000Repository;
    @Autowired
    private Patient2000000500Repository patient2000000500Repository;
    @Autowired
    private Appointment5000000500Repository appointment5000000500Repository;

    public List<Appointment100000> queryAppointment100000AndPatient10000(String hkidPrefix) {
        CompletableFuture<List<Patient10000>> cf1 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(0, 1000);
            return patient10000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<List<Appointment100000>> cf2 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(0, 1000);
            return appointment100000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<Void> cf = CompletableFuture.allOf(cf1, cf2);
        return cf.thenApply(v -> {
            List<Patient10000> result1 = cf1.join();
            List<Appointment100000> result2 = cf2.join();
            return result2;
        }).join();
    }

    public List<Appointment5000000500> queryAppointment5000000AndPatientPatient2000000(String hkidPrefix) {
        CompletableFuture<List<Patient2000000500>> cf1 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(0, 1000);
            return patient2000000500Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<List<Appointment5000000500>> cf2 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(0, 1000);
            return appointment5000000500Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<Void> cf = CompletableFuture.allOf(cf1, cf2);
        return cf.thenApply(v -> {
            List<Patient2000000500> result1 = cf1.join();
            List<Appointment5000000500> result2 = cf2.join();
            return result2;
        }).join();
    }

    public List<Appointment50000000> queryAppointment50000000AndPatient10000000(String hkidPrefix) {
        CompletableFuture<List<Patient10000000>> cf1 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(0, 1000);
            return patient10000000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<List<Appointment50000000>> cf2 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(0, 1000);
            return appointment50000000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<Void> cf = CompletableFuture.allOf(cf1, cf2);
        return cf.thenApply(v -> {
            List<Patient10000000> result1 = cf1.join();
            List<Appointment50000000> result2 = cf2.join();
            return result2;
        }).join();
    }
}
