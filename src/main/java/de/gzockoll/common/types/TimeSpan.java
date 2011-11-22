package de.gzockoll.common.types;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Interval;

public class TimeSpan {
    public static TimeSpan forever() {
        return new TimeSpan(Timepoint.PAST, null);
    }

    public static TimeSpan nowAndForever() {
        return new TimeSpan(TimeFactory.now(), null);
    }

    private Interval interval;

    public TimeSpan(Date start) {
        super();
        this.interval = new Interval(new Timepoint(start));
    }

    public TimeSpan(Date start, Date ende) {
        super();
        this.interval = new Interval(new DateTime(start), new DateTime(ende));
    }

    public TimeSpan(DateTime start, DateTime ende) {
        super();
        this.interval = new Interval(start, ende);
    }

    private TimeSpan(Timepoint start, Timepoint ende) {
        super();
        this.interval = new Interval(start.getTimeDate(), ende.getTimeDate());
    }

    public boolean contains(DateTime dateTime) {
        return interval.contains(dateTime);
    }

    public Date getEnde() {
        return interval.getEnd().toDate();
    }

    public Date getStart() {
        return interval.getStart().toDate();
    }

    public boolean schneidet(TimeSpan other) {
        return interval.overlaps(other.interval);
    }

    public void setEnde(Date ende) {
        this.interval = new Interval(interval.getStart(), new DateTime(ende));
    }
}
