package org.comit.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.comit.project.bean.Employee;
import org.comit.project.bean.Timesheet;
import org.comit.project.service.TimesheetService;
import org.comit.project.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String timesheetEmployee(HttpServletRequest request ) {
		System.out.println("Create timesheet");
		
	String idtimesheet = request.getParameter("idtimesheet");
	String datefrom = request.getParameter("dateFrom");
		String dateto = request.getParameter("dateTo");
	String datesubmitted = request.getParameter("dateSubmitted");
		String hours = request.getParameter("hours");
		

     Timesheet times = new Timesheet(Util.parseDate(datefrom), Util.parseDate(dateto), Util.parseDate(datesubmitted), Integer.parseInt(hours));

        this.timesService.timesheetEmployee(times);

		return "timesheet";
	}

	//@GetMapping("/payroll/{idtimesheet}")
	@GetMapping("/payroll")
	
	public ModelAndView showPayroll(@PathVariable("idtimesheet") int idtimesheet) {

	System.out.println("Show Payroll");

	List<Timesheet> times = this.timesService.listtimesheet(); //this.timesService.findtimesheet(idtimesheet);

		return new ModelAndView("payroll","times", times);
	}

	@PostMapping("/payroll")
	public String payrolltimesheet(HttpServletRequest request,Model model) {
		System.out.println("Update Employee");
		String idtimesheet = request.getParameter("idtimesheet");
//		String datefrom = request.getParameter("datefrom");
//		String dateto = request.getParameter("dateto");
//		String datesubmitted = request.getParameter("datesubmitted");
//		String hours = request.getParameter("hours");
//		String salary = request.getParameter("salary");
		

		Timesheet times = timesService.findtimesheet(idtimesheet); //this.timesheetEmployee( datefrom, dateto, datesubmitted, hours, salary);

		model.addAttribute("timeShet",times);
		
		int slary=15*times.getHours() ;
		model.addAttribute("salary",slary);
		
		//this.timesService.modifytimesheet(times);

		return "redirect:/payroll";
	}

//	private Timesheet timesheetEmployee(String datefrom, String dateto, String datesubmitted, String hours) {
//		Timesheet times = new Timesheet(Util.parseId(datefrom),Util.parseId(dateto),Util.parseId(datesubmitted),hours.trim(),salary.trim(), "");
//		return times;
//	}
}

//	private timesheet timesheetEmployee(String idtimesheet, String datefrom, String dateto, String datesubmitted, String hours) {
