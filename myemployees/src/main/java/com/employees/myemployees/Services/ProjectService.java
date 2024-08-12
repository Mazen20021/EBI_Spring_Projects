package com.employees.myemployees.Services;

import com.employees.myemployees.ExceptionHandler.CustomExceptions;
import com.employees.myemployees.Models.DTO.ProjectDTO;
import com.employees.myemployees.Models.Entity.ProjectEntity;
import com.employees.myemployees.Models.Entity.TaskEntity;
import com.employees.myemployees.Repos.ProjectRepoINT;
import com.employees.myemployees.Repos.TaskRepoINT;
import com.employees.myemployees.Util.Mapper.ProjectMapper;
import com.employees.myemployees.Util.Mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService implements ProjectServiceINT{
    @Autowired
    ProjectRepoINT projectRepoINT;
    @Autowired
    TaskRepoINT taskRepoINT;

    @Override
    public List<ProjectDTO> findAll() {
        return projectRepoINT.findAll().stream().map(ProjectMapper::Project_Entity_TO_DTO).toList();
    }
    @Override
    public ProjectDTO findById(long id) {
        Optional<ProjectEntity> projectEntity = projectRepoINT.findById(id);
        if (projectEntity.isPresent())
        {
            return ProjectMapper.Project_Entity_TO_DTO(projectEntity.get());
        }else
        {
            throw new CustomExceptions("20" , "User Not Found");
        }

    }
    @Override
    @Transactional
    public ProjectDTO save(ProjectDTO projectDTO) {
        ProjectEntity projectEntity = ProjectMapper.Project_DTO_To_Entity(projectDTO);
        try{
            projectRepoINT.save(projectEntity);
            return ProjectMapper.Project_Entity_TO_DTO(projectEntity);
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

    }


    @Override
    public ProjectDTO deleteById(long id) {
        Optional<ProjectEntity> projectDTO1 = projectRepoINT.findById(id);
        if(projectDTO1.isPresent())
        {
            projectRepoINT.delete(projectDTO1.get());
        }else
        {
            throw new CustomExceptions("20" , "Could not delete this User of ID: "+id+" User Not Found");
        }
        return null;
    }

    @Override
    public List<ProjectDTO> getProjectByTaskID(long id) {
        Optional<TaskEntity> taskEntity = taskRepoINT.findById(id);
        if(taskEntity.isPresent())
        {
            return projectRepoINT.findAllByTaskEntityId(id).stream().map(ProjectMapper::Project_Entity_TO_DTO).toList();
        }

        return null;
    }

}
