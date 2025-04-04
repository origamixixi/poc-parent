package org.hc.jds.repository.db1;

import org.hc.jds.entity.db1.Appointment50000000;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("db1Appointment50000000Repository")
public interface Appointment50000000Repository extends JpaRepository<Appointment50000000, Integer> {

    @Query("SELECT a FROM Appointment50000000 a WHERE a.patientNo IN :patientKeys")
    List<Appointment50000000> findByPatientNoIn(@Param("patientKeys") List<Integer> patientKeys);

}
