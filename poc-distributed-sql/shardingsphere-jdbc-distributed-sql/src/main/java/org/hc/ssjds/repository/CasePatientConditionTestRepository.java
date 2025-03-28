package org.hc.ssjds.repository;

import org.hc.ssjds.entity.CasePatientConditionId;
import org.hc.ssjds.entity.CasePatientConditionTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasePatientConditionTestRepository extends JpaRepository<CasePatientConditionTest, CasePatientConditionId> {

}
