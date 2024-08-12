package com.employees.myemployees.Services;

import com.employees.myemployees.ExceptionHandler.CustomExceptions;
import com.employees.myemployees.Models.DTO.EmployeesDTO;
import com.employees.myemployees.Models.Entity.EmployeeEntity;
import com.employees.myemployees.Models.Entity.ProjectEntity;
import com.employees.myemployees.Repos.EmployeesReposInt;
import com.employees.myemployees.Repos.ProjectRepoINT;
import com.employees.myemployees.Util.Mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("emp")
public class EmployeesServices implements  EmployeesServicesInt{

    @Autowired
    EmployeesReposInt employeesReposInt;
    @Autowired
    ProjectRepoINT projectRepoInt;

    @Override
    public List<EmployeesDTO> findAll() {
        return employeesReposInt.findAll().stream().map(EmployeeMapper::Employee_Entity_TO_DTO).toList();
    }

    @Override
    public EmployeesDTO findById(long id) {
        Optional<EmployeeEntity> employeeEntity = employeesReposInt.findById(id);
        if (employeeEntity.isPresent())
        {
            return EmployeeMapper.Employee_Entity_TO_DTO(employeeEntity.get());
        }else
        {
            throw new CustomExceptions("20" , "User Not Found");
        }

    }

    @Override
    @Transactional
    public EmployeesDTO save(EmployeesDTO employeesDTO) {
        EmployeeEntity employeeEntity = EmployeeMapper.Employee_DTO_To_Entity(employeesDTO);
        try{
            employeesReposInt.save(employeeEntity);
            return EmployeeMapper.Employee_Entity_TO_DTO(employeeEntity);
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public EmployeesDTO update(EmployeesDTO employeesDTO,long id) {

        Optional <EmployeeEntity> employeeEntity = employeesReposInt.findById(id);
        if(employeeEntity.isPresent())
        {
            EmployeeEntity employeeEntity1 = EmployeeMapper.Employee_DTO_To_Entity(employeesDTO);
            employeeEntity1.setId(id);
            employeesReposInt.save(employeeEntity1);
            employeeEntity = Optional.of(employeeEntity1);
            return EmployeeMapper.Employee_Entity_TO_DTO(employeeEntity.get());
        }else
        {
            throw new CustomExceptions("20" , "Could not update this user of ID: "+id+" User Not Found");
        }

    }

    @Override
    public EmployeesDTO deleteById(EmployeesDTO employeesDTO,long id) {
        Optional<EmployeeEntity> employeeEntity = employeesReposInt.findById(id);
        if(employeeEntity.isPresent())
        {
           employeesReposInt.delete(employeeEntity.get());
        }else
        {
            throw new CustomExceptions("20" , "Could not delete this User of ID: "+id+" User Not Found");
        }
        return null;
    }

    @Override
    public boolean assignProject(Long employeeID, Long projectID) {
        Optional<EmployeeEntity> employeeEntity = employeesReposInt.findById(employeeID);
        if(employeeEntity.isPresent())
        {
            Optional <ProjectEntity> projectEntity = projectRepoInt.findById(projectID);
            if(projectEntity.isPresent())
            {
                employeeEntity.get().setProjectEntity(projectEntity.get());
                employeesReposInt.save(employeeEntity.get());
                return true;
            }
        }

        return false;
    }

    public List<EmployeesDTO> GetEmployeeByProjectID(Long projectID) {

        Optional<ProjectEntity> projectEntity = projectRepoInt.findById(projectID);
        if(projectEntity.isPresent())
        {
            List<EmployeeEntity> employeeEntities = employeesReposInt.findAllByProjectEntity(projectEntity.get());
            return employeeEntities.stream().map(EmployeeMapper::Employee_Entity_TO_DTO).toList();
        }

        return null;
    }
}
