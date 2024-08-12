package com.employees.myemployees.Services;

import com.employees.myemployees.Models.DTO.EmployeesDTO;
import com.employees.myemployees.Models.DTO.ProjectDTO;

import java.sql.SQLException;
import java.util.List;

public interface EmployeesServicesInt {
    List<EmployeesDTO> findAll();
    EmployeesDTO findById(long id);
    EmployeesDTO save(EmployeesDTO employeesDTO);
    EmployeesDTO update(EmployeesDTO employeesDTO, long id);
    EmployeesDTO deleteById(EmployeesDTO employeesDTO,long id);
    boolean assignProject(Long employeeID ,Long projectID);
    List<EmployeesDTO> GetEmployeeByProjectID(Long projectID);
}
