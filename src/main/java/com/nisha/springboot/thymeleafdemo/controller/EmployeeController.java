package com.nisha.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nisha.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	 // load employee data
	
	private List<Employee> employeeList;
	
	@PostConstruct
	private void loadData() {
		// create employees
		Employee emp1 = new Employee(1, "Nisha", "Garg", "nisha.garg@wolterskluwer.com");
		Employee emp2 = new Employee(1, "Manisha", "Garg", "manisha.garg@wolterskluwer.com");
		Employee emp3 = new Employee(1, "Komal", "Garg", "komal.garg@wolterskluwer.com");
		// create the list
		employeeList = new ArrayList();
		// add to the list
		employeeList.add(emp1);
		employeeList.add(emp2);
		employeeList.add(emp3);	
	}
	// add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model model) {
		model.addAttribute("employees",employeeList);
		return "list-employees";
	}
}
