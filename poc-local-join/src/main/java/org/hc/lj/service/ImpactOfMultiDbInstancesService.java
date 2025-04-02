package org.hc.lj.service;

import org.hc.lj.entity.Appointment50000003000;
import org.hc.lj.repository.Appointment50000003000Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpactOfMultiDbInstancesService {

    @Autowired
    private Appointment50000003000Repository appointment50000003000Repository;

    public List<Appointment50000003000> queryTwoDatabaseInstance(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        return appointment50000003000Repository.twoDatabaseInstanceQuery(hkidPrefix, pageable);
    }

    public List<Appointment50000003000> queryThreeDatabaseInstance(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        return appointment50000003000Repository.threeDatabaseInstanceQuery(hkidPrefix, pageable);
    }

    public List<Appointment50000003000> queryFourDatabaseInstance(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        return appointment50000003000Repository.fourDatabaseInstanceQuery(hkidPrefix, pageable);
    }

}
