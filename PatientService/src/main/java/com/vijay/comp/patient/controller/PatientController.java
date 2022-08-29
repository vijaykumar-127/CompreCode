package com.vijay.comp.patient.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vijay.comp.patient.entity.Patient;
import com.vijay.comp.patient.service.PatientService;

@CrossOrigin("*")
@RestController
@RequestMapping("/home")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/patients")
	public List<Patient> getAllPatients(){
		return patientService.getAllPatients();
	}
	
	@PostMapping("/patients")
	public Patient createPatient(@RequestBody Patient patient ) {
		return patientService.createPatient(patient);
	}
	
	@GetMapping("/patients/{patientId}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Long patientId){
		return patientService.getPatientById(patientId);
	}
	
	@PutMapping("/patients/{patientId}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Long patientId, @RequestBody Patient patientDetails){
		return patientService.updatePatient(patientId, patientDetails);
	}
	
	@DeleteMapping("/patients/{patientId}")
	public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable Long patientId){
		return patientService.deletePatient(patientId);
	}
}
