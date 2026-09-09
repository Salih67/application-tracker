package com.applicationtracker.backend.service;

import com.applicationtracker.backend.entity.Application;
import com.applicationtracker.backend.entity.Company;
import com.applicationtracker.backend.exception.ApplicationNotFoundException;
import com.applicationtracker.backend.repository.ApplicationRepository;
import com.applicationtracker.backend.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final CompanyRepository companyRepository;

    public ApplicationService(ApplicationRepository applicationRepository, CompanyRepository companyRepository) {
        this.applicationRepository = applicationRepository;
        this.companyRepository = companyRepository;
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("Application with id " + id + " not found"));
    }

    public Application createApplication(Application application){
        Company company = companyRepository
                .findByCompanyName(application.getCompany().getCompanyName())
                .orElseGet(()->companyRepository.save(application.getCompany()));
        application.setCompany(company);
        return applicationRepository.save(application);
    }

    public void deleteApplication(Long id){
        Application application = getApplicationById(id);
        applicationRepository.delete(application);
    }

    public Application updateApplication(Long id, Application updatedApplication){
        Application existingApplication = getApplicationById(id);



        Company company = companyRepository
                .findByCompanyName(updatedApplication.getCompany().getCompanyName())
                .orElseGet(() -> companyRepository.save(updatedApplication.getCompany()));

        existingApplication.setPosition(updatedApplication.getPosition());
        existingApplication.setUrl(updatedApplication.getUrl());
        existingApplication.setStatus(updatedApplication.getStatus());
        existingApplication.setSalaryExpectation(updatedApplication.getSalaryExpectation());
        existingApplication.setCompany(company);
        
        return applicationRepository.save(existingApplication);
    }

}
