package org.comit.project.bean;


import java.util.Date;

public class timesheet {
int idtimesheet;
public int getIdtimesheet() {
	return idtimesheet;
}
public void setIdtimesheet(int idtimesheet) {
	this.idtimesheet = idtimesheet;
}
Date   datefrom;
	Date   dateto;
	Date   datesubmitted;
	int hours;
	double tax;
	double salary;
	double sal;
	public timesheet(int i, Date date, Date date2, Date date3, String string, String string2) {

	}
	public timesheet() {
		// TODO Auto-generated constructor stub
	}
	public Date getDatefrom() {
		return datefrom;
	}
	public void setDatefrom(Date datefrom) {
		this.datefrom = datefrom;
	}
	public Date getDateto() {
		return dateto;
	}
	public void setDateto(Date dateto) {
		this.dateto = dateto;
	}
	public Date getDatesubmitted() {
		return datesubmitted;
	}
	public void setDatesubmitted(Date datesubmitted) {
		this.datesubmitted = datesubmitted;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		timesheet other = (timesheet) obj;
		if (idtimesheet != other.idtimesheet)
			return false;
		return true;
	}

public double gettax() {
	if (salary > 10000)
	{
		tax = salary * 10/100;
	}
	else if (salary  > 5000)
	{
		tax = salary * 5/100;
	}
	else
	{
		tax = 0;
	}
	return tax;
}
public double getsalary() {
	sal = salary - tax;
	return sal;
}
public double getTax() {
	return tax;
}
public void setTax(double tax) {
	this.tax = tax;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public double getSal() {
	return sal;
}
public void setSal(double sal) {
	this.sal = sal;
}
}

	/*@Override
	public String toString() {
		return "timesheet [idtimesheet=" + idtimesheet + ", datefrom=" + datefrom + ", dateto=" + dateto + ", datesubmitted="
				+ datesubmitted + ", hours=" + hours + "]";
	}
}*/
