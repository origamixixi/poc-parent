package org.hc.jds.service;

import org.hc.jds.entity.db1.Patient10000;
import org.hc.jds.entity.db1.Patient10000000;
import org.hc.jds.entity.db1.Patient2000000;
import org.hc.jds.entity.db2.Appointment100000;
import org.hc.jds.entity.db2.Appointment5000000;
import org.hc.jds.entity.db2.Appointment50000000;
import org.hc.jds.repository.db1.Patient10000000Repository;
import org.hc.jds.repository.db1.Patient10000Repository;
import org.hc.jds.repository.db1.Patient2000000Repository;
import org.hc.jds.repository.db2.Appointment100000Repository;
import org.hc.jds.repository.db2.Appointment50000000Repository;
import org.hc.jds.repository.db2.Appointment5000000Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImpactOfDataVolumeService {

    @Autowired
    private Patient10000Repository patient10000Repository;

    @Autowired
    private Patient2000000Repository patient2000000Repository;

    @Autowired
    private Patient10000000Repository patient10000000Repository;

    @Autowired
    private Appointment100000Repository appointment100000Repository;

    @Autowired
    private Appointment5000000Repository appointment5000000Repository;

    @Autowired
    private Appointment50000000Repository appointment50000000Repository;

    public List<Appointment100000> queryAppointment100000AndPatient10000(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        List<Patient10000> patients = patient10000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        List<Integer> patientKeys = patients.stream()
                .map(Patient10000::getPatientKey)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return appointment100000Repository.findByPatientNoIn(patientKeys);
    }


    public List<Appointment5000000> queryAppointment5000000AndPatient2000000(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        List<Patient2000000> patients = patient2000000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        List<Integer> patientKeys = patients.stream()
                .map(Patient2000000::getPatientKey)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return appointment5000000Repository.findByPatientNoIn(patientKeys);
    }

    public List<Appointment50000000> queryAppointment50000000AndPatient10000000(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        List<Patient10000000> patients = patient10000000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        List<Integer> patientKeys = patients.stream()
                .map(Patient10000000::getPatientKey)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return appointment50000000Repository.findByPatientNoIn(patientKeys);
    }
}
