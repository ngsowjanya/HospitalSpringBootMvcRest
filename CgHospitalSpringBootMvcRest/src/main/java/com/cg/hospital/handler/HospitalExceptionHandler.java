package com.cg.hospital.handler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.hospital.exception.DoctorDetailsNotFoundException;
import com.cg.hospital.exception.PatientDetailsNotFoundException;

@ControllerAdvice	
public class HospitalExceptionHandler {

	@ExceptionHandler(PatientDetailsNotFoundException.class)
	public ResponseEntity<String> handelProductDetailsNotFoundException(PatientDetailsNotFoundException e){
		 return new ResponseEntity<String>(e.getMessage() ,HttpStatus.NOT_FOUND);
		 
	}
	
	@ExceptionHandler(DoctorDetailsNotFoundException.class)
	public ResponseEntity<String> handelDoctorDetailsNotFoundException(DoctorDetailsNotFoundException e){
		 return new ResponseEntity<String>(e.getMessage() ,HttpStatus.NOT_FOUND);
		 
	}
	
}
