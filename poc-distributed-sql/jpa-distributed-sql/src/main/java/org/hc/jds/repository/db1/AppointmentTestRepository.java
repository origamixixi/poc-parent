package org.hc.jds.repository.db1;

import org.hc.jds.entity.db1.AppointmentTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("db1AppointmentTestRepository")
public interface AppointmentTestRepository extends JpaRepository<AppointmentTest, Integer> {

}
