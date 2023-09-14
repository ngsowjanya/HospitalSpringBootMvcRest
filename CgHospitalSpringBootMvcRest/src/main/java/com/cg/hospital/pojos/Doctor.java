package com.cg.hospital.pojos;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dId;
	private String dName;
	private String specalization;
	@OneToMany(mappedBy="doctor")
	private List<Patient> patients;

	public Doctor() {
		super();	
		// TODO Auto-generated constructor stub
	}

	public Doctor(int dId, String dName, String specalization, List<Patient> patients) {
		super();
		this.dId = dId;
		this.dName = dName;
		this.specalization = specalization;
		this.patients = patients;
	}

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getSpecalization() {
		return specalization;
	}

	public void setSpecalization(String specalization) {
		this.specalization = specalization;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dId, dName, patients, specalization);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		return dId == other.dId && Objects.equals(dName, other.dName) && Objects.equals(patients, other.patients)
				&& Objects.equals(specalization, other.specalization);
	}

	@Override
	public String toString() {
		return "Doctor [dId=" + dId + ", dName=" + dName + ", specalization=" + specalization + ", patients=" + patients
				+ "]";
	}
	
}