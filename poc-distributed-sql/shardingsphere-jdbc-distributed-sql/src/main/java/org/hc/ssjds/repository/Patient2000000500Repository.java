package org.hc.ssjds.repository;

import org.hc.ssjds.entity.Patient2000000500;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Patient2000000500Repository extends JpaRepository<Patient2000000500, String> {

    @Query("SELECT p FROM Patient2000000500 p where p.patientKey LIKE :hkidPrefix order by p.patientKey")
    List<Patient2000000500> queryLikeHKIDPrefix(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);
}
