package org.comit.project.controller;


import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.comit.project.bean.Employee;
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
	@GetMapping({"/employee"})
	public String employee() {
		System.out.println("Show Index Page");

		return "employee";
	}
	@GetMapping({"/admin"})
	public ModelAndView administrator() {
		System.out.println("Show admin Page");
		List<Employee> em = this.empService.listEmployee();
		/*
		 * List<Employee> listemployee=new ArrayList <>(); Employee emp1 = new
		 * Employee(); emp1.setFirstName("lwam"); emp1.setLastName("Yohanes");
		 * emp1.setIdEmp(0); emp1.setBirth(Date.valueOf(LocalDate.now()));
		 * emp1.setPassword("123"); listemployee.add(emp1);
		 */
		

		return new ModelAndView("administrator","emp",em);
	}
//	@GetMapping("/list")
//	@ResponseBody
//	public List<Employee> listEmployees() {
//		System.out.println("List employee");
//
//		//List<Employee> em = this.empService.listEmployee();
//		List<Employee> listemployee=new ArrayList <>();
//		Employee emp1 = new Employee();
//		emp1.setFirstName("lwam");
//		emp1.setLastName("Yohanes");
//		emp1.setIdEmp(0);
//		emp1.setBirth(Date.valueOf(LocalDate.now()));
//		emp1.setPassword("123");
//		listemployee.add(emp1);
//		
//		//List<Employee> em = listemployee;
//		//return new ModelAndView("list","Employee", em);
//		return listemployee;
//	}

	@GetMapping("/create")
	public String showCreate() {
		System.out.println("Show Create");

		return "create";
	}

	@PostMapping("/create")
	public String createEmployee(HttpServletRequest request) {
		System.out.println("Create Employee");
		
		String id = request.getParameter("EMP_ID");
		String first = request.getParameter("FIRST_NAME");
		String last = request.getParameter("LAST_NAME");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String birth = request.getParameter("birth");
		String status = request.getParameter("status");

        Employee emp = this.createEmployee(id, first, last, username, password, birth, status);

        this.empService.createEmployee(emp);

		return "redirect:/admin";
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
		String status = request.getParameter("status");

		Employee emp = this.createEmployee(id, first, last, username, password, birth, status);

		this.empService.modifyEmployee(emp);

		return "redirect:/create";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		System.out.println("Delete User");

		this.empService.deleteEmployee(id);

		return "redirect:/admin";
	}

	private Employee createEmployee(String id, String first, String last, String username, String password, String birth, String status) {

		Employee emp = new Employee(Util.parseId(id),first.trim(),last.trim(),username.trim(),password,Util.parseDate(birth), "");

		return emp;
	}

}