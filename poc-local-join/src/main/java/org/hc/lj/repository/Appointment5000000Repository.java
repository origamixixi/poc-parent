package org.hc.lj.repository;

import org.hc.lj.entity.Appointment100000;
import org.hc.lj.entity.Appointment5000000;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Appointment5000000Repository extends JpaRepository<Appointment5000000, Integer> {

    @Query("SELECT a FROM Appointment5000000 a JOIN Patient2000000 p on CAST(a.patientNo AS string) = p.patientKey WHERE p.hkid LIKE :hkidPrefix")
    List<Appointment5000000> dataVolumeQuery(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);

    @Query("SELECT a FROM Appointment5000000 a JOIN Patient2000000 p on CAST(a.patientNo AS string) = p.patientKey WHERE p.hkid LIKE :hkidPrefix")
    List<Appointment5000000> resultSetSizeQuery(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);

    @Query("SELECT a FROM Appointment5000000 a JOIN Patient2000000 p on CAST(a.patientNo AS string) = p.patientKey WHERE p.hkid LIKE :hkidPrefix")
    List<Appointment5000000> typeOfJoinQuery(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);

    @Query("SELECT a FROM Appointment5000000 a LEFT JOIN Patient2000000 p on CAST(a.patientNo AS string) = p.patientKey WHERE p.hkid LIKE :hkidPrefix")
    List<Appointment5000000> typeOfLeftJoinQuery(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);

    @Query("SELECT a FROM Appointment5000000 a where CAST(a.patientNo AS string) in (select patientKey from Patient2000000 where hkid LIKE :hkidPrefix)")
    List<Appointment5000000> typeOfSubQuery(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);

    @Query("""
            select a from Appointment5000000 a
            join Patient2000000 p on CAST(a.patientNo AS string) = p.patientKey
            WHERE p.hkid LIKE :hkidPrefix
            """)
    List<Appointment5000000> twoDatabaseInstanceInvolvedQuery(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);

    @Query("""
            select a from Appointment5000000 a
            join Patient2000000 p on CAST(a.patientNo AS string) = p.patientKey
            join Cases2000000 c on a.patientNo = c.patientNo
            WHERE p.hkid LIKE :hkidPrefix
            """)
    List<Appointment5000000> threeDatabaseInstanceInvolvedQuery(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);

    @Query("""
            select a from Appointment5000000 a
            join Patient2000000 p on CAST(a.patientNo AS string) = p.patientKey
            join Cases200000 c on a.patientNo = c.patientNo
            join CasePatientCondition2000000 cpc on a.patientNo = cpc.patientNo
            WHERE p.hkid LIKE :hkidPrefix
            """)
    List<Appointment5000000> fourDatabaseInstanceInvolvedQuery(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);
}
