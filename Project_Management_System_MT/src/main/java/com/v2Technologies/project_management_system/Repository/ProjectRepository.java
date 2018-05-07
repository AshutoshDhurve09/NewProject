package com.v2Technologies.project_management_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.v2Technologies.project_management_system.entity.Project;

public interface ProjectRepository extends JpaRepository<Project,java.lang.Long>
{

}
