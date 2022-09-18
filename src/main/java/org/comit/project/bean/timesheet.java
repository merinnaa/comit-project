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
}

	/*@Override
	public String toString() {
		return "timesheet [idtimesheet=" + idtimesheet + ", datefrom=" + datefrom + ", dateto=" + dateto + ", datesubmitted="
				+ datesubmitted + ", hours=" + hours + "]";
	}
}*/
