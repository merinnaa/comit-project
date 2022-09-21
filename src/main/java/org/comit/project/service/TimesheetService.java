
package org.comit.project.service;

import java.util.List;

import org.comit.project.bean.Employee;
import org.comit.project.bean.Timesheet;
import org.comit.project.dao.TimesheetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimesheetService {

	@Autowired
	TimesheetDao timesDao;

	public List<Timesheet> listtimesheet(){

		List<Timesheet> tim = timesDao.listtimesheet();

		tim.forEach(System.out::println);

//		tim.removeIf(times-> !"A".equals(times.getStatus()));

		return tim;
	}

	public void timesheetEmployee(Timesheet timesheet) {

		//this.validatetimesheet(times);
		//times.setStatus("A");
        timesDao.timesheetEmployee(timesheet);
	}

	public Timesheet findtimesheet(String idtimesheet) {
		// TODO Auto-generated method stub
		return null;
	}
}

    /*public void validatetimesheet(timesheet times) {

    	if (times.getDatefrom() ||
    		times.getDateto()||
    		times.getDatesubmitted(). {
    		throw new RuntimeException("Invalid Employee Data " + times);
    	}
    }
}
*/	


