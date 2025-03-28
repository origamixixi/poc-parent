package org.hc.ssjds.service;

import org.hc.ssjds.entity.Appointment5000000;
import org.hc.ssjds.entity.Patient2000000;
import org.hc.ssjds.repository.Appointment5000000Repository;
import org.hc.ssjds.repository.Patient2000000Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImpactOfTypeOfJoinAndSubqueryService {

    @Autowired
    private Patient2000000Repository patient2000000Repository;

    @Autowired
    private Appointment5000000Repository appointment5000000Repository;

    public List<Appointment5000000> queryTypeOfJoin(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        List<Patient2000000> patients = patient2000000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        List<Integer> patientKeys = patients.stream()
                .map(Patient2000000::getPatientKey)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return appointment5000000Repository.findByPatientNoIn(patientKeys);
    }

    public List<Appointment5000000> queryTypeOfLeftJoin(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        List<Patient2000000> patients = patient2000000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        List<Integer> patientKeys = patients.stream()
                .map(Patient2000000::getPatientKey)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return appointment5000000Repository.findByPatientNoIn(patientKeys);
    }

    public List<Appointment5000000> queryTypeOfSub(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        List<Patient2000000> patients = patient2000000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        List<Integer> patientKeys = patients.stream()
                .map(Patient2000000::getPatientKey)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return appointment5000000Repository.findByPatientNoIn(patientKeys);
    }
}
