package com.vijay.comp.patient.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.vijay.comp.patient.entity.Patient;
import com.vijay.comp.patient.exception.ResourceNotFoundException;
import com.vijay.comp.patient.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	public Patient createPatient(Patient patient) {
		return patientRepository.save(patient);
	}
	
	public ResponseEntity<Patient> getPatientById(Long patientId) {
		Patient patient=patientRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not exists with id :"+patientId));
		return ResponseEntity.ok(patient);

	}

	public ResponseEntity<Patient> updatePatient(Long patientId, Patient patientDetails) {
		Patient patient=patientRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not exists with id :"+patientId));
		patient.setPatientName(patientDetails.getPatientName());
		patient.setPatientVisitedDoctor(patientDetails.getPatientVisitedDoctor());
		patient.setPatientDateOfVisit(patientDetails.getPatientDateOfVisit());
		patient.setDoctorPrescription(patientDetails.getDoctorPrescription());

		Patient updatedPatient=patientRepository.save(patient);
		return ResponseEntity.ok(updatedPatient);
	}

	public ResponseEntity<Map<String, Boolean>> deletePatient(Long patientId) {
		Patient patient=patientRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not exists with id :"+patientId));
		patientRepository.delete(patient);
		Map<String, Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	


}
