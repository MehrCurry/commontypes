package de.gzockoll.common.types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TemporalCollection<T> {
	private Map<Date,T> contents = new HashMap<Date,T>();

	public T get(Date when) {
		/** returns the value that was effective on the given date */
		for(Date thisDate:contents.keySet()) {
			if (thisDate.before(when) || thisDate.equals(when))
				return contents.get(thisDate);
		}
		throw new IllegalArgumentException("no records that early");
	}

	public void put(Date at, T item) {
		/** the item is valid from the supplied date onwards */
		contents.put(at, item);
	}
}