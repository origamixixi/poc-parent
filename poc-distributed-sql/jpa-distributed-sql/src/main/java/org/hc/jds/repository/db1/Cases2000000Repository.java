package org.hc.jds.repository.db1;

import org.hc.jds.entity.db1.Cases2000000;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("db1Cases2000000Repository")
public interface Cases2000000Repository extends JpaRepository<Cases2000000, String> {

    @Query("SELECT a FROM Cases2000000 a WHERE a.patientNo IN :patientKeys")
    List<Cases2000000> findByPatientNoIn(@Param("patientKeys") List<Integer> patientKeys);

}
