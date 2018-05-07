package com.v2Technologies.project_management_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.v2Technologies.project_management_system.entity.Company;


public interface CompanyRepository extends JpaRepository<Company,java.lang.Long>
{
	Company findByAdminNameAndPasswordAndCompanyName(String adminName,String password,String companyName);
	
	//Company findByCompanyName(String company);

	//String findByCompanyName(Long companyId);

	//String findByCompanyName(Company company);

	

}
