package org.comit.project.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.comit.project.bean.Employee;
import org.comit.project.bean.timesheet;
import org.comit.project.service.EmployeeService;
import org.comit.project.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@GetMapping({"/","/index"})
	public String index() {
		System.out.println("Show Index Page");

		return "index";
	}

	@GetMapping("/list")
	@ResponseBody
	public List<Employee> listEmployees() {
		System.out.println("List employee");

		List<Employee> em = this.empService.listEmployee();
		List<Employee> listemployee=new ArrayList <>();
		Employee emp1 = new Employee();
		emp1.setFirstName("lwam");
		listemployee.add(emp1);
		
		//List<Employee> em = listemployee;
		//return new ModelAndView("list","Employee", em);
		return em;
	}

	@GetMapping("/create")
	public String showCreate() {
		System.out.println("Show Create");

		return "create";
	}

	@PostMapping("/create")
	public String createEmployee(HttpServletRequest request) {
		System.out.println("Create Employee");

		String first = request.getParameter("first");
		String last = request.getParameter("last");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String birth = request.getParameter("birth");

        Employee emp = this.createEmployee(null,first, last, username, password, birth);

        this.empService.createEmployee(emp);

		return "redirect:/list";
	}
	
	@GetMapping("/update/{id}")
	public ModelAndView showUpdate(@PathVariable("id") int id) {

		System.out.println("Show Update");

		Employee emp = this.empService.findEmployee(id);

		return new ModelAndView("update","employee",emp);
	}

	@PostMapping("/update")
	public String updateEmployee(HttpServletRequest request) {
		System.out.println("Update Employee");

		String id = request.getParameter("id");
		String first = request.getParameter("first");
		String last = request.getParameter("last");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String birth = request.getParameter("birth");

		Employee emp = this.createEmployee(id,first, last, username, password, birth);

		this.empService.modifyEmployee(emp);

		return "redirect:/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		System.out.println("Delete User");

		this.empService.deleteEmployee(id);

		return "redirect:/list";
	}

	private Employee createEmployee(String id, String first, String last, String username, String password, String birth) {

		Employee emp = new Employee(Util.parseId(id),first.trim(),last.trim(),username.trim(),password,Util.parseDate(birth),"");

		return emp;
	}

}