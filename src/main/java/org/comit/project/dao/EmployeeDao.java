package org.comit.project.dao;

import java.util.List;

import org.comit.project.bean.Employee;
import org.comit.project.bean.timesheet;
import org.comit.project.dao.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

	List<Employee> em;

	@Autowired
	JdbcTemplate jdbcTemplate;


	public List<Employee> listEmployee(){

		String sql = "SELECT * FROM EMPLOYEE";

		return jdbcTemplate.query(sql, new EmployeeMapper());
	}

	public Employee findEmployee(int idEmp) {

		String sql = "SELECT * FROM Employee WHERE EMP_ID = ?";

		return jdbcTemplate.queryForObject(sql, new EmployeeMapper(), idEmp);
	}

	public Employee findByUsername(String username) {

		String sql = "SELECT * FROM Employee WHERE USER_NAME = ?";

		List<Employee> em = jdbcTemplate.query(sql, new EmployeeMapper(), username);

		return em.isEmpty()?null:em.get(0);
	}

	public void createEmployee(Employee emp) {

        String sql = "INSERT Employee(EMP_ID,FIRST_NAME,LAST_NAME,USER_NAME,PASSWORD,BIRTH,STATUS) " +
                     "VALUES(?,?,?,?,?,?)";

        jdbcTemplate.update(sql,new Object[] {emp.getUsername(), emp.getPassword(), emp.getFirstName(),
        		                              emp.getLastName(), emp.getBirth(), emp.getStatus()});
	}
	
    public void modifyEmployee(Employee emp) {

        String sql = "UPDATE Employee SET EMP_ID = ?, FIRST_NAME = ?, LAST_NAME = ?, USER_NAME = ?, BIRTH = ? " +
                     "WHERE emp_id = ?";

        jdbcTemplate.update(sql,new Object[] {emp.getIdEmp(), emp.getFirstName(), emp.getLastName(), emp.getUsername(), 
                 emp.getBirth(), emp.getIdEmp()});
    }

    public void deleteEmployee(int idEmp) {

		String sql = "DELETE FROM Employee WHERE emp_id = ?";

        jdbcTemplate.update(sql,new Object[] {idEmp});
    }

	public void timesheetEmployee(timesheet emp) {
		// TODO Auto-generated method stub
		
	}



}
