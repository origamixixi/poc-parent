package org.hc.jds.service;

import org.hc.jds.entity.db1.Patient2000000;
import org.hc.jds.entity.db2.Appointment5000000;
import org.hc.jds.entity.db3.Cases200000;
import org.hc.jds.entity.db3.Cases2000000;
import org.hc.jds.entity.db4.CasePatientCondition2000000;
import org.hc.jds.repository.db1.Patient2000000Repository;
import org.hc.jds.repository.db2.Appointment5000000Repository;
import org.hc.jds.repository.db3.Cases2000000Repository;
import org.hc.jds.repository.db3.Cases200000Repository;
import org.hc.jds.repository.db4.CasePatientCondition2000000Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImpactOfDatabaseInstanceInvolvedService {

    @Autowired
    private Patient2000000Repository patient2000000Repository;

    @Autowired
    private Appointment5000000Repository appointment5000000Repository;

    @Autowired
    private Cases200000Repository cases200000Repository;

    @Autowired
    private Cases2000000Repository cases2000000Repository;

    @Autowired
    private CasePatientCondition2000000Repository casePatientCondition2000000Repository;

    public List<Appointment5000000> queryTwoDatabaseInstanceInvolved(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        List<Patient2000000> patients = patient2000000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        List<Integer> patientKeys = patients.stream()
                .map(Patient2000000::getPatientKey)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return appointment5000000Repository.findByPatientNoIn(patientKeys);
    }

    public List<Appointment5000000> queryThreeDatabaseInstanceInvolved(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        List<Patient2000000> patients = patient2000000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        List<Integer> patientKeys = patients.stream()
                .map(Patient2000000::getPatientKey)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Cases2000000> cases2000000s = cases2000000Repository.findByPatientNoIn(patientKeys);
        return appointment5000000Repository.findByPatientNoIn(patientKeys);
    }

    public List<Appointment5000000> queryFourDatabaseInstanceInvolved(String hkidPrefix) {
        Pageable pageable = PageRequest.of(0, 1000);
        List<Patient2000000> patients = patient2000000Repository.queryLikeHKIDPrefix(hkidPrefix, pageable);
        List<Integer> patientKeys = patients.stream()
                .map(Patient2000000::getPatientKey)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Cases200000> cases200000s = cases200000Repository.findByPatientNoIn(patientKeys);
        List<CasePatientCondition2000000> casePatientCondition2000000s = casePatientCondition2000000Repository.findByPatientNoIn(patientKeys);
        return appointment5000000Repository.findByPatientNoIn(patientKeys);
    }

}
