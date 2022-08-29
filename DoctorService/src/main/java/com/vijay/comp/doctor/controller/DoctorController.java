package com.vijay.comp.doctor.controller;

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

import com.vijay.comp.doctor.entity.Doctor;
import com.vijay.comp.doctor.service.DoctorService;

@CrossOrigin("*")
@RestController
@RequestMapping("/home")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("/doctors")
	public List<Doctor> getAllDoctors(){
		return doctorService.getAllDoctors();
	}
	
	@PostMapping("/doctors")
	public Doctor createDoctor(@RequestBody Doctor doctor) {
		return doctorService.createDoctor(doctor);
	}
	
	@GetMapping("/doctors/{doctorId}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable Long doctorId){
		return doctorService.getDoctorById(doctorId);
	}
	
	@PutMapping("/doctors/{doctorId}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable Long doctorId, @RequestBody Doctor doctorDetails){
		return doctorService.updateDoctor(doctorId, doctorDetails);
	}
	
	@DeleteMapping("/doctors/{doctorId}")
	public ResponseEntity<Map<String, Boolean>> deleteDoctor(@PathVariable Long doctorId){
		return doctorService.deleteDoctor(doctorId);
	}
	
	

}
