package org.comit.project.dao;

import java.util.List;

import org.comit.project.bean.timesheet;
import org.comit.project.dao.mapper.TimesheetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TimesheetDao {
	List<timesheet> tim;

	@Autowired
	JdbcTemplate jdbcTemplate;


	public List<timesheet> listtimesheet(){

		String sql = "SELECT * FROM Employee";

		return jdbcTemplate.query(sql, new TimesheetMapper());
	}
	public void timesheetEmployee(timesheet times) {

        String sql = "INSERT TIMESHEET(DATEFROM,DATETO,DATESUBMITTED,HOURS) " +
                     "VALUES(?,?,?,?)";

        jdbcTemplate.update(sql,new Object[] {times.getDatefrom(), times.getDateto(), times.getDatesubmitted(),
        		                              times.getHours()});
	}
}
