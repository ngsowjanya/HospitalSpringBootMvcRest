package com.cg.hospital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.hospital.dao.PatientDao;
import com.cg.hospital.exception.PatientDetailsNotFoundException;
import com.cg.hospital.pojos.Patient;

@Component("patientservice")
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	PatientDao patientDAO;
	
	@Override
	public Patient acceptPatientDetails(Patient patient) {
		// TODO Auto-generated method stub
		patient = patientDAO.save(patient);
		return patient;
	}

	@Override
	public List<Patient> getAllPatientDetails() {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public Patient getPatientDetails(int id) throws PatientDetailsNotFoundException {
		// TODO Auto-generated method stub
		return patientDAO.findById(id).orElseThrow(() -> new PatientDetailsNotFoundException("Patient Details Not Found for Id :- "+id));
	}

	@Override
	public void acceptBulkPatientDetails(List<Patient> patient) {
		// TODO Auto-generated method stub

		patientDAO.saveAllAndFlush(patient);
	}

	@Override
	public boolean removePatientDetails(int id) {
		// TODO Auto-generated method stub
		patientDAO.deleteById(id);
		return true;
	}

	@Override
	public Patient updatePatientDetails(Patient patient) {
		int id = patient.getId();
		Optional<Patient> pat = Optional.of(patientDAO.getById(id));
		Patient patient2 = null;
		try {
			patient2 = pat.orElseThrow(() -> new PatientDetailsNotFoundException("Patient not found"));
		} catch (PatientDetailsNotFoundException e) {
			e.printStackTrace();
		}
		patient2.setId(patient.getId());
		patient2.setpAddress(patient.getpAddress());
		patient2.setpAge(patient.getpAge());
		patient2.setpGender(patient.getpGender());
		patient2.setpName(patient.getpName());
		
		return patientDAO.save(patient2);
	}

	


}
