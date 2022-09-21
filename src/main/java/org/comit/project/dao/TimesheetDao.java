package org.comit.project.dao;

import java.util.List;

import org.comit.project.bean.Timesheet;
import org.comit.project.dao.mapper.TimesheetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TimesheetDao {
	List<Timesheet> tim;

	@Autowired
	JdbcTemplate jdbcTemplate;


	public List<Timesheet> listtimesheet(){

		String sql = "SELECT * FROM TIMESHEET";

		return jdbcTemplate.query(sql, new TimesheetMapper());
	}
	public void timesheetEmployee(Timesheet times) {

        String sql = "INSERT TIMESHEET(ID_TIMESHEET,DATEFROM,DATETO,DATESUBMITTED,TIMESHEETcol,ADMIN_ID_ADMIN) " +
                     "VALUES(?,?,?,?,?,?)";

        jdbcTemplate.update(sql,new Object[] {times.getIdtimesheet(), times.getDatefrom(), times.getDateto(), times.getDatesubmitted(),
        		                              times.getHours(), 1});
	}
	public Timesheet findById(String idtimesheet) {

		String sql = "SELECT * FROM TIMESHEET WHERE ID_TIMESHEET = ?";

		List<Timesheet> tim = jdbcTemplate.query(sql, new TimesheetMapper(), idtimesheet);

		return tim.isEmpty()?null:tim.get(0);
	}
}
