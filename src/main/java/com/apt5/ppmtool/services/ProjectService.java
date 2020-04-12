package com.apt5.ppmtool.services;


import com.apt5.ppmtool.domain.Project;
import com.apt5.ppmtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository  projectRepository;

    public Project saveOrUpdateProject(Project project){


        return projectRepository.save(project);
    }
}
