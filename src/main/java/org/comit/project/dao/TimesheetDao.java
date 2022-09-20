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

		String sql = "SELECT * FROM TIMESHEET";

		return jdbcTemplate.query(sql, new TimesheetMapper());
	}
	public void timesheetEmployee(timesheet times) {

        String sql = "INSERT TIMESHEET(ID_TIMESHEET,DATEFROM,DATETO,DATESUBMITTED,HOURS) " +
                     "VALUES(?,?,?,?,?)";

        jdbcTemplate.update(sql,new Object[] {times.getIdtimesheet(), times.getDatefrom(), times.getDateto(), times.getDatesubmitted(),
        		                              times.getHours()});
	}
	public timesheet findById(String idtimesheet) {

		String sql = "SELECT * FROM TIMESHEET WHERE ID_TIMESHEET = ?";

		List<timesheet> tim = jdbcTemplate.query(sql, new TimesheetMapper(), idtimesheet);

		return tim.isEmpty()?null:tim.get(0);
	}
}
