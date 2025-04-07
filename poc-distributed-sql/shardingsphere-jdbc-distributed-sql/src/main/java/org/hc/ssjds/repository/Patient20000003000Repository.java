package org.hc.ssjds.repository;

import org.hc.ssjds.entity.Patient20000003000;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Patient20000003000Repository extends JpaRepository<Patient20000003000, String> {

    @Query("SELECT p FROM Patient20000003000 p where p.patientKey LIKE :hkidPrefix order by p.patientKey")
    List<Patient20000003000> queryLikeHKIDPrefix(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);
}
