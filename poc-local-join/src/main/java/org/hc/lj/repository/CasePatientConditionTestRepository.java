package org.hc.lj.repository;

import org.hc.lj.entity.CasePatientConditionId;
import org.hc.lj.entity.CasePatientConditionTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasePatientConditionTestRepository extends JpaRepository<CasePatientConditionTest, CasePatientConditionId> {

}
