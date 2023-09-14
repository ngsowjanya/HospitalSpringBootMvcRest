package com.cg.hospital.service;

import java.util.List;

import com.cg.hospital.exception.DoctorDetailsNotFoundException;
import com.cg.hospital.exception.PatientDetailsNotFoundException;
import com.cg.hospital.pojos.Doctor;
import com.cg.hospital.pojos.Patient;

public interface DoctorService {

	public Doctor acceptDoctorDetails(Doctor doctor);
	public List<Doctor> getAllPatientDetails();
	public Doctor getDoctorDetails(int id)throws DoctorDetailsNotFoundException;
	public void acceptBulkDoctorDetails(List<Doctor> doctor);
	public boolean removeDoctorDetails(int id);
	public Doctor updateDoctorDetails(Doctor doctor);
}
