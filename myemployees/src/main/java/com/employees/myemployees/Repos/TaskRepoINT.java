package com.employees.myemployees.Repos;

import com.employees.myemployees.Models.Entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepoINT extends JpaRepository<TaskEntity, Long> {
}
