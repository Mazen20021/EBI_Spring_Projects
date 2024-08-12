package com.employees.myemployees.Util.Mapper;

import com.employees.myemployees.Models.DTO.TaskDTO;
import com.employees.myemployees.Models.Entity.TaskEntity;

public class TaskMapper {

    public static TaskDTO Task_Entity_TO_DTO(TaskEntity taskEntity)
    {
        if(taskEntity != null)
        {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setId(taskEntity.getId());
            taskDTO.setName(taskEntity.getName());
            taskDTO.setStatus(taskEntity.getStatus());
            taskDTO.setSdate(taskEntity.getSdate());
            taskDTO.setEdate(taskEntity.getEdate());
            return taskDTO;
        }
        return null;

    }
    public static TaskEntity Task_DTO_To_Entity(TaskDTO taskDTO)
    {
        if(taskDTO != null)
        {
            TaskEntity taskEntity = new TaskEntity();
            taskEntity.setId(taskDTO.getId());
            taskEntity.setName(taskDTO.getName());
            taskEntity.setStatus(taskDTO.getStatus());
            taskEntity.setSdate(taskDTO.getSdate());
            taskEntity.setEdate(taskDTO.getEdate());
            return taskEntity;
        }
        return null;

    }



}
