package com.blogs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.entities.Patient;
import com.blogs.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {
	// add the dependacy

	@Autowired
	private PatientService patientService;

	// add the default Constructor
	public PatientController() {
		System.out.println("in patient controller" + getClass());
	}

	// add the post method to add patient
	@PostMapping
	public Patient addPatientDetails(@RequestBody Patient patient) {
		System.out.println("in add new patient " + patient);
		return patientService.addNewpatient(patient);
	}

	// add the get method for display the List
	@GetMapping
	public List<Patient> getAllPatientDetails() {
		System.out.println("add new patient" + getClass());
		return patientService.getAllPatientList();
	}
	// Get a patient by given id
//	@GetMapping 
//	public Patient get

	@GetMapping("/{patientId}")
	public Patient getPatientDetailsById(@PathVariable Long patientId) {
		try {
		System.out.println("in get Patient details " + getClass());
		return patientService.getPatientDetaildById(patientId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//update the patient details
	@PutMapping
	public Patient updatePatientInfo(@RequestBody Patient patient) {
		System.out.println("in update info"+getClass());
		return patientService.updatePatientDetails(patient);
	}

}
