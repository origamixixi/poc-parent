package org.hc.lj.controller;

import lombok.RequiredArgsConstructor;
import org.hc.lj.entity.*;
import org.hc.lj.service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CompositeController {

    private final ImpactOfDatabaseInstanceInvolvedService databaseInstanceInvolvedService;
    private final ImpactOfDataVolumeService dataVolumeService;
    private final ImpactOfResultSetSizeService resultSetSizeService;
    private final ImpactOfTypeOfJoinAndSubqueryService typeOfJoinAndSubqueryService;
    private final ImpactOfAggregatedDataService aggregatedDataService;

    // ImpactOfDatabaseInstanceInvolvedService methods
    @GetMapping("/database-instance-involved/two")
    public List<Appointment50000003000> getTwoDatabaseInstanceInvolved(@RequestParam String hkidPrefix) {
        return databaseInstanceInvolvedService.queryTwoDatabaseInstanceInvolved(hkidPrefix);
    }

    @GetMapping("/database-instance-involved/three")
    public List<Appointment50000003000> getThreeDatabaseInstanceInvolved(@RequestParam String hkidPrefix) {
        return databaseInstanceInvolvedService.queryThreeDatabaseInstanceInvolved(hkidPrefix);
    }

    @GetMapping("/database-instance-involved/four")
    public List<Appointment50000003000> getFourDatabaseInstanceInvolved(@RequestParam String hkidPrefix) {
        return databaseInstanceInvolvedService.queryFourDatabaseInstanceInvolved(hkidPrefix);
    }

    // ImpactOfDataVolumeService methods
    @GetMapping("/data-volume/appointment100000-and-patient10000")
    public List<Appointment100000> getAppointment100000AndPatient10000(@RequestParam String hkidPrefix) {
        return dataVolumeService.queryAppointment100000AndPatient10000(hkidPrefix);
    }

    @GetMapping("/data-volume/appointment5000000-and-patient2000000")
    public List<Appointment50000003000> getAppointment5000000AndPatient2000000(@RequestParam String hkidPrefix) {
        return dataVolumeService.queryAppointment5000000AndPatientPatient2000000(hkidPrefix);
    }

    @GetMapping("/data-volume/appointment50000000-and-patient10000000")
    public List<Appointment50000000> getAppointment50000000AndPatient10000000(@RequestParam String hkidPrefix) {
        return dataVolumeService.queryAppointment50000000AndPatient10000000(hkidPrefix);
    }

    // ImpactOfResultSetSizeService methods
    @GetMapping("/result-set-size/50")
    public List<Appointment50000003000> getResultSetSize50(@RequestParam String hkidPrefix) {
        return resultSetSizeService.query50(hkidPrefix);
    }

    @GetMapping("/result-set-size/1000")
    public List<Appointment50000003000> getResultSetSize1000(@RequestParam String hkidPrefix) {
        return resultSetSizeService.query1000(hkidPrefix);
    }

    @GetMapping("/result-set-size/10000")
    public List<Appointment50000003000> getResultSetSize10000(@RequestParam String hkidPrefix) {
        return resultSetSizeService.query10000(hkidPrefix);
    }

    // ImpactOfTypeOfJoinAndSubqueryService methods
    @GetMapping("/type-of-join")
    public List<Appointment50000003000> getTypeOfJoin(@RequestParam String hkidPrefix) {
        return typeOfJoinAndSubqueryService.queryTypeOfJoin(hkidPrefix);
    }

    @GetMapping("/type-of-left-join")
    public List<Appointment50000003000> getTypeOfLeftJoin(@RequestParam String hkidPrefix) {
        return typeOfJoinAndSubqueryService.queryTypeOfLeftJoin(hkidPrefix);
    }

    @GetMapping("/type-of-subquery")
    public List<Appointment50000003000> getTypeOfSubquery(@RequestParam String hkidPrefix) {
        return typeOfJoinAndSubqueryService.queryTypeOfSub(hkidPrefix);
    }

    // ImpactOfAggregatedDataService methods
    @GetMapping("/aggregated-data/appointment50000000500-and-patient10000000500")
    public List<Appointment5000000500> getAggregatedData1(@RequestParam String hkidPrefix) {
        return aggregatedDataService.queryAppointment5000000500AndPatientPatient2000000500(hkidPrefix);
    }

    @GetMapping("/aggregated-data/appointment500000003000-and-patient100000003000")
    public List<Appointment50000003000> getAggregatedData2(@RequestParam String hkidPrefix) {
        return aggregatedDataService.queryAppointment50000003000AndPatientPatient20000003000(hkidPrefix);
    }

    @GetMapping("/aggregated-data/appointment5000000010000-and-patient1000000010000")
    public List<Appointment500000010000> getAggregatedData3(@RequestParam String hkidPrefix) {
        return aggregatedDataService.queryAppointment500000010000AndPatientPatient200000010000(hkidPrefix);
    }
}
