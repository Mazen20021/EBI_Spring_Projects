package com.employees.myemployees.Models.DTO;


import com.employees.myemployees.Models.Entity.TaskEntity;

public class ProjectDTO {

    private Long id;
    private String name;
    private String description;
    private TaskDTO taskDTO;

    public TaskDTO getTaskDTO() {
        return taskDTO;
    }

    public void setTaskDTO(TaskDTO taskDTO) {
        this.taskDTO = taskDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
