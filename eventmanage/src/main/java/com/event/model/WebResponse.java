package com.event.model;

import java.util.List;
import java.util.Map;

import com.event.dto.EventInfoDto;
import com.event.dto.SessionInfoDto;
import com.event.dto.UserDto;

public class WebResponse {

	private Map<EventInfoDto, List<SessionInfoDto>> eventMap;

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

	/**
	 * @return the eventMap
	 */
	public Map<EventInfoDto, List<SessionInfoDto>> getEventMap() {
		return eventMap;
	}

	/**
	 * @param eventMap
	 *            the eventMap to set
	 */
	public void setEventMap(Map<EventInfoDto, List<SessionInfoDto>> eventMap) {
		this.eventMap = eventMap;
	}

}
