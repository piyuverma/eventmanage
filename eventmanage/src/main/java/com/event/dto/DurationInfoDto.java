package com.event.dto;

import java.io.Serializable;

public class DurationInfoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer durationId;
	private Integer duration;

	/**
	 * @return the durationId
	 */
	public Integer getDurationId() {
		return durationId;
	}

	/**
	 * @param durationId
	 *            the durationId to set
	 */
	public void setDurationId(Integer durationId) {
		this.durationId = durationId;
	}

	/**
	 * @return the duration
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Override
	public int hashCode() {
		return this.getDurationId();

	}

	@Override
	public boolean equals(Object obj) {
		if (this.getDurationId() == ((DurationInfoDto) obj).getDurationId())
			return true;
		else
			return false;
	}

}
