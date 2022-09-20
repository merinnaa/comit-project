
package org.comit.project.service;

import java.util.List;

import org.comit.project.bean.Employee;
import org.comit.project.bean.timesheet;
import org.comit.project.dao.TimesheetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimesheetService {

	@Autowired
	TimesheetDao timesDao;

	public List<timesheet> listtimesheet(){

		List<timesheet> tim = timesDao.listtimesheet();

		tim.forEach(System.out::println);

//		tim.removeIf(times-> !"A".equals(times.getStatus()));

		return tim;
	}

	public void timesheetEmployee(timesheet times) {

		//this.validatetimesheet(times);
		//times.setStatus("A");
        timesDao.timesheetEmployee(times);
	}

	public Employee findtimesheet(int id) {
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


