package org.hc.ssjds.repository;

import org.hc.ssjds.entity.Appointment50000000;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Appointment50000000Repository extends JpaRepository<Appointment50000000, Integer> {

    @Query("SELECT a FROM Appointment50000000 a WHERE a.patientNo IN :patientKeys")
    List<Appointment50000000> findByPatientNoIn(@Param("patientKeys") List<Integer> patientKeys);

}
