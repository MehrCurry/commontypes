package de.gzockoll.common.types;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.joda.time.DateTime;

public class TimeFactory {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");

    public static DateTime now() {
        return new DateTime().now();
    }

    public static DateTime parse(String string) {
        return DateTime.parse(string);
    }

    public static DateTime parseDate(String string) throws ParseException {
        return new DateTime(dateFormat.parse(string));
    }

    public static DateTime parseDateTime(String string) throws ParseException {
        return new DateTime(dateTimeFormat.parse(string));
    }
}
