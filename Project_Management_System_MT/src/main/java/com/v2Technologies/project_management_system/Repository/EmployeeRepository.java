package com.v2Technologies.project_management_system.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.v2Technologies.project_management_system.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,java.lang.Long>
{
	List<Employee> findByemployeeName(String Name);
}
