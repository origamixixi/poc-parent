package org.hc.jds.repository.db1;

import org.hc.jds.entity.db1.CasePatientCondition2000000;
import org.hc.jds.entity.db1.CasePatientConditionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("db1CasePatientCondition2000000Repository")
public interface CasePatientCondition2000000Repository extends JpaRepository<CasePatientCondition2000000, CasePatientConditionId> {

    @Query("SELECT a FROM CasePatientCondition2000000 a WHERE a.patientNo IN :patientKeys")
    List<CasePatientCondition2000000> findByPatientNoIn(@Param("patientKeys") List<Integer> patientKeys);
}
