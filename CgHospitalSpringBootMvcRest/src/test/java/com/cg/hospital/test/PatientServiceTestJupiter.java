package com.cg.hospital.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.cg.hospital.dao.PatientDao;
import com.cg.hospital.exception.PatientDetailsNotFoundException;
import com.cg.hospital.pojos.Patient;
import com.cg.hospital.service.PatientService;

//For Rest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PatientServiceTestJupiter {
	@Autowired
	private PatientService patientService;
	@MockBean
	PatientDao patientDao;
	@Test
	void testaddPatient() {
		Patient patient = new Patient();
		patient.setId(1);
		patient.setpName("sowjanya");
		patient.setpGender("female");
		patient.setpAge(22);
		patient.setpAddress("hyderabad");
		patient.setDoctor(null);
		
		Mockito.when(patientDao.save(patient)).thenReturn(patient);	
		Patient response=patientService.acceptPatientDetails(patient);
		assertThat(response.getId()).isEqualTo(1);
		assertThat(response.getpName()).isEqualTo("sowjanya");
		assertThat(response.getpGender()).isEqualTo("female");
		assertThat(response.getpAge()).isEqualTo(22);
		assertThat(response.getpAddress()).isEqualTo("hyderabad");
		assertThat(response.getDoctor()).isEqualTo(null);
	}
	@Test
	void TestDeletePatient(){
		Patient patient = new Patient();
		patient.setId(1);
		Optional<Patient> a1=Optional.of(patient);
		Mockito.when(patientDao.getById(1)).thenReturn(patient);
		Mockito.when(patientDao.existsById(patient.getId())).thenReturn(false);
		assertThat(patientDao.existsById(patient.getId()));
		}
	
	@Test
	void testUpdatePatient() throws PatientDetailsNotFoundException{
		Patient patient = new Patient();
		patient.setId(1);
		patient.setpName("sowjanya");
		patient.setpGender("female");
		patient.setpAge(22);
		patient.setpAddress("hyderabad");
		patient.setDoctor(null);
		Optional<Patient> a1=Optional.of(patient);
		Mockito.when(patientDao.findById(1)).thenReturn(a1);
		patient.setpName("ramya");
		Mockito.when(patientDao.saveAndFlush(patient)).thenReturn(patient);	
		assertThat(patientService.updatePatientDetails(patient)).isEqualTo(patient);	
	}
	
}
