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
public class ImpactOfAggregatedDataService {

    @Autowired
    private Appointment5000000500Repository appointment5000000500Repository;

    @Autowired
    private Appointment50000003000Repository appointment50000003000Repository;

    @Autowired
    private Appointment500000010000Repository appointment500000010000Repository;

    public List<Appointment5000000500> queryAppointment5000000500AndPatientPatient2000000500(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        return appointment5000000500Repository.aggregatedDataQuery(hkidPrefix, pageable);
    }

    public List<Appointment50000003000> queryAppointment50000003000AndPatientPatient20000003000(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        return appointment50000003000Repository.aggregatedDataQuery(hkidPrefix, pageable);
    }

    public List<Appointment500000010000> queryAppointment500000010000AndPatientPatient200000010000(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        return appointment500000010000Repository.aggregatedDataQuery(hkidPrefix, pageable);
    }

}
