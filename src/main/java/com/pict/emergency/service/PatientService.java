package com.pict.emergency.service;

import com.pict.emergency.entity.Patient;
import com.pict.emergency.exception.ResourceNotFoundException;
import com.pict.emergency.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepo;

    // CREATE
    public Patient save(Patient patient) {
        return patientRepo.save(patient);
    }

    // READ ALL
    public List<Patient> getAll() {
        return patientRepo.findAll();
    }

    // READ BY ID
    public Patient getById(Long id) {
        return patientRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID: " + id));
    }

    // UPDATE
    public Patient update(Long id, Patient updatedPatient) {
        Patient existing = getById(id);

        existing.setName(updatedPatient.getName());
        existing.setSeverity(updatedPatient.getSeverity());
        existing.setRequiredFacility(updatedPatient.getRequiredFacility());

        return patientRepo.save(existing);
    }

    // DELETE
    public void delete(Long id) {
        Patient existing = getById(id);
        patientRepo.delete(existing);
    }
}