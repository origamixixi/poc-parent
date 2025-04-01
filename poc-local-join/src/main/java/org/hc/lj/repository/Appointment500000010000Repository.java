package org.hc.lj.repository;

import org.hc.lj.entity.Appointment500000010000;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Appointment500000010000Repository extends JpaRepository<Appointment500000010000, Integer> {

    @Query("SELECT a FROM Appointment500000010000 a JOIN Patient200000010000 p on CAST(a.patientNo AS string) = p.patientKey WHERE p.hkid LIKE :hkidPrefix")
    List<Appointment500000010000> aggregatedDataQuery(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);
}
