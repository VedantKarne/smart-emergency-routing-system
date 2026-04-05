package com.pict.emergency.controller;

import com.pict.emergency.entity.Patient;
import com.pict.emergency.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService service;

    @PostMapping
    public Patient add(@Valid @RequestBody Patient p) {
        return service.save(p);
    }

    @GetMapping
    public List<Patient> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Patient update(@PathVariable Long id, @RequestBody Patient p) {
        return service.update(id, p);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Patient deleted successfully";
    }
}