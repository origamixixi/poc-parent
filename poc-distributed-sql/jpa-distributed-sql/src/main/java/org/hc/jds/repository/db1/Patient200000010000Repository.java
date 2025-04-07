package org.hc.jds.repository.db1;

import org.hc.jds.entity.db1.Patient200000010000;
import org.hc.jds.entity.db1.Patient2000000500;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Patient200000010000Repository extends JpaRepository<Patient200000010000, String> {

    @Query("SELECT p FROM Patient200000010000 p where p.patientKey LIKE :hkidPrefix order by p.patientKey")
    List<Patient200000010000> queryLikeHKIDPrefix(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);
}
