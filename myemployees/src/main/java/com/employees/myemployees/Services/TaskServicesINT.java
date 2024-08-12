package com.employees.myemployees.Services;

import com.employees.myemployees.Models.DTO.TaskDTO;

import java.util.List;

public interface TaskServicesINT {

    List<TaskDTO> findAll();
    TaskDTO findById(long id);
    boolean save(TaskDTO taskDTO);
    boolean deleteById(long id);
}
