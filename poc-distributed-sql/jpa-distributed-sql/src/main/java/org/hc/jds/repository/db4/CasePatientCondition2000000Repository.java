package org.hc.jds.repository.db4;

import org.hc.jds.entity.db4.CasePatientCondition2000000;
import org.hc.jds.entity.CasePatientConditionId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CasePatientCondition2000000Repository extends JpaRepository<CasePatientCondition2000000, CasePatientConditionId> {

    @Query("SELECT a FROM CasePatientCondition2000000 a where CAST(a.patientNo AS string) LIKE :hkidPrefix order by a.patientNo")
    List<CasePatientCondition2000000> queryLikeHKIDPrefix(@Param("hkidPrefix") String hkidPrefix, Pageable pageable);
}
