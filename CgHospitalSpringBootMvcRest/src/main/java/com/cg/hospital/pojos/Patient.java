package com.cg.hospital.pojos;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String pName;
	private int pAge;
	private String pGender;
	private String pAddress;
	@ManyToOne
	@JoinColumn(name = "dId")
	private Doctor doctor;
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(int id, String pName, int pAge, String pGender, String pAddress, Doctor doctor) {
		super();
		this.id = id;
		this.pName = pName;
		this.pAge = pAge;
		this.pGender = pGender;
		this.pAddress = pAddress;
		this.doctor = doctor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpAge() {
		return pAge;
	}

	public void setpAge(int pAge) {
		this.pAge = pAge;
	}

	public String getpGender() {
		return pGender;
	}

	public void setpGender(String pGender) {
		this.pGender = pGender;
	}

	public String getpAddress() {
		return pAddress;
	}

	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(doctor, id, pAddress, pAge, pGender, pName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(doctor, other.doctor) && id == other.id && Objects.equals(pAddress, other.pAddress)
				&& pAge == other.pAge && Objects.equals(pGender, other.pGender) && Objects.equals(pName, other.pName);
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", pName=" + pName + ", pAge=" + pAge + ", pGender=" + pGender + ", pAddress="
				+ pAddress + ", doctor=" + doctor + "]";
	}
	
}