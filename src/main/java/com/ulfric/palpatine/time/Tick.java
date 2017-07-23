package com.ulfric.palpatine.time;

import java.time.Duration;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;

public enum Tick implements TemporalUnit {

	INSTANCE;

	private final Duration duration = Duration.ofMillis(50); // TODO better way to convert millis to ticks, also this doesn't account for possible changes in server default tickrate

	@Override
	public long between(Temporal inclusive, Temporal exclusive) {
		return inclusive.until(exclusive, this);
	}

	@Override
	public Duration getDuration() {
		return duration;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <R extends Temporal> R addTo(R temporal, long amount) {
		return (R) temporal.plus(amount, this);
	}

	@Override
	public boolean isDateBased() {
		return false;
	}

	@Override
	public boolean isDurationEstimated() {
		return false;
	}

	@Override
	public boolean isTimeBased() {
		return true;
	}

}
