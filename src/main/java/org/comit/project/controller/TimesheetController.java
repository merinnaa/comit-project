package org.comit.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.comit.project.bean.timesheet;
import org.comit.project.service.EmployeeService;
import org.comit.project.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class TimesheetController {
	
	

		@Autowired
		TimesheetService timesService;

		@GetMapping({"/","/index"})
		public String index() {
			System.out.println("Show Index Page");

			return "index";
		}
	@GetMapping("/timeshhet")
	public String showTimesheet() {
		System.out.println("Show Timeshhet");

		return "timesheet";
	}

	@PostMapping("/timesheet")
	public String timesheetEmployee(HttpServletRequest request) {
		System.out.println("Create timesheet");

		String datefrom = request.getParameter("datefrom");
		String dateto = request.getParameter("dateto");
		String datesubmitted = request.getParameter("datesubmitted");
		String hours = request.getParameter("hours");
		

        timesheet times = this.timesheetEmployee(null,datefrom, dateto, datesubmitted, hours);

        this.timesService.timesheetEmployee(times);

		return "redirect:/list";
	}

}
