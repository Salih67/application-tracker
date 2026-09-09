package com.applicationtracker.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    @Column(name = "company_name", nullable = false, unique = true)
    private String companyName;

    public Company() {}

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public Long getId() {return id;}

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
