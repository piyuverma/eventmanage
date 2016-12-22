package com.event.service;

import java.util.List;

import com.event.dto.SessionInfoDto;
import com.event.exception.CommonException;
import com.event.model.WebRequest;

public interface SessionService {

	public List<SessionInfoDto> getEventSessions(WebRequest webRequest) throws CommonException;

	public String addSession(WebRequest webRequest) throws CommonException;

	public String removeSession(WebRequest webRequest);

	public String updateSession(WebRequest webRequest);

}
