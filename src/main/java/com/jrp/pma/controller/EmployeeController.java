package com.jrp.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.pma.entity.EmployeeDB;
import com.jrp.pma.repository.IEmployeeRepo;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	IEmployeeRepo employRepo;
	
	
	@GetMapping
	public String displayEmployees(Model model) {
		
		List<EmployeeDB> employees = employRepo.findAll();
		model.addAttribute("employees", employees);
		
		return "/employee/employee-list";
		
	}
	
	@GetMapping("/new")
	public String employeePage(Model model) {
		
		EmployeeDB employeeDB = new EmployeeDB();
		model.addAttribute("employee", employeeDB);
		
		return "/employee/new-employee";
	}
	
	
	@PostMapping("/save")
	public String saveEmployeInDB(Model model, EmployeeDB employeeDB) {
		
		employRepo.save(employeeDB);
		
		return "redirect:/employee/new";
		
	}
	
	

}//Class
