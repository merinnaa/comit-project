package org.comit.project.bean;


import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int idEmp;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private Date   birth;
	private String status;
	

	public Employee() {

	}
	public Employee(int idEmp, String firstName, String lastName, String username, String password, Date birth,
			String status) {
		super();
		this.idEmp = idEmp;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.birth = birth;
		this.status = status;
	}

	public int getIdEmp() {
		return idEmp;
	}
	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object obj) {
	if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (idEmp != other.idEmp)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Emp [idEmp=" + idEmp + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", birth=" + birth + ", status=" + status + "]";
	}
	
}
