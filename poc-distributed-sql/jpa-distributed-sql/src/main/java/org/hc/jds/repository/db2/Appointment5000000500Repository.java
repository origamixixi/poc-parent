package org.hc.jds.repository.db2;

import org.hc.jds.entity.db2.Appointment50000003000;
import org.hc.jds.entity.db2.Appointment5000000500;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Appointment5000000500Repository extends JpaRepository<Appointment5000000500, Integer> {

    @Query("SELECT a FROM Appointment5000000500 a where CAST(a.patientNo AS string) LIKE :hkidPrefix order by a.patientNo")
    List<Appointment5000000500> queryLikeHKIDPrefix(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);

}
