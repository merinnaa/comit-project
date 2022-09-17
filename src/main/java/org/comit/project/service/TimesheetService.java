package org.comit.project.service;

import org.comit.project.bean.timesheet;

public class TimesheetService {

	public void timesheetEmployee(timesheet times) {

			this.validateEmployee(times);
	        timesDao.timesheetEmployee(times);
		}

	private void validateEmployee(timesheet times) {
		// TODO Auto-generated method stub
		
	}	
	}


