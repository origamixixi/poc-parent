package org.hc.lj.service;

import org.hc.lj.entity.Appointment50000003000;
import org.hc.lj.repository.Appointment50000003000Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpactOfTypeOfJoinAndSubqueryService {

    @Autowired
    private Appointment50000003000Repository appointment50000003000Repository;

    public List<Appointment50000003000> queryTypeOfJoin(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        return appointment50000003000Repository.typeOfJoinQuery(hkidPrefix, pageable);
    }

    public List<Appointment50000003000> queryTypeOfLeftJoin(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        return appointment50000003000Repository.typeOfLeftJoinQuery(hkidPrefix, pageable);
    }

    public List<Appointment50000003000> queryTypeOfSub(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        return appointment50000003000Repository.typeOfSubQuery(hkidPrefix, pageable);
    }
}
