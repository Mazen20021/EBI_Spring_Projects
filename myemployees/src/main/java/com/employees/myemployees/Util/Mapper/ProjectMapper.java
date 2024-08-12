package com.employees.myemployees.Util.Mapper;

import com.employees.myemployees.Models.DTO.EmployeesDTO;
import com.employees.myemployees.Models.DTO.ProjectDTO;
import com.employees.myemployees.Models.Entity.EmployeeEntity;
import com.employees.myemployees.Models.Entity.ProjectEntity;

public class ProjectMapper {
    public static ProjectDTO Project_Entity_TO_DTO(ProjectEntity projectEntity)
    {
        if(projectEntity != null)
        {
            ProjectDTO projectDTO = new ProjectDTO();
            projectDTO.setId(projectEntity.getId());
            projectDTO.setName(projectEntity.getName());
            projectDTO.setDescription(projectEntity.getDescription());
            projectDTO.setTaskDTO(TaskMapper.Task_Entity_TO_DTO(projectEntity.getTaskEntity()));
            return projectDTO;
        }
        return null;

    }
    public static ProjectEntity Project_DTO_To_Entity(ProjectDTO projectDTO)
    {
        if(projectDTO != null)
        {
            ProjectEntity projectEntity = new ProjectEntity();
            projectEntity.setId(projectDTO.getId());
            projectEntity.setName(projectDTO.getName());
            projectEntity.setDescription(projectDTO.getDescription());
            projectEntity.setTaskEntity(TaskMapper.Task_DTO_To_Entity(projectDTO.getTaskDTO()));
            return projectEntity;
        }
        return null;

    }

}
