package com.perso.ppm.web;

import com.perso.ppm.domain.Project;
import com.perso.ppm.service.ProjectService;
import com.perso.ppm.util.ResponseEntity;
import com.perso.ppm.util.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectRestController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects(){
         return new ResponseEntity<>(ResponseStatus.SUCCESS, "Fetching all projects", projectService.getAllProjects());
    }
}
