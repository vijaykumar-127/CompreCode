package com.vijay.comp.doctor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long doctorId;
	private String doctorName;
	private int doctorAge;
	private String doctorGender;
	private String doctorSpecialization;
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public int getDoctorAge() {
		return doctorAge;
	}
	public void setDoctorAge(int doctorAge) {
		this.doctorAge = doctorAge;
	}
	public String getDoctorGender() {
		return doctorGender;
	}
	public void setDoctorGender(String doctorGender) {
		this.doctorGender = doctorGender;
	}
	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}
	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}
	public Doctor(String doctorName, int doctorAge, String doctorGender, String doctorSpecialization) {
		this.doctorName = doctorName;
		this.doctorAge = doctorAge;
		this.doctorGender = doctorGender;
		this.doctorSpecialization = doctorSpecialization;
	}
	public Doctor() {
	}
	
}
