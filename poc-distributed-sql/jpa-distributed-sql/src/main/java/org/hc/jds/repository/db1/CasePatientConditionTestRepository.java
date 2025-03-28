package org.hc.jds.repository.db1;

import org.hc.jds.entity.db1.CasePatientConditionId;
import org.hc.jds.entity.db1.CasePatientConditionTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("db1CasePatientConditionTestRepository")
public interface CasePatientConditionTestRepository extends JpaRepository<CasePatientConditionTest, CasePatientConditionId> {

}
