package org.hc.lj.service;

import org.hc.lj.entity.Appointment100000;
import org.hc.lj.entity.Appointment50000003000;
import org.hc.lj.entity.Appointment50000000;
import org.hc.lj.entity.Appointment5000000500;
import org.hc.lj.repository.Appointment100000Repository;
import org.hc.lj.repository.Appointment50000000Repository;
import org.hc.lj.repository.Appointment50000003000Repository;
import org.hc.lj.repository.Appointment5000000500Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpactOfDifferentDataSizeService {

    @Autowired
    private Appointment100000Repository appointment100000Repository;

    @Autowired
    private Appointment5000000500Repository appointment5000000500Repository;

    @Autowired
    private Appointment50000000Repository appointment50000000Repository;

    public List<Appointment100000> queryAppointment100000AndPatient10000(String hkidPrefix, Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return appointment100000Repository.dataSizeQuery(hkidPrefix, pageable);
    }

    public List<Appointment5000000500> queryAppointment5000000AndPatientPatient2000000(String hkidPrefix, Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return appointment5000000500Repository.dataSizeQuery(hkidPrefix, pageable);
    }

    public List<Appointment50000000> queryAppointment50000000AndPatient10000000(String hkidPrefix, Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return appointment50000000Repository.dataSizeQuery(hkidPrefix, pageable);
    }
}
