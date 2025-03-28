package org.hc.jds.repository.db1;

import org.hc.jds.entity.db1.Appointment100000;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("db1Appointment100000Repository")
public interface Appointment100000Repository extends JpaRepository<Appointment100000, Integer> {

    @Query("SELECT a FROM Appointment100000 a WHERE a.patientNo IN :patientKeys")
    List<Appointment100000> findByPatientNoIn(@Param("patientKeys") List<Integer> patientKeys);

}
