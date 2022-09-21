package org.comit.project.dao.mapper;

	import java.sql.ResultSet;
	import java.sql.SQLException;

	import org.comit.project.bean.Timesheet;
import org.springframework.jdbc.core.RowMapper;

public class TimesheetMapper implements RowMapper<Timesheet>{
	

		@Override
		public Timesheet mapRow(ResultSet rs, int rowNum) throws SQLException {

			Timesheet times = new Timesheet();

			times.setIdtimesheet(rs.getInt("idtimesheet"));
			times.setDatefrom(rs.getDate("datefrom"));
			times.setDateto(rs.getDate("dateto"));
			times.setDatesubmitted(rs.getDate("datesubmitted"));
			times.setHours(rs.getInt("hours"));

			return times;
		}

	}

