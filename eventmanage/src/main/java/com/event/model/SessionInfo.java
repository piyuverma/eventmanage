/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.event.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PVerma
 */
@Entity
@Table(name = "session_info")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SessionInfo.findAll", query = "SELECT s FROM SessionInfo s"),
		@NamedQuery(name = "SessionInfo.findBySessionId", query = "SELECT s FROM SessionInfo s WHERE s.sessionId = :sessionId"),
		@NamedQuery(name = "SessionInfo.findBySessionname", query = "SELECT s FROM SessionInfo s WHERE s.sessionname = :sessionname"),
		@NamedQuery(name = "SessionInfo.findByUsersvotes", query = "SELECT s FROM SessionInfo s WHERE s.usersvotes = :usersvotes"),
		@NamedQuery(name = "SessionInfo.findByUsersregistered", query = "SELECT s FROM SessionInfo s WHERE s.usersregistered = :usersregistered"),
		@NamedQuery(name = "SessionInfo.findByEventId", query = "SELECT s FROM SessionInfo s WHERE s.eventInfo.eventId = :eventId") })
public class SessionInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@Column(name = "session_id")
	private Integer sessionId;

	@Column(name = "sessionname")
	private String sessionname;
	
	@Column(name = "usersvotes")
	private Integer usersvotes;
	
	@Column(name = "usersregistered")
	private Integer usersregistered;

	@JoinTable(name = "user_has_session_info", joinColumns = {
			@JoinColumn(name = "session_info_session_id", referencedColumnName = "session_id") }, inverseJoinColumns = {
					@JoinColumn(name = "user_user_id", referencedColumnName = "user_id") })
	@ManyToMany
	private List<User> userList;

	@JoinColumn(name = "duration_id", referencedColumnName = "duration_id")
	@ManyToOne(optional = false)
	
	private DurationInfo durationId;
	@JoinColumn(name = "event_id", referencedColumnName = "event_id")
	@ManyToOne(optional = false)
	
	private EventInfo eventInfo;
	@JoinColumn(name = "level_id", referencedColumnName = "level_id")
	@ManyToOne(optional = false)
	private LevelInfo levelId;

	public SessionInfo() {
	}

	public SessionInfo(Integer sessionId) {
		this.sessionId = sessionId;
	}

	public SessionInfo(int sessionId, int eventId) {
		this.sessionId = sessionId;
		this.eventInfo.setEventId(eventId);
	}

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

	public String getSessionname() {
		return sessionname;
	}

	public void setSessionname(String sessionname) {
		this.sessionname = sessionname;
	}

	public Integer getUsersvotes() {
		return usersvotes;
	}

	public void setUsersvotes(Integer usersvotes) {
		this.usersvotes = usersvotes;
	}

	public Integer getUsersregistered() {
		return usersregistered;
	}

	public void setUsersregistered(Integer usersregistered) {
		this.usersregistered = usersregistered;
	}

	@XmlTransient
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public DurationInfo getDurationId() {
		return durationId;
	}

	public void setDurationId(DurationInfo durationId) {
		this.durationId = durationId;
	}

	public EventInfo getEventInfo() {
		return eventInfo;
	}

	public void setEventInfo(EventInfo eventInfo) {
		this.eventInfo = eventInfo;
	}

	public LevelInfo getLevelId() {
		return levelId;
	}

	public void setLevelId(LevelInfo levelId) {
		this.levelId = levelId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (sessionId != null ? sessionId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SessionInfo)) {
			return false;
		}
		SessionInfo other = (SessionInfo) object;
		if ((this.sessionId == null && other.sessionId != null)
				|| (this.sessionId != null && !this.sessionId.equals(other.sessionId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.event.model.SessionInfo[ sessionId=" + sessionId + " ]";
	}

}
