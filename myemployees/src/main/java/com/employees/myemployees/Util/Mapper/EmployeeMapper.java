package com.employees.myemployees.Util.Mapper;

import com.employees.myemployees.Models.DTO.EmployeesDTO;
import com.employees.myemployees.Models.Entity.EmployeeEntity;

public class EmployeeMapper {
    public static EmployeesDTO Employee_Entity_TO_DTO(EmployeeEntity employeeEntity)
    {
        EmployeesDTO employeesDTO = new EmployeesDTO();
        employeesDTO.setFirstName(employeeEntity.getFname());
        employeesDTO.setLastName(employeeEntity.getLname());
        employeesDTO.setSalary(employeeEntity.getSalary());
        employeesDTO.setDepartmentId(Integer.parseInt(employeeEntity.getDepID()));
        employeesDTO.setId(employeeEntity.getId());
        employeesDTO.setProjectDTO(ProjectMapper.Project_Entity_TO_DTO(employeeEntity.getProjectEntity()));
        return employeesDTO;
    }
    public static EmployeeEntity Employee_DTO_To_Entity(EmployeesDTO employeeDTO)
    {
        EmployeeEntity employeesEntity = new EmployeeEntity();
        employeesEntity.setFname(employeeDTO.getFirstName());
        employeesEntity.setLname(employeeDTO.getLastName());
        employeesEntity.setSalary(employeeDTO.getSalary());
        employeesEntity.setDepID(String.valueOf(employeeDTO.getDepartmentId()));
        employeesEntity.setId(employeesEntity.getId());
        employeesEntity.setProjectEntity( ProjectMapper.Project_DTO_To_Entity(employeeDTO.getProjectDTO()));
        return employeesEntity;
    }


}
