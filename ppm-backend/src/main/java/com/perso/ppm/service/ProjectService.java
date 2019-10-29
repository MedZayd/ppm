package com.perso.ppm.service;

import com.perso.ppm.domain.Project;
import com.perso.ppm.repository.ProjectRepository;
import com.perso.ppm.util.ResponseEntity;
import com.perso.ppm.util.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public ResponseEntity<Project> addProject(Project project){
        Project existingProject = projectRepository.findProjectByCodeAndTitle(project.getCode(), project.getTitle());
        if(existingProject!=null){
            return new ResponseEntity<>(ResponseStatus.ERROR, "Project code & title found in database.", null);
        }
        projectRepository.save(project);
        return new ResponseEntity<>(ResponseStatus.SUCCESS, "Project created successfully", project);
    }

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }
}
