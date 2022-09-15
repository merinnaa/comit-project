package org.comit.project.dao;

import java.util.List;

import org.comit.project.bean.Employee;
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

		String sql = "SELECT * FROM Employee";

		return jdbcTemplate.query(sql, new EmployeeMapper());
	}

	public Employee findEmployee(int idEmp) {

		String sql = "SELECT * FROM Employee WHERE ID_USER = ?";

		return jdbcTemplate.queryForObject(sql, new EmployeeMapper(), idEmp);
	}

	public Employee findByUsername(String username) {

		String sql = "SELECT * FROM Employee WHERE USERNAME = ?";

		List<Employee> em = jdbcTemplate.query(sql, new EmployeeMapper(), username);

		return em.isEmpty()?null:em.get(0);
	}

	public void createEmployee(Employee emp) {

        String sql = "INSERT Employee(USERNAME,PASSWORD,FIRSTNAME,LASTNAME,BIRTH,STATUS) " +
                     "VALUES(?,?,?,?,?,?)";

        jdbcTemplate.update(sql,new Object[] {emp.getUsername(), emp.getPassword(), emp.getFirstName(),
        		                              emp.getLastName(), emp.getBirth(), emp.getStatus()});
	}

    public void modifyEmployee(Employee emp) {

        String sql = "UPDATE Employee SET USERNAME = ?, FIRSTNAME = ?, LASTNAME = ?, BIRTH = ? " +
                     "WHERE emp_id = ?";

        jdbcTemplate.update(sql,new Object[] {emp.getUsername(), emp.getFirstName(),
                emp.getLastName(), emp.getBirth(), emp.getIdUser()});
    }

    public void deleteEmployee(int idEmp) {

		String sql = "DELETE FROM Employee WHERE emp_id = ?";

        jdbcTemplate.update(sql,new Object[] {idEmp});
    }



}
