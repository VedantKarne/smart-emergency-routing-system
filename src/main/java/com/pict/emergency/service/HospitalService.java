package com.pict.emergency.service;

import com.pict.emergency.entity.Hospital;
import com.pict.emergency.exception.ResourceNotFoundException;
import com.pict.emergency.repository.HospitalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepo;

    // CREATE
    public Hospital save(Hospital hospital) {
        return hospitalRepo.save(hospital);
    }

    // READ ALL
    public List<Hospital> getAll() {
        return hospitalRepo.findAll();
    }

    // READ BY ID
    public Hospital getById(Long id) {
        return hospitalRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hospital not found with ID: " + id));
    }

    // UPDATE
    public Hospital update(Long id, Hospital updatedHospital) {
        Hospital existing = getById(id);

        existing.setName(updatedHospital.getName());
        existing.setIcuBeds(updatedHospital.getIcuBeds());
        existing.setGeneralBeds(updatedHospital.getGeneralBeds());

        return hospitalRepo.save(existing);
    }

    // DELETE
    public void delete(Long id) {
        Hospital existing = getById(id);
        hospitalRepo.delete(existing);
    }
}