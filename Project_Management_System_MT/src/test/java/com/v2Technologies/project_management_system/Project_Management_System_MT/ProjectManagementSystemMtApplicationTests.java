package com.v2Technologies.project_management_system.Project_Management_System_MT;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.v2Technologies.project_management_system.Repository.CompanyRepository;
import com.v2Technologies.project_management_system.Repository.EmployeeRepository;
import com.v2Technologies.project_management_system.Repository.ProjectRepository;
import com.v2Technologies.project_management_system.Repository.TaskRepository;
import com.v2Technologies.project_management_system.entity.Company;
import com.v2Technologies.project_management_system.entity.Employee;
import com.v2Technologies.project_management_system.entity.Project;
import com.v2Technologies.project_management_system.entity.Task;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext()
@Transactional()
public class ProjectManagementSystemMtApplicationTests {

/*	@Test
	public void contextLoads() {
	}*/

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	
	public static void main(String[] args) {
		
	}
	
	
	
	@Test()
	public void addAll()
	{
		
		//Add Company
		Company company=new Company("V2Technologies","abcd","1234");
		//company=companyRepository.save(company);
		
		//Add Employee
		
		/*Employee employee=new Employee("Pratik Gholap","ProjectManager","pg@gmail.com","1234");
		employee.setCompany(company);
		employee=employeeRepository.save(employee);*/

		/*Employee employee2=new Employee("Jayesh BHoir","Programmer","jb@gmail.com","1234");
		employee2.setCompany(company);
		employee2=employeeRepository.save(employee2);*/

		
		/*company.associateEmployee(employee);
		company.associateEmployee(employee2);*/
		
/*		company.getEmployees().add(employee);
		company.getEmployees().add(employee2);*/
		companyRepository.save(company);
		
		//Add Project
		/*Project project=new Project("Inventory",new Date(),new Date(),"80");
		project.setEmployee(employee);
		projectRepository.save(project);
		employee.getProjects().add(project);
		employeeRepository.save(employee);
		
		Task task=new Task("Task1",new Date(),new Date(),"45",false);
		task.setEmployee(employee2);
		task.setAssignProject(project);
		taskRepository.save(task);
		employee2.getTasks().add(task);
		employeeRepository.save(employee2);*/
	
		
		//////////////////////////////////////////////////////////////////////////////////
		
		Company company2=new Company("Squad Info","xyz","1234");
		//company2=companyRepository.save(company2);
		
		/*Employee employee3=new Employee("Ashutosh Dhurve","ProjectManager","ad@gmail.com","1234");
		employee3.setCompany(company2);
		employee3=employeeRepository.save(employee3);
		
		Employee employee4=new Employee("Santosh Avhad","Programmer","sa@gmail.com","1234");
		employee4.setCompany(company2);
		employee4=employeeRepository.save(employee4);
		
		company2.associateEmployee(employee3);
		company2.associateEmployee(employee4);*/
		
		
/*		company2.getEmployees().add(employee3);
		company2.getEmployees().add(employee4);*/
		companyRepository.save(company2);
		
		
		/*Project project2=new Project("Rebet Engine",new Date(),new Date(),"70");
		project2.setEmployee(employee3);
		projectRepository.save(project2);
		employee3.getProjects().add(project2);
		employeeRepository.save(employee3);
		
		Task task2=new Task("task1", new Date(), new Date(),"30",false);
		task2.setEmployee(employee4);
		task2.setAssignProject(project2);
		taskRepository.save(task2);
		employee4.getTasks().add(task2);
		employeeRepository.save(employee4);*/
		
	

		
		
	}
	
		
		
		
		
	}
	
