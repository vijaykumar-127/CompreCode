package com.vijay.comp.doctor.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vijay.comp.doctor.entity.Doctor;
import com.vijay.comp.doctor.exception.ResourceNotFoundException;
import com.vijay.comp.doctor.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;

	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	public Doctor createDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	public ResponseEntity<Doctor> getDoctorById(Long doctorId) {
		Doctor doctor=doctorRepository.findById(doctorId)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor not exists with id :"+doctorId));
		return ResponseEntity.ok(doctor);

	}

	public ResponseEntity<Doctor> updateDoctor(Long doctorId, Doctor doctorDetails) {
		Doctor doctor=doctorRepository.findById(doctorId)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor not exists with id :"+doctorId));
		doctor.setDoctorName(doctorDetails.getDoctorName());
		doctor.setDoctorAge(doctorDetails.getDoctorAge());
		doctor.setDoctorGender(doctorDetails.getDoctorGender());
		doctor.setDoctorSpecialization(doctorDetails.getDoctorSpecialization());
		
		Doctor updatedDoctor=doctorRepository.save(doctor);
		return ResponseEntity.ok(updatedDoctor);
	}

	public ResponseEntity<Map<String, Boolean>> deleteDoctor(Long doctorId) {
		Doctor doctor=doctorRepository.findById(doctorId)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor not exists with id :"+doctorId));
		doctorRepository.delete(doctor);
		Map<String, Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}


	
	

}
