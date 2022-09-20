package org.comit.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.comit.project.bean.Employee;
import org.comit.project.bean.timesheet;
import org.comit.project.service.TimesheetService;
import org.comit.project.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class TimesheetController {
	
	

		@Autowired
		TimesheetService timesService;

		
	@GetMapping("/timesheet")
	public String showTimesheet() {
		System.out.println("Show Timeshhet");

		return "timesheet";
	}

	@PostMapping("/timesheet")
	public String timesheetEmployee(HttpServletRequest request) {
		System.out.println("Create timesheet");
		
		String idtimesheet = request.getParameter("idtimesheet");
		String datefrom = request.getParameter("datefrom");
		String dateto = request.getParameter("dateto");
		String datesubmitted = request.getParameter("datesubmitted");
		String hours = request.getParameter("hours");
		

        timesheet times = this.timesheetEmployee(idtimesheet, datefrom, dateto, datesubmitted, hours);

        this.timesService.timesheetEmployee(times);

		return "timesheet";
	}

	@GetMapping("/payroll/{idtimesheet}")
	public ModelAndView showPayroll(@PathVariable("idtimesheet") int idtimesheet) {

		System.out.println("Show Payroll");

		Employee times = this.timesService.findtimesheet(idtimesheet);

		return new ModelAndView("payroll","times", times);
	}

	@PostMapping("/payroll")
	public String payrolltimesheet(HttpServletRequest request) {
		System.out.println("Update Employee");
		//String idtimesheet = request.getParameter("idtimesheet");
		String datefrom = request.getParameter("datefrom");
		String dateto = request.getParameter("dateto");
		String datesubmitted = request.getParameter("datesubmitted");
		String hours = request.getParameter("hours");
		String salary = request.getParameter("salary");
		

		timesheet times = this.timesheetEmployee( datefrom, dateto, datesubmitted, hours, salary);

		//this.timesService.modifytimesheet(times);

		return "redirect:/payroll";
	}

	private timesheet timesheetEmployee(String datefrom, String dateto, String datesubmitted, String hours,
			String salary) {
		timesheet times = new timesheet(Util.parseId(datefrom),Util.parseId(dateto),Util.parseId(datesubmitted),hours.trim(),salary.trim(), "");
		return null;
	}
}

//	private timesheet timesheetEmployee(String idtimesheet, String datefrom, String dateto, String datesubmitted, String hours) {
