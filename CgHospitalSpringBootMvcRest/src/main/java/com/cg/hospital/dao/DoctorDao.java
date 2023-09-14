package com.cg.hospital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hospital.pojos.Doctor;

public interface DoctorDao extends JpaRepository<Doctor, Integer>{

}
