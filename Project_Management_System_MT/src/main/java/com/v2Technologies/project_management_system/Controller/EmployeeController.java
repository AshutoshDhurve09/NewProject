package com.v2Technologies.project_management_system.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.v2Technologies.project_management_system.Repository.CompanyRepository;
import com.v2Technologies.project_management_system.Repository.DesignationRepository;
import com.v2Technologies.project_management_system.Repository.EmployeeRepository;
import com.v2Technologies.project_management_system.entity.Company;
import com.v2Technologies.project_management_system.entity.Designation;
import com.v2Technologies.project_management_system.entity.Employee;


@Controller
@RequestMapping("/employee")
@SessionAttributes("company")
public class EmployeeController {
	
	@Autowired
	CompanyRepository companyrepo;
	
	
	@Autowired
	DesignationRepository desiRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	
	
	
	
	@GetMapping("/employees")
	public String showAllEmployee(Model m)
	{
		Iterable<Employee> li = empRepo.findAll();

		m.addAttribute("employees", li);
		return "employee/allEmployee";
	}
	

	@GetMapping("/home")
	public String showHome(Model m)
	{
		
		Company company=new Company();
		List<Company> li=companyrepo.findAll();
		List<String> companyNames=new ArrayList<>();
		for(Company c:li)
		{
			companyNames.add(c.getCompanyName());
		}
		m.addAttribute("company", company);
		m.addAttribute("companyNames", companyNames);
		return "Home/home";
	}
	
	 
	@GetMapping("/add")
	public String showAddUser(Model m,HttpSession s)
	{
		Employee e=new Employee();
		List<Designation> li=desiRepo.findAll();
		List<String> desi=new ArrayList<>();
		for(Designation d:li)
		{
			desi.add(d.getDesignation());
		}
		m.addAttribute("emp", e);
		m.addAttribute("designations", desi);
		return "employee/addEmployee";
	}
	
	@PostMapping("/add")
	public String SaveUser(@ModelAttribute("emp") Employee employee,Model m)
	{
		System.out.println(employee);
		Designation d = employee.getDesignation();
		//Company c=employee.getCompany();
		d.setDesignationId(desiRepo.findByDesignation(employee.getDesignation().getDesignation()).getDesignationId());
		//c.setCompanyName(companyrepo.findByCompanyName(employee.getCompany().getCompanyId()));
		System.out.println(employee.getDesignation().getDesignation());
		System.out.println(employee.getDesignation().getDesignationId());
		//System.out.println(employee.getCompany().getCompanyId());
		employee =  empRepo.save(employee);
		Iterable<Employee> li = empRepo.findAll();
		m.addAttribute("employee", li);
		return "employee/allEmployee";
		
	}
	@GetMapping("/logout")
	public String logout(HttpSession s,Model m)
	{
		
		Company company=new Company();
		List<Company> li=companyrepo.findAll();
		List<String> companyNames=new ArrayList<>();
		
		for(Company c:li)
		{
			companyNames.add(c.getCompanyName());
		}
		m.addAttribute("company", company);
		m.addAttribute("companyNames", companyNames);
		s.invalidate();
		return "Company/companyAdminLogin";
	}

	
	
	
}
