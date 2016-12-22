package com.event.dto;

import java.io.Serializable;
import java.util.List;

public class SessionInfoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer sessionId;
	private String sessionname;
	private Integer usersvotes;
	private Integer usersregistered;
	private List<UserDto> userList;
	private DurationInfoDto durationInfoDto;
	private EventInfoDto eventInfoDto;
	private LevelInfoDto levelInfoDto;

	/**
	 * @return the sessionId
	 */
	public Integer getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId
	 *            the sessionId to set
	 */
	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the sessionname
	 */
	public String getSessionname() {
		return sessionname;
	}

	/**
	 * @param sessionname
	 *            the sessionname to set
	 */
	public void setSessionname(String sessionname) {
		this.sessionname = sessionname;
	}

	/**
	 * @return the usersvotes
	 */
	public Integer getUsersvotes() {
		return usersvotes;
	}

	/**
	 * @param usersvotes
	 *            the usersvotes to set
	 */
	public void setUsersvotes(Integer usersvotes) {
		this.usersvotes = usersvotes;
	}

	/**
	 * @return the usersregistered
	 */
	public Integer getUsersregistered() {
		return usersregistered;
	}

	/**
	 * @param usersregistered
	 *            the usersregistered to set
	 */
	public void setUsersregistered(Integer usersregistered) {
		this.usersregistered = usersregistered;
	}

	/**
	 * @return the userList
	 */
	public List<UserDto> getUserList() {
		return userList;
	}

	/**
	 * @param userList
	 *            the userList to set
	 */
	public void setUserList(List<UserDto> userList) {
		this.userList = userList;
	}

	/**
	 * @return the durationInfoDto
	 */
	public DurationInfoDto getDurationInfoDto() {
		return durationInfoDto;
	}

	/**
	 * @param durationInfoDto
	 *            the durationInfoDto to set
	 */
	public void setDurationInfoDto(DurationInfoDto durationInfoDto) {
		this.durationInfoDto = durationInfoDto;
	}

	/**
	 * @return the eventInfoDto
	 */
	public EventInfoDto getEventInfoDto() {
		return eventInfoDto;
	}

	/**
	 * @param eventInfoDto
	 *            the eventInfoDto to set
	 */
	public void setEventInfoDto(EventInfoDto eventInfoDto) {
		this.eventInfoDto = eventInfoDto;
	}

	/**
	 * @return the levelInfoDto
	 */
	public LevelInfoDto getLevelInfoDto() {
		return levelInfoDto;
	}

	/**
	 * @param levelInfoDto
	 *            the levelInfoDto to set
	 */
	public void setLevelInfoDto(LevelInfoDto levelInfoDto) {
		this.levelInfoDto = levelInfoDto;
	}

	@Override
	public int hashCode() {
		return this.getSessionId();

	}

	@Override
	public boolean equals(Object obj) {
		if (this.getSessionId() == ((SessionInfoDto) obj).getSessionId())
			return true;
		else
			return false;
	}

}
