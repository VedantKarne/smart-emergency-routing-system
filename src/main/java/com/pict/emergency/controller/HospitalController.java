package com.pict.emergency.controller;

import com.pict.emergency.entity.Hospital;
import com.pict.emergency.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {

    @Autowired
    private HospitalService service;

    @PostMapping
    public Hospital add(@RequestBody Hospital h) {
        return service.save(h);
    }

    @GetMapping
    public List<Hospital> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Hospital update(@PathVariable Long id, @RequestBody Hospital h) {
        return service.update(id, h);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Hospital deleted successfully";
    }
}