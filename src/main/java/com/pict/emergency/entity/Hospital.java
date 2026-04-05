package com.pict.emergency.entity;

import jakarta.persistence.*;

@Entity
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int icuBeds;
    private int generalBeds;

    public Hospital() {}

    public Hospital(Long id, String name, int icuBeds, int generalBeds) {
        this.id = id;
        this.name = name;
        this.icuBeds = icuBeds;
        this.generalBeds = generalBeds;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getIcuBeds() { return icuBeds; }
    public void setIcuBeds(int icuBeds) { this.icuBeds = icuBeds; }

    public int getGeneralBeds() { return generalBeds; }
    public void setGeneralBeds(int generalBeds) { this.generalBeds = generalBeds; }
}