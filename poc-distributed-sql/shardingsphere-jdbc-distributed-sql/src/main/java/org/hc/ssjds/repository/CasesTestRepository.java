package org.hc.ssjds.repository;

import org.hc.ssjds.entity.CasesTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasesTestRepository extends JpaRepository<CasesTest, String> {

}
