package com.ulfric.palpatine.expiry;

public enum BooleanExpiries implements Expiry {

	ALWAYS_EXPIRED(true),
	NEVER_EXPIRES(false);

	private final boolean expired;

	BooleanExpiries(boolean expired) {
		this.expired = expired;
	}

	@Override
	public final boolean isExpired() {
		return expired;
	}

}