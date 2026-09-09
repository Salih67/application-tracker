package com.applicationtracker.backend.controller;

import com.applicationtracker.backend.entity.Application;
import com.applicationtracker.backend.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService){
        this.applicationService = applicationService;
    }

    @GetMapping
    public List<Application> getAllApplications(){
        return applicationService.getAllApplications();
    }

    @GetMapping("/{id}")
    public Application getApplicationById(@PathVariable Long id){
        return applicationService.getApplicationById(id);
    }

    @PostMapping
    public Application createApplication(@Valid @RequestBody Application application){
        return applicationService.createApplication(application);
    }

    @PutMapping("/{id}")
    public Application updateApplication(@PathVariable Long id,@Valid @RequestBody Application application){
        return applicationService.updateApplication(id, application);
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable Long id){
        applicationService.deleteApplication(id);
    }
}
