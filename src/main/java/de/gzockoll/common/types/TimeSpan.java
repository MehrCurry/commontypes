package de.gzockoll.common.types;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Interval;

public class TimeSpan {
	private Interval interval;
	public TimeSpan(Date start, Date ende) {
		super();
		this.interval=new Interval(new DateTime(start),new DateTime(ende));
	}

	private TimeSpan(Timepoint start, Timepoint ende) {
		super();
		this.interval=new Interval(start.getTimeDate(),ende.getTimeDate());
	}

	public TimeSpan(Date start) {
		super();
		this.interval = new Interval(new Timepoint(start));
	}
	
	
	public Date getEnde() {
		return interval.getEnd().toDate();
	}

	public void setEnde(Date ende) {
		this.interval=new Interval(interval.getStart(),new DateTime(ende));
	}

	public Date getStart() {
		return interval.getStart().toDate();
	}

	public boolean contains(Date date) {
		return interval.contains(new DateTime(date));
	}
	
	public boolean schneidet(TimeSpan other) {
		return interval.overlaps(other.interval);
	}

	public static TimeSpan nowAndForever() {
		return new TimeSpan(TimeFactory.now(),null);
	}

	public static TimeSpan forever() {
		return new TimeSpan(Timepoint.PAST,null);
	}
}
