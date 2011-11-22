package de.gzockoll.common.types;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.text.ParseException;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

public class ZeitraumTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testContains() throws ParseException {
        DateTime start = TimeFactory.parseDateTime("1.1.2009 00:00");
        DateTime ende = TimeFactory.parseDateTime("1.1.2010 00:00");
        TimeSpan z = new TimeSpan(start, ende);
        assertThat(z.contains(TimeFactory.parseDate("1.5.2009")), is(true));
        assertThat(z.contains(TimeFactory.parseDate("1.5.2008")), is(false));
        assertThat(z.contains(TimeFactory.parseDate("1.5.2010")), is(false));
        assertThat(z.contains(start), is(true));
        assertThat(z.contains(ende), is(false));
        assertThat(z.contains(TimeFactory.parseDateTime("1.1.2010 00:00")), is(false));
    }

    @Test
    public void testSchneidet() throws ParseException {
        DateTime start1 = TimeFactory.parseDateTime("1.1.2009 00:00");
        DateTime ende1 = TimeFactory.parseDateTime("31.12.2009 23:59");
        TimeSpan z1 = new TimeSpan(start1, ende1);
        assertThat(z1.schneidet(z1), is(true));

        DateTime start2 = TimeFactory.parseDateTime("1.5.2009 00:00");
        DateTime ende2 = TimeFactory.parseDateTime("1.1.2010 23:59");
        TimeSpan z2 = new TimeSpan(start2, ende2);
        assertThat(z1.schneidet(z2), is(true));

        DateTime start3 = TimeFactory.parseDateTime("1.1.2010 00:00");
        DateTime ende3 = TimeFactory.parseDateTime("31.12.2010 23:59");
        TimeSpan z3 = new TimeSpan(start3, ende3);
        assertThat(z1.schneidet(z3), is(false));
    }

}
