package org.hc.lj.service;

import org.hc.lj.entity.Appointment50000003000;
import org.hc.lj.repository.Appointment50000003000Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpactOfDatabaseInstanceInvolvedService {

    @Autowired
    private Appointment50000003000Repository appointment50000003000Repository;

    public List<Appointment50000003000> queryTwoDatabaseInstanceInvolved(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        return appointment50000003000Repository.twoDatabaseInstanceInvolvedQuery(hkidPrefix, pageable);
    }

    public List<Appointment50000003000> queryThreeDatabaseInstanceInvolved(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        return appointment50000003000Repository.threeDatabaseInstanceInvolvedQuery(hkidPrefix, pageable);
    }

    public List<Appointment50000003000> queryFourDatabaseInstanceInvolved(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        return appointment50000003000Repository.fourDatabaseInstanceInvolvedQuery(hkidPrefix, pageable);
    }

}
