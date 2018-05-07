package com.v2Technologies.project_management_system.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TBL_COMPANY")
public class Company 
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long companyId;
	
	@Column(name="COMAPNY_NAME",unique=true)
	String companyName;
	
	@Column(name="ADMIN_NAME",nullable=false)
	String adminName;
	
	@Column(name="PASSWORD",nullable=false)
	String password;
	
	@OneToMany(fetch=FetchType.LAZY)
	private Set<Employee> employees;
	
	public Company() {
		// TODO Auto-generated constructor stub
		this.employees=new HashSet<>();
	}

	public Company(String companyName, String adminName, String password) {
		super();
		this.companyName = companyName;
		this.adminName = adminName;
		this.password = password;
		this.employees=new HashSet<>();
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	/*@ManyToOne(fetch=FetchType.LAZY)
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}*/
	
	public void associateEmployee(Employee e)
	{
		employees.add(e);
	}
	
	
}
