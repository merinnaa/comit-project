package org.comit.project.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.comit.project.bean.Employee;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

		Employee emp = new Employee();

		emp.setIdUser(rs.getInt("emp_id"));
		emp.setFirstName(rs.getString("FIRSTNAME"));
		emp.setLastName(rs.getString("LASTNAME"));
		emp.setUsername(rs.getString("USERNAME"));
		emp.setPassword(rs.getString("PASSWORD"));
		emp.setBirth(rs.getDate("BIRTH"));
		emp.setStatus(rs.getString("STATUS"));

		return emp;
	}

}
