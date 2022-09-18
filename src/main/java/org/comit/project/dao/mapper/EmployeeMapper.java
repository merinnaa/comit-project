package org.comit.project.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.comit.project.bean.Employee;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

		Employee emp = new Employee();

		emp.setIdEmp(rs.getInt("EMP_ID"));
		emp.setFirstName(rs.getString("FIRST_NAME"));
		emp.setLastName(rs.getString("LAST_NAME"));
		emp.setUsername(rs.getString("USER_NAME"));
		emp.setPassword(rs.getString("PASSWORD"));
		emp.setBirth(rs.getDate("BIRTH"));
		emp.setStatus(rs.getString("STATUS"));

		return emp;
	}

}
