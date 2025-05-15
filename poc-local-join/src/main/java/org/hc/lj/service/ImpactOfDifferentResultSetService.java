package org.hc.lj.service;

import org.hc.lj.entity.Appointment500000010000;
import org.hc.lj.entity.Appointment50000003000;
import org.hc.lj.entity.Appointment5000000500;
import org.hc.lj.repository.Appointment500000010000Repository;
import org.hc.lj.repository.Appointment50000003000Repository;
import org.hc.lj.repository.Appointment5000000500Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpactOfDifferentResultSetService {

    @Autowired
    private Appointment5000000500Repository appointment5000000500Repository;

    @Autowired
    private Appointment50000003000Repository appointment50000003000Repository;

    @Autowired
    private Appointment500000010000Repository appointment500000010000Repository;

    public List<Appointment5000000500> queryResultSet500And500(String hkidPrefix, Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return appointment5000000500Repository.resultSetQuery(hkidPrefix, pageable);
    }

    public List<Appointment50000003000> queryResultSet3000And3000(String hkidPrefix, Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return appointment50000003000Repository.resultSetQuery(hkidPrefix, pageable);
    }

    public List<Appointment500000010000> queryResultSet10000And10000(String hkidPrefix, Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return appointment500000010000Repository.resultSetQuery(hkidPrefix, pageable);
    }

}
