package org.hc.lj.repository;

import org.hc.lj.entity.Appointment50000003000;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Appointment50000003000Repository extends JpaRepository<Appointment50000003000, Integer> {

    @Query("SELECT a FROM Appointment50000003000 a JOIN Patient20000003000 p on CAST(a.patientNo AS string) = p.patientKey WHERE p.hkid LIKE :hkidPrefix")
    List<Appointment50000003000> dataSizeQuery(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);

    @Query("SELECT a FROM Appointment50000003000 a JOIN Patient20000003000 p on CAST(a.patientNo AS string) = p.patientKey WHERE p.hkid LIKE :hkidPrefix")
    List<Appointment50000003000> paginationQuery(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);

    @Query("SELECT a FROM Appointment50000003000 a JOIN Patient20000003000 p on CAST(a.patientNo AS string) = p.patientKey WHERE p.hkid LIKE :hkidPrefix")
    List<Appointment50000003000> typeOfJoinQuery(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);

    @Query("SELECT a FROM Appointment50000003000 a LEFT JOIN Patient20000003000 p on CAST(a.patientNo AS string) = p.patientKey WHERE p.hkid LIKE :hkidPrefix")
    List<Appointment50000003000> typeOfLeftJoinQuery(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);

    @Query("SELECT a FROM Appointment50000003000 a where CAST(a.patientNo AS string) in (select patientKey from Patient20000003000 where hkid LIKE :hkidPrefix)")
    List<Appointment50000003000> typeOfSubQuery(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);

    @Query("""
            select a from Appointment50000003000 a
            join Patient20000003000 p on CAST(a.patientNo AS string) = p.patientKey
            WHERE p.hkid LIKE :hkidPrefix
            """)
    List<Appointment50000003000> twoDatabaseInstanceQuery(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);

    @Query("""
            select a from Appointment50000003000 a
            join Patient20000003000 p on CAST(a.patientNo AS string) = p.patientKey
            join Cases2000000 c on a.patientNo = c.patientNo
            WHERE p.hkid LIKE :hkidPrefix
            """)
    List<Appointment50000003000> threeDatabaseInstanceQuery(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);

    @Query("""
            select a from Appointment50000003000 a
            join Patient20000003000 p on CAST(a.patientNo AS string) = p.patientKey
            join Cases200000 c on a.patientNo = c.patientNo
            join CasePatientCondition2000000 cpc on a.patientNo = cpc.patientNo
            WHERE p.hkid LIKE :hkidPrefix
            """)
    List<Appointment50000003000> fourDatabaseInstanceQuery(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);

    @Query("SELECT a FROM Appointment50000003000 a JOIN Patient20000003000 p on CAST(a.patientNo AS string) = p.patientKey WHERE p.hkid LIKE :hkidPrefix")
    List<Appointment50000003000> resultSetQuery(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);
}
