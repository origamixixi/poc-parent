package org.hc.ssjds.repository;

import org.hc.ssjds.entity.Cases2000000;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Cases2000000Repository extends JpaRepository<Cases2000000, String> {

    @Query("SELECT a FROM Cases2000000 a where CAST(a.patientNo AS string) LIKE :hkidPrefix order by a.patientNo")
    List<Cases2000000> queryLikeHKIDPrefix(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);
}
