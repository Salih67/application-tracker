package com.applicationtracker.backend.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table (name = "application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long id;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name="salary_expectation", precision=10, scale=2)
    private BigDecimal salaryExpectation;

    @Column(name = "url", columnDefinition = "TEXT")
    private String url;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ApplicationStatus status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Application(){}

    public Application(String position, String url, BigDecimal salaryExpectation, ApplicationStatus status, Company company) {
        this.position = position;
        this.url = url;
        this.salaryExpectation = salaryExpectation;
        this.status = status;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public BigDecimal getSalaryExpectation() {
        return salaryExpectation;
    }
    public void setSalaryExpectation(BigDecimal salaryExpectation) {
        this.salaryExpectation = salaryExpectation;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public ApplicationStatus getStatus() {
        return status;
    }
    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

}
