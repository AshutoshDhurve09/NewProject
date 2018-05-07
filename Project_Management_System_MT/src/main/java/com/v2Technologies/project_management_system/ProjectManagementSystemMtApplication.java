package com.v2Technologies.project_management_system;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.v2Technologies.project_management_system.Repository.CompanyRepository;
import com.v2Technologies.project_management_system.Repository.DesignationRepository;
import com.v2Technologies.project_management_system.Repository.EmployeeRepository;
import com.v2Technologies.project_management_system.Repository.ProjectRepository;
import com.v2Technologies.project_management_system.Repository.TaskRepository;
import com.v2Technologies.project_management_system.entity.Company;
import com.v2Technologies.project_management_system.entity.Designation;
import com.v2Technologies.project_management_system.entity.Employee;
import com.v2Technologies.project_management_system.entity.Project;
import com.v2Technologies.project_management_system.entity.Task;

@SpringBootApplication
public class ProjectManagementSystemMtApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(ProjectManagementSystemMtApplication.class, args);
		
		/*EmployeeRepository employeeRepository = ctx.getBean(EmployeeRepository.class);
		CompanyRepository companyRepository = ctx.getBean(CompanyRepository.class);
		ProjectRepository projectRepository = ctx.getBean(ProjectRepository.class);
		TaskRepository taskRepository = ctx.getBean(TaskRepository.class);
		DesignationRepository designationRepository=ctx.getBean(DesignationRepository.class);
		
		
		//Add Company
		Company company=new Company("V2Technologies","abcd","1234");
		company=companyRepository.save(company);
		
		
		//Add Designation
		Designation designation=new Designation((long) 1,"projectManager");
		Designation designation2=new Designation((long)2,"Programmer");
		
		designation=designationRepository.save(designation);
		designation2=designationRepository.save(designation2);
		
		//Add Employee
		Employee employee=new Employee();
		employee.setEmployeeName("Pratik Gholap");
		employee.setDesignation(designation);
		employee.setEmailId("pggholap@gmail.com");
		employee.setPassword("1234");
		employee.setCompany(company);
		//company.getEmployees().add(employee);
		employee=employeeRepository.save(employee);

		Employee employee2=new Employee();
		
		employee2.setEmployeeName("Jayesh Bhoir");
		employee2.setDesignation(designation2);
		employee2.setEmailId("jb@gmail.com");
		employee2.setPassword("1234");
		employee2.setCompany(company);
		//company.getEmployees().add(employee2);
		employee2=employeeRepository.save(employee2);

		
		company.associateEmployee(employee);
		company.associateEmployee(employee2);
		
		company.getEmployees().add(employee);
		company.getEmployees().add(employee2);
		companyRepository.save(company);
		
		//Add Project
		Project project=new Project("Inventory",new Date(),new Date(),"80");
		project.setEmployee(employee);
		projectRepository.save(project);
		employee.getProjects().add(project);
		employeeRepository.save(employee);
		
		Task task=new Task("Task1",new Date(),new Date(),"45",false);
		task.setEmployee(employee2);
		task.setAssignProject(project);
		taskRepository.save(task);
		employee2.getTasks().add(task);
		employeeRepository.save(employee2);
	
		
		//////////////////////////////////////////////////////////////////////////////////
		
		Company company2=new Company("Squad Info","xyz","1234");
		company2=companyRepository.save(company2);
		
		Employee employee3=new Employee();
		employee3.setEmployeeName("Ashutosh Dhurve");
		employee3.setDesignation(designation);
		employee3.setEmailId("ad@gmail.com");
		employee3.setPassword("1234");
		employee3.setCompany(company2);
		employee3=employeeRepository.save(employee3);
		
		Employee employee4=new Employee();
		employee4.setEmployeeName("Santosh Avhad");
		employee4.setDesignation(designation2);
		employee4.setEmailId("sa@gmail.com");
		employee4.setPassword("1234");
		employee4.setCompany(company2);
		employee4=employeeRepository.save(employee4);
		
		company2.associateEmployee(employee3);
		company2.associateEmployee(employee4);
		
		
		company2.getEmployees().add(employee3);
		company2.getEmployees().add(employee4);
		companyRepository.save(company2);
		
		
		Project project2=new Project("Rebet Engine",new Date(),new Date(),"70");
		project2.setEmployee(employee3);
		projectRepository.save(project2);
		employee3.getProjects().add(project2);
		employeeRepository.save(employee3);
		
		Task task2=new Task("task1", new Date(), new Date(),"30",false);
		task2.setEmployee(employee4);
		task2.setAssignProject(project2);
		taskRepository.save(task2);
		employee4.getTasks().add(task2);
		employeeRepository.save(employee4);
		
	
*/
		

	}
}
