package org.hc.ssjds.repository;

import org.hc.ssjds.entity.AppointmentTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentTestRepository extends JpaRepository<AppointmentTest, Integer> {

}
