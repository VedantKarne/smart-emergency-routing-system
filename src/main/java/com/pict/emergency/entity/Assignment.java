package com.pict.emergency.entity;

import jakarta.persistence.*;

@Entity
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Patient patient;

    @ManyToOne
    private Hospital hospital;

    public Assignment() {}

    public Assignment(Long id, Patient patient, Hospital hospital) {
        this.id = id;
        this.patient = patient;
        this.hospital = hospital;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public Hospital getHospital() { return hospital; }
    public void setHospital(Hospital hospital) { this.hospital = hospital; }
}