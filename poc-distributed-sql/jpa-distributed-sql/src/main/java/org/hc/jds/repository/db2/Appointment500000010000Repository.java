package org.hc.jds.repository.db2;

import org.hc.jds.entity.db2.Appointment500000010000;
import org.hc.jds.entity.db2.Appointment5000000500;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Appointment500000010000Repository extends JpaRepository<Appointment500000010000, Integer> {

    @Query("SELECT a FROM Appointment500000010000 a where CAST(a.patientNo AS string) LIKE :hkidPrefix order by a.patientNo")
    List<Appointment500000010000> queryLikeHKIDPrefix(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);


}
