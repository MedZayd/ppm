package com.perso.ppm.repository;

import com.perso.ppm.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project findProjectByCodeAndTitle(String code, String title);
}
