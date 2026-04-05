package com.pict.emergency.service;

import com.pict.emergency.entity.*;
import com.pict.emergency.exception.*;
import com.pict.emergency.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AssignmentService {

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private HospitalRepository hospitalRepo;

    @Autowired
    private AssignmentRepository assignmentRepo;

    public Assignment assignHospital(Long patientId) {

        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

        List<Hospital> hospitals = hospitalRepo.findAll();

        List<Hospital> filtered = new ArrayList<>();

        for (Hospital h : hospitals) {
            if (patient.getSeverity() >= 8) {
                if (h.getIcuBeds() > 0) filtered.add(h);
            } else {
                if (h.getGeneralBeds() > 0) filtered.add(h);
            }
        }

        if (filtered.isEmpty()) {
            throw new NoHospitalAvailableException("No hospital available");
        }

        Hospital best = filtered.get(0);

        if (patient.getSeverity() >= 8) {
            best.setIcuBeds(best.getIcuBeds() - 1);
        } else {
            best.setGeneralBeds(best.getGeneralBeds() - 1);
        }

        hospitalRepo.save(best);

        Assignment assignment = new Assignment();
        assignment.setPatient(patient);
        assignment.setHospital(best);

        return assignmentRepo.save(assignment);
    }
}