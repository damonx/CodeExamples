package javaoopexample.immutable;

import java.util.Date;

public final class Schedule {
	private final Date start;
	private final Date end;

	public Schedule(Date start, Date end) {
		if (start.compareTo(end) > 0)
			throw new IllegalArgumentException(start + " after " + end);
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
	}

	public Date getStart() {
		return (Date)start.clone();
	}

	public Date getEnd() {
		return (Date)end.clone();
	}
	
	

}
