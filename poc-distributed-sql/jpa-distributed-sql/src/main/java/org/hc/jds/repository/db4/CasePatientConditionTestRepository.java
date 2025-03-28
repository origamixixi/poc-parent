package org.hc.jds.repository.db4;

import org.hc.jds.entity.db4.CasePatientConditionId;
import org.hc.jds.entity.db4.CasePatientConditionTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasePatientConditionTestRepository extends JpaRepository<CasePatientConditionTest, CasePatientConditionId> {

}
