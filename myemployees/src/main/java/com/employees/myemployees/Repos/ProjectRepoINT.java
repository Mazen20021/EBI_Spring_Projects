package com.employees.myemployees.Repos;

import com.employees.myemployees.Models.Entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepoINT extends JpaRepository<ProjectEntity, Long> {

    List<ProjectEntity> findAllByTaskEntityId(Long id);
}
