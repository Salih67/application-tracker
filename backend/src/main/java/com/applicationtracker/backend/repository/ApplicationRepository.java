package com.applicationtracker.backend.repository;

import com.applicationtracker.backend.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
