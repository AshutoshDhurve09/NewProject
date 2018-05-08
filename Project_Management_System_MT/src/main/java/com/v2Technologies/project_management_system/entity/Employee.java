package com.v2Technologies.project_management_system.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="TBL_EMPLOYEE")
public class Employee implements Comparable<Employee> , Serializable
{
  
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long employeeId;
	
	@Column(name="EMPLOYEE_NAME",nullable=false)
	String employeeName;
	
	//@Column(name="DESIGNATION",nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="DESIGNATION", nullable=false)
	private Designation designation;
	
	 
	

	@Column(name="EMAIL_ID",unique=true,nullable=false)
	private String emailId;
	
	@Column(name="PASSWORD",nullable=false)
	private String password;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COMPANY_ID_FK",nullable=false)
	private Company company;
	
	@OneToMany(fetch=FetchType.LAZY)
	Set<Project> projects;
	
	@OneToMany(fetch=FetchType.LAZY)
	Set<Task> tasks;
	
	
	
	
	
	

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	
	public Employee() {
		this.projects=new HashSet<>();
		this.tasks=new HashSet<>();
	}

	public Employee(String employeeName, Designation designation, String emailId, String password) {
		super();

		this.employeeName = employeeName;
		this.designation = designation;
		this.emailId = emailId;
		this.password = password;
		this.projects=new HashSet<>();
		this.tasks=new HashSet<>();
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/*public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}*/
	

	public String getEmailId() {
		return emailId;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	


	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", designation=" + designation
				+ ", emailId=" + emailId + ", password=" + password + ", company=" + company + ", projects=" + projects
				+ ", tasks=" + tasks + "]";
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public void allocateProject(Project project)
	{
		projects.add(project);
		project.allocateEmployee(this);
	}
	
	public void allocateTask(Task task)
	{
		tasks.add(task);
		task.allocateEmployee(this);
	}

	@Override
	public int compareTo(Employee emp) {
		
		return employeeName.compareTo(emp.getEmployeeName());
	}
}
