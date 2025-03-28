package org.hc.lj.repository;

import org.hc.lj.entity.CasesTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasesTestRepository extends JpaRepository<CasesTest, String> {

}
