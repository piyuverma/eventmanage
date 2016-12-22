package com.event.dao;

import java.util.List;

import com.event.exception.CommonException;
import com.event.model.SessionInfo;

public interface SessionDao {

	public List<SessionInfo> getAllSessions(Integer eventId) throws CommonException;

	public String addSession(SessionInfo sessionInfo) throws CommonException;

	public String removeSession(SessionInfo sessionInfo) throws CommonException;

	public SessionInfo getSessionByName(String sessionname) throws CommonException;

}
