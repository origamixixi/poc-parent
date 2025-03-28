package org.hc.jds.repository.db1;

import org.hc.jds.entity.db1.Cases200000;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("db1Cases200000Repository")
public interface Cases200000Repository extends JpaRepository<Cases200000, String> {

    @Query("SELECT a FROM Cases200000 a WHERE a.patientNo IN :patientKeys")
    List<Cases200000> findByPatientNoIn(@Param("patientKeys") List<Integer> patientKeys);

}
