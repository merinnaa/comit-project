package org.comit.project.service;

import org.comit.project.bean.timesheet;
import org.comit.project.dao.TimesheetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TimesheetService {
	@Autowired
	TimesheetDao timesDao;

	public void timesheetEmployee(timesheet times) {

			this.validateEmployee(times);
	        timesDao.timesheetEmployee(times);
		}

	private void validateEmployee(timesheet times) {
		/*if ((times.getDatefrom().isEmpty() ||
	    		times.getDateto().isEmpty ||
	    		times.getDatesubmitted().isEmpty())
	    		throw new RuntimeException("Invalid Employee Data " + times);*/
		
	}
	public void payroll() {
		
	}
	}
	


