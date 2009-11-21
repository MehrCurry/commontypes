package de.gzockoll.common.types;

import java.util.Calendar;
import java.util.Date;

public class TimeSpan {
	private Timepoint start;
	private Timepoint ende;
	public TimeSpan(Date start, Date ende) {
		super();
		this.start = new Timepoint(start);
		this.ende = new Timepoint(ende);
	}

	private TimeSpan(Timepoint start, Timepoint ende) {
		super();
		this.start = start;
		this.ende = ende;
	}

	public TimeSpan(Date start) {
		super();
		this.start = new Timepoint(start);
		this.ende = null;
	}
	
	
	public Date getEnde() {
		return ende.getDate();
	}

	public void setEnde(Date ende) {
		this.ende = new Timepoint(ende);
	}

	public Date getStart() {
		return start.getDate();
	}

	public boolean contains(Date now) {
		return (!now.before(start.getDate()) && (!now.after(ende.getDate())));
	}
	
	public boolean schneidet(TimeSpan other) {
		return contains(other.start.getDate()) || contains(other.ende.getDate());
	}

	public static TimeSpan nowAndForever() {
		return new TimeSpan(TimeFactory.now(),null);
	}

	public static TimeSpan forever() {
		return new TimeSpan(Timepoint.PAST,null);
	}
}
