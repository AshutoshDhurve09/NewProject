package com.v2Technologies.project_management_system.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	
	
	
	@PostMapping("/search")
	public String searchByName(@RequestParam("searchName") String Name,Model m)
	{
		List<Employee> li = empRepo.findByemployeeName(Name);
		m.addAttribute("employees", li);
		return "employee/allEmployee";
	}
	
	@RequestMapping(value="/sortonname",method=RequestMethod.GET)
	public String sortByName(Model m)
	{

		List<Employee> uListOntname=(List<Employee>) empRepo.findAll();
		Collections.sort(uListOntname);
		System.out.println(uListOntname);
		m.addAttribute("employees",uListOntname);
		return "employee/allEmployee";
	}
	
	@PostMapping("/showEditEmployee")
	public String showEditEmployee(@RequestParam("uId") long eId, Model m) {
		
		
		Employee e=new Employee();
		List<Designation> li=desiRepo.findAll();
		List<String> desi=new ArrayList<>();
		for(Designation d:li)
		{
			desi.add(d.getDesignation());
		}
		m.addAttribute("emp", e);
		m.addAttribute("designations", desi);
		
		Optional<Employee> u = empRepo.findById(eId);
		Employee emp = u.get();
		System.out.println("=====================================");
		System.out.println(emp);
		System.out.println("=====================================");
		m.addAttribute("emp", emp);

		return "employee/updateEmployee";
	}
	
	//edit&save
	@PostMapping("/editEmployee")
	@Transactional
	public String editUser(@ModelAttribute("emp") Employee employee, BindingResult bindingResult, Model m) {
		Employee emp = employee;
		//m.addAttribute("checkDate", true);
		m.addAttribute("emp", emp);
		empRepo.save(emp);
		List<Employee> li = (List<Employee>) empRepo.findAll();
		m.addAttribute("employees", li);
		return "employee/allEmployee";
	}
	
	
	
	@RequestMapping(value="showEditEmployee",method=RequestMethod.POST,params={"action=delete"})
	public String deleteEmployee(@RequestParam("uId") long employeeId, Model m)
	{
		System.out.println("IN delete User " + empRepo);
		empRepo.deleteById(employeeId); 
		List<Employee> li = (List<Employee>) empRepo.findAll();
		m.addAttribute("employees", li);
		return "employee/allEmployee";
	}
	
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
	public String SaveUser(@ModelAttribute("emp")@Valid Employee employee,BindingResult bindingResult,Model m)
	{
		//employee.getDesignation().getDesignation();
	
		System.out.println(employee);
		Designation d = employee.getDesignation();
		//Company c=employee.getCompany();
		d.setDesignationId(desiRepo.findByDesignation(employee.getDesignation().getDesignation()).getDesignationId());
		//c.setCompanyId(companyrepo.findByCompanyName(employee.getCompany().getCompanyName()).getCompanyId());
		System.out.println(employee.getDesignation().getDesignation());
		System.out.println(employee.getDesignation().getDesignationId());
		//System.out.println(employee.getCompany().getCompanyId());
		employee =  empRepo.save(employee);
		Iterable<Employee> li = empRepo.findAll();
		m.addAttribute("emp", li);
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
