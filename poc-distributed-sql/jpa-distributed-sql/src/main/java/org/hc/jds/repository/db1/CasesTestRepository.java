package org.hc.jds.repository.db1;

import org.hc.jds.entity.db1.CasesTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("db1CasesTestRepository")
public interface CasesTestRepository extends JpaRepository<CasesTest, String> {

}
