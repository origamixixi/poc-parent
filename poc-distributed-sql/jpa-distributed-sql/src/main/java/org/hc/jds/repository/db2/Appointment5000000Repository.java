package org.hc.jds.repository.db2;

import org.hc.jds.entity.db2.Appointment5000000;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Appointment5000000Repository extends JpaRepository<Appointment5000000, Integer> {

    @Query("SELECT a FROM Appointment5000000 a WHERE a.patientNo IN :patientKeys")
    List<Appointment5000000> findByPatientNoIn(@Param("patientKeys") List<Integer> patientKeys);

}
