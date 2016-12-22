package com.event.dto;

import java.io.Serializable;
import java.util.Date;

public class EventInfoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String eventName;
	private Integer eventId;
	private LocationDto locationDto;
	private Date date;

	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @param eventName
	 *            the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * @return the eventId
	 */
	public Integer getEventId() {
		return eventId;
	}

	/**
	 * @param eventId
	 *            the eventId to set
	 */
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return the locationDto
	 */
	public LocationDto getLocationDto() {
		return locationDto;
	}

	/**
	 * @param locationDto
	 *            the locationDto to set
	 */
	public void setLocationDto(LocationDto locationDto) {
		this.locationDto = locationDto;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return this.getEventId();

	}

	@Override
	public boolean equals(Object obj) {
		if (this.getEventId() == ((EventInfoDto) obj).getEventId())
			return true;
		else
			return false;
	}

}
