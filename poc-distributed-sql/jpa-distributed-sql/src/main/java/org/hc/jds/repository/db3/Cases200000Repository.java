package org.hc.jds.repository.db3;

import org.hc.jds.entity.db3.Cases200000;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Cases200000Repository extends JpaRepository<Cases200000, String> {

    @Query("SELECT a FROM Cases200000 a WHERE a.patientNo IN :patientKeys")
    List<Cases200000> findByPatientNoIn(@Param("patientKeys") List<Integer> patientKeys);

}
