package org.hc.jds.repository.db1;

import org.hc.jds.entity.db1.Patient2000000;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Patient2000000Repository extends JpaRepository<Patient2000000, String> {

    @Query("SELECT p FROM Patient2000000 p where p.hkid LIKE :hkidPrefix")
    List<Patient2000000> queryLikeHKIDPrefix(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);

}
