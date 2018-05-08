package com.v2Technologies.project_management_system.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.v2Technologies.project_management_system.Repository.TaskRepository;
import com.v2Technologies.project_management_system.entity.Employee;
import com.v2Technologies.project_management_system.entity.Task;



@Controller  
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskRepository taskrepo;
	
	
	@GetMapping("/viewTask")
	public String showAllTask(Model m ,HttpSession s)
	{
		Employee e = (Employee) s.getAttribute("employee");
		Iterable<Task> findAll = null;
		if(e!=null)
		{
			 findAll = taskrepo.findAll();
			 m.addAttribute("tasks", findAll);
		}
		return "task/allTask";
	}

}
