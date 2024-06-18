package com.blogs.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.custom_exception.ResourceNotFoundException;
import com.blogs.entities.Patient;
import com.blogs.repository.PatientRepository;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public Patient addNewpatient(Patient newPatient) {
		System.out.println("in addPatient ctro" + getClass());

		return patientRepository.save(newPatient);
	}

	@Override
	public List<Patient> getAllPatientList() {
		System.out.println("int list" + getClass());
		return patientRepository.findAll();
	}

	@Override
	public Patient getPatientDetaildById(Long patientId) throws ResourceNotFoundException {
		System.out.println("in get patient details " + getClass());

		Optional<Patient> optional = patientRepository.findById(patientId);
		return optional.orElseThrow(() -> new ResourceNotFoundException("invalid patient ID"));
	}

	@Override
	public Patient updatePatientDetails(Patient patient) {
		System.out.println("in update " + getClass());
		return patientRepository.save(patient);
	}

}
