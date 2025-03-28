package org.hc.lj.repository;

import org.hc.lj.entity.Patient10000;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Patient10000Repository extends JpaRepository<Patient10000, String> {

}
