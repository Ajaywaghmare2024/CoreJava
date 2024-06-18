package com.blogs.service;

import java.util.List;

import com.blogs.custom_exception.ResourceNotFoundException;
import com.blogs.entities.Patient;

public interface PatientService {
	// add method for the Add new patient details
	Patient addNewpatient(Patient newPatient);

	// add the method to get all the list of patients

	List<Patient> getAllPatientList();

	// add the method get by ID
	Patient getPatientDetaildById(Long patientId)throws ResourceNotFoundException;

	// 4. Update Patient details
	Patient updatePatientDetails(Patient patient);
}
