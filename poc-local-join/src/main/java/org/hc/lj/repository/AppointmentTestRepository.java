package org.hc.lj.repository;

import org.hc.lj.entity.AppointmentTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentTestRepository extends JpaRepository<AppointmentTest, Integer> {

}
