package org.hc.ssjds.repository;

import org.hc.ssjds.entity.Appointment100000;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Appointment100000Repository extends JpaRepository<Appointment100000, Integer> {

    @Query("SELECT a FROM Appointment100000 a where CAST(a.patientNo AS string) LIKE :hkidPrefix order by a.patientNo")
    List<Appointment100000> queryLikeHKIDPrefix(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);

}
