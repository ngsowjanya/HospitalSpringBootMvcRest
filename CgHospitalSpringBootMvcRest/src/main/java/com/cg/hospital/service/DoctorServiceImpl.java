package com.cg.hospital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.hospital.dao.DoctorDao;
import com.cg.hospital.dao.PatientDao;
import com.cg.hospital.exception.DoctorDetailsNotFoundException;
import com.cg.hospital.exception.PatientDetailsNotFoundException;
import com.cg.hospital.pojos.Doctor;
import com.cg.hospital.pojos.Patient;
@Component("doctorservice")
public class DoctorServiceImpl implements DoctorService{
    @Autowired
	DoctorDao doctorDao;
	@Override
	public Doctor acceptDoctorDetails(Doctor doctor) {
		// TODO Auto-generated method stub
		
		return doctorDao.save(doctor);
	}

	@Override
	public List<Doctor> getAllPatientDetails() {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public Doctor getDoctorDetails(int id) throws DoctorDetailsNotFoundException {
		// TODO Auto-generated method stub
		
		//return patientDAO.findById(id).orElseThrow(() -> new PatientDetailsNotFoundException("Patient Details Not Found for Id :- "+id));
		
		return doctorDao.findById(id).orElseThrow(() -> new DoctorDetailsNotFoundException("Doctor Details Not Found for Id :- "+id));
		
	}

	@Override
	public void acceptBulkDoctorDetails(List<Doctor> doctor) {
		// TODO Auto-generated method stub
		doctorDao.saveAllAndFlush(doctor);
	}

	@Override
	public boolean removeDoctorDetails(int id) {
		// TODO Auto-generated method stub
		doctorDao.deleteById(id);
		return true;
		
	}

	@Override
	public Doctor updateDoctorDetails(Doctor doctor) {
		// TODO Auto-generated method stub
		int id = doctor.getdId();
		Optional<Doctor> pat = Optional.of(doctorDao.getById(id));

		Doctor doctor2 = null;

		try {
		doctor2 = pat.orElseThrow(() -> new DoctorDetailsNotFoundException("Doctor not found"));
		} catch (DoctorDetailsNotFoundException e) {
		e.printStackTrace();
		}
		doctor2.setdId(doctor.getdId());
		doctor2.setdName(doctor.getdName());
		doctor2.setSpecalization(doctor.getSpecalization());
		return doctorDao.save(doctor2);
	}

}
