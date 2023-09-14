package com.cg.hospital.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hospital.pojos.Patient;

public interface PatientDao extends JpaRepository<Patient, Integer>{

	
 
}
