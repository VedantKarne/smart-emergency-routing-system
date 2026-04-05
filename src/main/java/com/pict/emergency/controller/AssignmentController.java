package com.pict.emergency.controller;

import com.pict.emergency.entity.Assignment;
import com.pict.emergency.exception.ResourceNotFoundException;
import com.pict.emergency.repository.AssignmentRepository;
import com.pict.emergency.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assign")
public class AssignmentController {

    @Autowired
    private AssignmentService service;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @PostMapping("/{id}")
    public Assignment assign(@PathVariable Long id) {
        return service.assignHospital(id);
    }

    @GetMapping
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Assignment getById(@PathVariable Long id) {
        return assignmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Assignment not found"));
    }
}