package de.gzockoll.common.types;

import java.util.Date;

import org.joda.time.DateTime;

public class Timepoint {
	public static final Timepoint PAST = new Timepoint(new Date(0));
	private DateTime dateTime;

	public Timepoint(Date date) {
		super();
		this.dateTime = new DateTime(date);		
	}

	public Timepoint(DateTime date) {
		super();
		this.dateTime = date;
	}

	public Timepoint(int year, int month, int day) {
		this.dateTime=new DateTime(year,month,day,0,0,0,0);
	}

	public Date getDate() {
		return dateTime.toDate();
	}

	public DateTime getTimeDate() {
		return dateTime;
	}
	
	@Override
	public String toString() {
		return dateTime.toString();
	}
}
