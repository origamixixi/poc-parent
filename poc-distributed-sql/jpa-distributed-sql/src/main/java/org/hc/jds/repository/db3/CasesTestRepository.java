package org.hc.jds.repository.db3;

import org.hc.jds.entity.db3.CasesTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasesTestRepository extends JpaRepository<CasesTest, String> {

}
