package com.jrp.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.pma.entity.ProjectDB;
import com.jrp.pma.repository.IProjectRepository;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	IProjectRepository proRepo;
	
	
	@GetMapping
	public String displayProjects(Model model) {
		
		List<ProjectDB> projects = proRepo.findAll();
		model.addAttribute("projects", projects);
		
		return "/project/project-list";
		
	}
	
	@GetMapping("/new")
	public String projectPage(Model model) {
		
		ProjectDB aProjectDB = new ProjectDB();
		
		model.addAttribute("project", aProjectDB);
		
		return "/project/new-project";
	}
	
	@PostMapping("/save")
	public String saveProjectInDB(ProjectDB projectDB, Model model) {
		
		proRepo.save(projectDB);
		
		return "redirect:/project/new";
	}
	
	
}//Class
