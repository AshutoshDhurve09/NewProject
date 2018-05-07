package com.v2Technologies.project_management_system.Repository;

import org.springframework.data.repository.CrudRepository;

import com.v2Technologies.project_management_system.entity.GeneralAdmin;

public interface GeneralAdminRepo extends CrudRepository<GeneralAdmin,java.lang.String>
{	
	GeneralAdmin findByAdminNameAndPassword(String adminName, String password);

}
