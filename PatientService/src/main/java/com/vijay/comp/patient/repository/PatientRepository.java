package com.vijay.comp.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vijay.comp.patient.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
