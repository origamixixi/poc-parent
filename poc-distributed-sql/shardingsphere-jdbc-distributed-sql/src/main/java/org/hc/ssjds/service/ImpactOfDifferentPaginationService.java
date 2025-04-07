package org.hc.ssjds.service;

import org.hc.ssjds.GlobalThreadPool;
import org.hc.ssjds.entity.Appointment50000003000;
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
public class ImpactOfDifferentPaginationService {

    @Autowired
    private Patient20000003000Repository patient20000003000Repository;

    @Autowired
    private Appointment50000003000Repository appointment50000003000Repository;

    public List<Appointment50000003000> queryPagination50(String hkidPrefix) {
        CompletableFuture<List<Patient20000003000>> cf1 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(0, 50);
            return patient20000003000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<List<Appointment50000003000>> cf2 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(0, 50);
            return appointment50000003000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<Void> cf = CompletableFuture.allOf(cf1, cf2);
        return cf.thenApply(v -> {
            List<Patient20000003000> result1 = cf1.join();
            List<Appointment50000003000> result2 = cf2.join();
            return result2;
        }).join();
    }

    public List<Appointment50000003000> queryPagination1000(String hkidPrefix) {
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

    public List<Appointment50000003000> queryPagination10000(String hkidPrefix) {
        CompletableFuture<List<Patient20000003000>> cf1 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(0, 10000);
            return patient20000003000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<List<Appointment50000003000>> cf2 = CompletableFuture.supplyAsync(() -> {
            Pageable pageable = PageRequest.of(0, 10000);
            return appointment50000003000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        }, GlobalThreadPool.getExecutor());
        CompletableFuture<Void> cf = CompletableFuture.allOf(cf1, cf2);
        return cf.thenApply(v -> {
            List<Patient20000003000> result1 = cf1.join();
            List<Appointment50000003000> result2 = cf2.join();
            return result2;
        }).join();
    }
}
