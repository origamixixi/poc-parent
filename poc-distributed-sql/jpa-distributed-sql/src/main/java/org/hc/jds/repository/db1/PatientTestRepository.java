package org.hc.jds.repository.db1;

import org.hc.jds.entity.db1.PatientTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientTestRepository extends JpaRepository<PatientTest, String> {

}
