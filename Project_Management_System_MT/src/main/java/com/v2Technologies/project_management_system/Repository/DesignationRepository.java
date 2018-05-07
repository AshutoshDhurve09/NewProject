package com.v2Technologies.project_management_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.v2Technologies.project_management_system.entity.Designation;

public interface DesignationRepository extends JpaRepository<Designation,java.lang.Long>{

	Designation findByDesignation(String designation);

}
