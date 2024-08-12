package com.employees.myemployees.Services;


import com.employees.myemployees.Models.DTO.ProjectDTO;

import java.util.List;

public interface ProjectServiceINT {

    List<ProjectDTO> findAll();
    ProjectDTO findById(long id);
    ProjectDTO save(ProjectDTO projectDTO);
    ProjectDTO deleteById(long id);
    List<ProjectDTO> getProjectByTaskID(long id);

}
