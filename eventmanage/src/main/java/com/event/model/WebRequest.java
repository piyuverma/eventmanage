package com.event.model;

import java.util.List;

import com.event.dto.EventInfoDto;
import com.event.dto.SessionInfoDto;
import com.event.dto.UserDto;

public class WebRequest {

	private EventInfoDto event;
	private List<UserDto> users;
	private List<SessionInfoDto> sessions;

	/**
	 * @return the sessions
	 */
	public List<SessionInfoDto> getSessions() {
		return sessions;
	}

	/**
	 * @param sessions
	 *            the sessions to set
	 */
	public void setSessions(List<SessionInfoDto> sessions) {
		this.sessions = sessions;
	}

	/**
	 * @return the event
	 */
	public EventInfoDto getEvent() {
		return event;
	}

	/**
	 * @param event
	 *            the event to set
	 */
	public void setEvent(EventInfoDto event) {
		this.event = event;
	}

	/**
	 * @return the users
	 */
	public List<UserDto> getUsers() {
		return users;
	}

	/**
	 * @param users
	 *            the users to set
	 */
	public void setUsers(List<UserDto> users) {
		this.users = users;
	}

}
