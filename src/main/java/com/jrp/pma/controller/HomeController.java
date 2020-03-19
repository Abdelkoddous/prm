package com.jrp.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jrp.pma.entity.EmployeeDB;
import com.jrp.pma.entity.ProjectDB;
import com.jrp.pma.repository.IEmployeeRepo;
import com.jrp.pma.repository.IProjectRepository;

@Controller
public class HomeController {

	@Autowired
	IProjectRepository proRepo;
	@Autowired
	IEmployeeRepo empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		
		List<ProjectDB> allProjects = proRepo.findAll();
		model.addAttribute("projects", allProjects);
		
		List<EmployeeDB> allEmployees = empRepo.findAll();
		model.addAttribute("employees", allEmployees);
		
		return "/main/home";
	}
	
}
