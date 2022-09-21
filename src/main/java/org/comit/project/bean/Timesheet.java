package org.comit.project.bean;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Timesheet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idtimesheet;
	private Date datefrom;
	private Date dateto;
	private Date datesubmitted;
	private int hours;
//double tax;
//double salary = 15 * hours;
//double sal;

	public Timesheet(Date dateFrom, Date dateTo, Date dateSubmitted, int hours) {
		//this.idtimesheet = idtimesheet;
		this.datefrom = dateFrom;
		this.dateto = dateTo;
		this.datesubmitted = dateSubmitted;
		this.hours = hours;
	}

	public Timesheet() {
		// TODO Auto-generated constructor stub
	}

	public long getIdtimesheet() {
		return idtimesheet;
	}

	public void setIdtimesheet(int idtimesheet) {
		this.idtimesheet = idtimesheet;
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
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		timesheet other = (timesheet) obj;
//		if (idtimesheet != other.idtimesheet)
//			return false;
//		return true;
//	}
//
//public double gettax() {
//	if (salary > 10000)
//	{
//		tax = salary * 10/100;
//	}
//	else if (salary  > 5000)
//	{
//		tax = salary * 5/100;
//	}
//	else
//	{
//		tax = 0;
//	}
//	return tax;
//}
//public double getsalary() {
//	sal = salary - tax;
//	return sal;
//}
//public double getTax() {
//	return tax;
//}
//public void setTax(double tax) {
//	this.tax = tax;
//}
//public double getSalary() {
//	return salary;
//}
//public void setSalary(double salary) {
//	this.salary = salary;
//}
//public double getSal() {
//	return sal;
//}
//public void setSal(double sal) {
//	this.sal = sal;
//}

	@Override
	public String toString() {
		return "timesheet [idtimesheet=" + idtimesheet + ", datefrom=" + datefrom + ", dateto=" + dateto
				+ ", datesubmitted=" + datesubmitted + ", hours=" + hours + "]";
	}
}
