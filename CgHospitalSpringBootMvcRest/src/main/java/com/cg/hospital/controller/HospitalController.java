package com.cg.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hospital.exception.DoctorDetailsNotFoundException;
import com.cg.hospital.exception.PatientDetailsNotFoundException;
import com.cg.hospital.pojos.Doctor;
import com.cg.hospital.pojos.Patient;
import com.cg.hospital.service.DoctorService;
import com.cg.hospital.service.PatientService;

@RestController
public class HospitalController {

	@Autowired
	private PatientService patientservice;
	@Autowired
	private DoctorService doctorservice;

	@GetMapping("/hello")
	public ResponseEntity<String> sayHello() {
		return new ResponseEntity<>("Hello To All Welcome to RESTFul WebService", HttpStatus.OK);
	}

	@PostMapping(value = "/addPatient", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addPatient(@RequestBody Patient patient) {
		patient = patientservice.acceptPatientDetails(patient);
		return new ResponseEntity<>("Patient Details successfully Added Id " + patient.getId(), HttpStatus.CREATED);
	}
	

	@GetMapping("/patientDetailsQueryParam")
	public ResponseEntity<Patient> getPatientDetailsQueryParam(int id) throws PatientDetailsNotFoundException {
		Patient patient = patientservice.getPatientDetails(id);
		return new ResponseEntity<Patient>(patient, HttpStatus.FOUND);
	}
	@PutMapping(value= "/updatePatient")
	public ResponseEntity<String> updatePatient(@ModelAttribute Patient patient){
		patient = patientservice.updatePatientDetails(patient);
		return new ResponseEntity<>("Patient Details updated successfully by Id " + patient.getId(), HttpStatus.CREATED);

	}
	@DeleteMapping("/deletePatient")
	public ResponseEntity<Patient> deletePatient(@ModelAttribute int id){		boolean patient = patientservice.removePatientDetails(id);
		return new ResponseEntity<Patient>(HttpStatus.FOUND);
	}
	@GetMapping(value = "/doctorDetails")
	public ResponseEntity<Doctor> getDoctorDetails(int id) throws DoctorDetailsNotFoundException {
	Doctor doctor = doctorservice.getDoctorDetails(id);
	return new ResponseEntity<Doctor>(doctor, HttpStatus.FOUND);
	}
	@DeleteMapping(value = "/removeDoctorDetails")
	public ResponseEntity<Doctor> removeDoctorDetails(int id) throws DoctorDetailsNotFoundException {
	boolean doctor = doctorservice.removeDoctorDetails(id);
	return new ResponseEntity<Doctor>(HttpStatus.OK);
	}
	@PutMapping(value = "/updateDoctorDetails")
	public ResponseEntity<Doctor> updateDoctorDetails(@ModelAttribute Doctor doctor) {
	doctor = doctorservice.updateDoctorDetails(doctor);
	return new ResponseEntity<Doctor>(HttpStatus.OK);
	}
	@PostMapping(value = "/addDoctor",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor){
	doctor = doctorservice.acceptDoctorDetails(doctor);
	return new ResponseEntity<>("Doctor Details successfully Added Id "+ doctor.getdId(), HttpStatus.CREATED);
	}
	@GetMapping("/doctorDetailsQueryParam")
	public ResponseEntity<Doctor> getDoctorDetailsQueryParam(int id) throws DoctorDetailsNotFoundException {
		Doctor doctor = doctorservice.getDoctorDetails(id);
		return new ResponseEntity<Doctor>(doctor, HttpStatus.FOUND);
	}
}
