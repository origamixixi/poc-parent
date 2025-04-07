package org.hc.ssjds.controller;

import lombok.RequiredArgsConstructor;
import org.hc.ssjds.entity.*;
import org.hc.ssjds.service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CompositeController {

    private final ImpactOfMultiDbInstancesService multiDbInstancesService;
    private final ImpactOfDifferentDataSizeService differentDataSizeService;
    private final ImpactOfDifferentPaginationService differentPaginationService;
    private final ImpactOfDifferentJoinAndSubqueryService differentJoinAndSubqueryService;
    private final ImpactOfDifferentResultSetService differentResultSetService;


    //---------------------------------------------------------------------
    // ImpactOfDifferentDataSizeService methods
    //---------------------------------------------------------------------
    @GetMapping("/data-size/appointment100000-and-patient10000")
    public List<Appointment100000> getAppointment100000AndPatient10000(@RequestParam String hkidPrefix) {
        return differentDataSizeService.queryAppointment100000AndPatient10000(hkidPrefix);
    }

    @GetMapping("/data-size/appointment5000000-and-patient2000000")
    public List<Appointment5000000500> getAppointment5000000AndPatient2000000(@RequestParam String hkidPrefix) {
        return differentDataSizeService.queryAppointment5000000AndPatientPatient2000000(hkidPrefix);
    }

    @GetMapping("/data-size/appointment50000000-and-patient10000000")
    public List<Appointment50000000> getAppointment50000000AndPatient10000000(@RequestParam String hkidPrefix) {
        return differentDataSizeService.queryAppointment50000000AndPatient10000000(hkidPrefix);
    }

    //---------------------------------------------------------------------
    // ImpactOfDifferentResultSetService methods
    //---------------------------------------------------------------------
    @GetMapping("/result-set/appointment50000000500-and-patient10000000500")
    public List<Appointment5000000500> getResultSetData500And500(@RequestParam String hkidPrefix) {
        return differentResultSetService.queryResultSet500And500(hkidPrefix);
    }

    @GetMapping("/result-set/appointment500000003000-and-patient100000003000")
    public List<Appointment50000003000> getResultSetData3000And3000(@RequestParam String hkidPrefix) {
        return differentResultSetService.queryResultSet3000And3000(hkidPrefix);
    }

    @GetMapping("/result-set/appointment5000000010000-and-patient1000000010000")
    public List<Appointment500000010000> getResultSetData10000And10000(@RequestParam String hkidPrefix) {
        return differentResultSetService.queryResultSet10000And10000(hkidPrefix);
    }

    //---------------------------------------------------------------------
    // ImpactOfDifferentPaginationService methods
    //---------------------------------------------------------------------
    @GetMapping("/pagination/50")
    public List<Appointment50000003000> getPagination50(@RequestParam String hkidPrefix) {
        return differentPaginationService.queryPagination50(hkidPrefix);
    }

    @GetMapping("/pagination/1000")
    public List<Appointment50000003000> getPagination1000(@RequestParam String hkidPrefix) {
        return differentPaginationService.queryPagination1000(hkidPrefix);
    }

    @GetMapping("/pagination/10000")
    public List<Appointment50000003000> getPagination10000(@RequestParam String hkidPrefix) {
        return differentPaginationService.queryPagination10000(hkidPrefix);
    }

    //---------------------------------------------------------------------
    // ImpactOfDifferentJoinAndSubqueryService methods
    //---------------------------------------------------------------------
    @GetMapping("/type-of-join")
    public List<Appointment50000003000> getTypeOfJoin(@RequestParam String hkidPrefix) {
        return differentJoinAndSubqueryService.queryTypeOfJoin(hkidPrefix);
    }

    @GetMapping("/type-of-left-join")
    public List<Appointment50000003000> getTypeOfLeftJoin(@RequestParam String hkidPrefix) {
        return differentJoinAndSubqueryService.queryTypeOfLeftJoin(hkidPrefix);
    }

    @GetMapping("/type-of-subquery")
    public List<Appointment50000003000> getTypeOfSubquery(@RequestParam String hkidPrefix) {
        return differentJoinAndSubqueryService.queryTypeOfSub(hkidPrefix);
    }

    //---------------------------------------------------------------------
    // ImpactOfMultiDbInstancesService methods
    //---------------------------------------------------------------------
    @GetMapping("/database-instance/two")
    public List<Appointment50000003000> getTwoDatabaseInstance(@RequestParam String hkidPrefix) {
        return multiDbInstancesService.queryTwoDatabaseInstance(hkidPrefix);
    }

    @GetMapping("/database-instance/three")
    public List<Appointment50000003000> getThreeDatabaseInstance(@RequestParam String hkidPrefix) {
        return multiDbInstancesService.queryThreeDatabaseInstance(hkidPrefix);
    }

    @GetMapping("/database-instance/four")
    public List<Appointment50000003000> getFourDatabaseInstance(@RequestParam String hkidPrefix) {
        return multiDbInstancesService.queryFourDatabaseInstance(hkidPrefix);
    }

}
