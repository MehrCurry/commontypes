package de.gzockoll.common.types;

import java.util.Calendar;
import java.util.Date;

public class Timepoint {
	public static final Timepoint PAST = new Timepoint(new Date(0));
	private Date date;

	public Timepoint(Date date) {
		super();
		this.date = date;
	}

	public Timepoint(int year, int month, int day) {
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR,year);
		cal.set(Calendar.MONTH,month-1);
		cal.set(Calendar.DAY_OF_MONTH,day);
		this.date=cal.getTime();
	}

	public Date getDate() {
		return date;
	}
}
