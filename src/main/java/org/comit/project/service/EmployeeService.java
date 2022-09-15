package org.comit.project.service;

import java.util.List;

import org.comit.project.bean.Employee;
import org.comit.project.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao empDao;

	public List<Employee> listEmployee(){

		List<Employee> em = empDao.listEmployee();

		em.forEach(System.out::println);

		em.removeIf(emp-> !"A".equals(emp.getStatus()));

		return em;
	}

	public Employee findEmployee(int idEmp) {

		return empDao.findEmployee(idEmp);
	}

	public void createEmployee(Employee emp) {

		this.validateEmployee(emp);
		emp.setStatus("A");
        empDao.createEmployee(emp);
	}

    public void modifyEmployee(Employee emp) {

    	this.validateEmployee(emp);
        empDao.modifyEmployee(emp);
    }

    public void deleteEmployee(int idEmp) {

    	empDao.deleteEmployee(idEmp);
    }

    public void validateEmployee(Employee emp) {

    	if (emp.getFirstName().isEmpty() ||
    		emp.getLastName().isEmpty() ||
    		emp.getUsername().isEmpty()) {
    		throw new RuntimeException("Invalid Employee Data " + emp);
    	}
    }
}
