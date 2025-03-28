package org.hc.jds.repository.db2;

import org.hc.jds.entity.db2.AppointmentTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentTestRepository extends JpaRepository<AppointmentTest, Integer> {

}
