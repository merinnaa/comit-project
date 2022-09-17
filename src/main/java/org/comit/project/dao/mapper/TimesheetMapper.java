package org.comit.project.dao.mapper;

	import java.sql.ResultSet;
	import java.sql.SQLException;

	import org.comit.project.bean.timesheet;
import org.springframework.jdbc.core.RowMapper;

public class TimesheetMapper implements RowMapper<timesheet>{
	

		@Override
		public timesheet mapRow(ResultSet rs, int rowNum) throws SQLException {

			timesheet times = new timesheet();

			times.setIdtimesheet(rs.getInt("timesheetId"));
			times.setDatefrom(rs.getDate("DATEFROM"));
			times.setDateto(rs.getDate("DATETO"));
			times.setDatesubmitted(rs.getDate("Datesubmitted"));
			times.setHours(rs.getInt("HOURS"));

			return times;
		}

	}

