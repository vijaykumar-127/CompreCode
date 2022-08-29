package com.vijay.comp.patient.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long patientId;
	private String patientName;
	private String patientVisitedDoctor;
	private String doctorPrescription;
	private LocalDate patientDateOfVisit;
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientVisitedDoctor() {
		return patientVisitedDoctor;
	}
	public void setPatientVisitedDoctor(String patientVisitedDoctor) {
		this.patientVisitedDoctor = patientVisitedDoctor;
	}
	public String getDoctorPrescription() {
		return doctorPrescription;
	}
	public void setDoctorPrescription(String doctorPrescription) {
		this.doctorPrescription = doctorPrescription;
	}
	public LocalDate getPatientDateOfVisit() {
		return patientDateOfVisit;
	}
	public void setPatientDateOfVisit(LocalDate patientDateOfVisit) {
		this.patientDateOfVisit = patientDateOfVisit;
	}
	public Patient(String patientName, String patientVisitedDoctor, String doctorPrescription,
			LocalDate patientDateOfVisit) {
		this.patientName = patientName;
		this.patientVisitedDoctor = patientVisitedDoctor;
		this.doctorPrescription = doctorPrescription;
		this.patientDateOfVisit = patientDateOfVisit;
	}
	public Patient() {
	}
	
}
