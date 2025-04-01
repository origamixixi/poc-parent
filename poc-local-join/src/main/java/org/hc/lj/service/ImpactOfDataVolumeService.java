package org.hc.lj.service;

import org.hc.lj.entity.Appointment100000;
import org.hc.lj.entity.Appointment50000003000;
import org.hc.lj.entity.Appointment50000000;
import org.hc.lj.repository.Appointment100000Repository;
import org.hc.lj.repository.Appointment50000000Repository;
import org.hc.lj.repository.Appointment50000003000Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpactOfDataVolumeService {

    @Autowired
    private Appointment100000Repository appointment100000Repository;

    @Autowired
    private Appointment50000003000Repository appointment50000003000Repository;

    @Autowired
    private Appointment50000000Repository appointment50000000Repository;

    public List<Appointment100000> queryAppointment100000AndPatient10000(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        return appointment100000Repository.dataVolumeQuery(hkidPrefix, pageable);
    }

    public List<Appointment50000003000> queryAppointment5000000AndPatientPatient2000000(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        return appointment50000003000Repository.dataVolumeQuery(hkidPrefix, pageable);
    }

    public List<Appointment50000000> queryAppointment50000000AndPatient10000000(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        return appointment50000000Repository.dataVolumeQuery(hkidPrefix, pageable);
    }
}
