package com.employees.myemployees.Repos;

import com.employees.myemployees.Models.Entity.EmployeeEntity;
import com.employees.myemployees.Models.Entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeesReposInt extends JpaRepository<EmployeeEntity, Long> {
        List<EmployeeEntity> findAllByProjectEntity(ProjectEntity projectEntity);
}
