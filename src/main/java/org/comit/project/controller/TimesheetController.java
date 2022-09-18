package org.comit.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.comit.project.bean.timesheet;
import org.comit.project.service.TimesheetService;
import org.comit.project.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class TimesheetController {
	
	

		@Autowired
		TimesheetService timesService;

		
	@GetMapping("/timeshhet")
	public String showTimesheet() {
		System.out.println("Show Timeshhet");

		return "timesheet";
	}

	@PostMapping("/timesheet")
	public String timesheetEmployee(HttpServletRequest request) {
		System.out.println("Create timesheet");
		
		String id = request.getParameter("idtimesheet");
		String datefrom = request.getParameter("datefrom");
		String dateto = request.getParameter("dateto");
		String datesubmitted = request.getParameter("datesubmitted");
		String hours = request.getParameter("hours");
		

        timesheet times = this.timesheetEmployee(id, datefrom, dateto, datesubmitted, hours);

        this.timesService.timesheetEmployee(times);

		return "redirect:/timesheet";
	}
	private timesheet timesheetEmployee(String id, String datefrom, String dateto, String datesubmitted, String hours) {
		{

			timesheet times = new timesheet(Util.parseId(id),Util.parseDate(datefrom),Util.parseDate(dateto),Util.parseDate(datesubmitted),hours.trim(),"");

			return times;
	}

	}
}
