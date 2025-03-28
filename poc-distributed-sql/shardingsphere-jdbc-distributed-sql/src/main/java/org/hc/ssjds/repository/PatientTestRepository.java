package org.hc.ssjds.repository;

import org.hc.ssjds.entity.PatientTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientTestRepository extends JpaRepository<PatientTest, String> {

}
