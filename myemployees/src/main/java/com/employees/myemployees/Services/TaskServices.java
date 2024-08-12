package com.employees.myemployees.Services;

import com.employees.myemployees.ExceptionHandler.CustomExceptions;
import com.employees.myemployees.Models.DTO.TaskDTO;
import com.employees.myemployees.Models.Entity.TaskEntity;
import com.employees.myemployees.Repos.TaskRepoINT;
import com.employees.myemployees.Util.Mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServices implements TaskServicesINT {
    @Autowired
    TaskRepoINT taskRepoINT;

    @Override
    public List<TaskDTO> findAll() {
        return taskRepoINT.findAll().stream().map(TaskMapper::Task_Entity_TO_DTO).toList();
    }

    @Override
    public TaskDTO findById(long id) {
        Optional<TaskEntity> taskEntity = taskRepoINT.findById(id);
        return taskEntity.map(TaskMapper::Task_Entity_TO_DTO).orElse(null);
    }

    @Override
    public boolean save(TaskDTO taskDTO) {
        TaskEntity taskEntity = TaskMapper.Task_DTO_To_Entity(taskDTO);
        try {

            taskRepoINT.save(taskEntity);
            return true;

        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteById(long id) {

        Optional<TaskEntity> taskEntity = taskRepoINT.findById(id);
        if (taskEntity.isPresent())
        {
            try {

                taskEntity.ifPresent(entity -> taskRepoINT.delete(entity));
                return true;

            }catch (Exception e)
            {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
