package com.cg.hospital.service;

import java.util.List;

import com.cg.hospital.exception.PatientDetailsNotFoundException;
import com.cg.hospital.pojos.Doctor;
import com.cg.hospital.pojos.Patient;

public interface PatientService {

	public Patient acceptPatientDetails(Patient patient);
	public List<Patient> getAllPatientDetails();
	public Patient getPatientDetails(int id)throws PatientDetailsNotFoundException;
	public void acceptBulkPatientDetails(List<Patient> patient);
	public boolean removePatientDetails(int id);
	public Patient updatePatientDetails(Patient patient);
}
