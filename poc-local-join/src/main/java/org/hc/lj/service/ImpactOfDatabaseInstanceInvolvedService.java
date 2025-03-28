package org.hc.lj.service;

import org.hc.lj.entity.Appointment5000000;
import org.hc.lj.repository.Appointment5000000Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpactOfDatabaseInstanceInvolvedService {

    @Autowired
    private Appointment5000000Repository appointment5000000Repository;

    public List<Appointment5000000> queryTwoDatabaseInstanceInvolved(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        return appointment5000000Repository.twoDatabaseInstanceInvolvedQuery(hkidPrefix, pageable);
    }

    public List<Appointment5000000> queryThreeDatabaseInstanceInvolved(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        return appointment5000000Repository.threeDatabaseInstanceInvolvedQuery(hkidPrefix, pageable);
    }

    public List<Appointment5000000> queryFourDatabaseInstanceInvolved(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        return appointment5000000Repository.fourDatabaseInstanceInvolvedQuery(hkidPrefix, pageable);
    }

}
