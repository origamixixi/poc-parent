package org.hc.lj.repository;

import org.hc.lj.entity.Appointment50000003000;
import org.hc.lj.entity.Appointment5000000500;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Appointment5000000500Repository extends JpaRepository<Appointment5000000500, Integer> {

    @Query("SELECT a FROM Appointment5000000500 a JOIN Patient2000000500 p on CAST(a.patientNo AS string) = p.patientKey WHERE CAST(a.patientNo AS string) LIKE :hkidPrefix order by a.patientNo")
    List<Appointment5000000500> dataSizeQuery(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);

    @Query("SELECT a FROM Appointment5000000500 a JOIN Patient2000000500 p on CAST(a.patientNo AS string) = p.patientKey WHERE CAST(a.patientNo AS string) LIKE :hkidPrefix order by a.patientNo")
    List<Appointment5000000500> resultSetQuery(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);
}
