package org.hc.ssjds.repository;

import org.hc.ssjds.entity.Appointment50000003000;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Appointment50000003000Repository extends JpaRepository<Appointment50000003000, Integer> {

    @Query("SELECT a FROM Appointment50000003000 a where CAST(a.patientNo AS string) LIKE :hkidPrefix order by a.patientNo")
    List<Appointment50000003000> queryLikeHKIDPrefix(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);
}
