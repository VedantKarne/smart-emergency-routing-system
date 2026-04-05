package com.pict.emergency.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @Min(1)
    @Max(10)
    private int severity;

    @NotNull
    private String requiredFacility;

    public Patient() {}

    public Patient(Long id, String name, int severity, String requiredFacility) {
        this.id = id;
        this.name = name;
        this.severity = severity;
        this.requiredFacility = requiredFacility;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getSeverity() { return severity; }
    public void setSeverity(int severity) { this.severity = severity; }

    public String getRequiredFacility() { return requiredFacility; }
    public void setRequiredFacility(String requiredFacility) { this.requiredFacility = requiredFacility; }
}