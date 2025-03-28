package org.hc.lj.repository;

import org.hc.lj.entity.PatientTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientTestRepository extends JpaRepository<PatientTest, String> {

}
