package com.event.service;

import java.util.List;
import java.util.Map;

import com.event.dto.EventInfoDto;
import com.event.dto.SessionInfoDto;
import com.event.exception.CommonException;
import com.event.model.WebRequest;

public interface EventService {

	public Map<EventInfoDto, List<SessionInfoDto>> getAllEvents() throws CommonException;
	
	public String addEvent(WebRequest webRequest) throws CommonException;
	
	public String removeEvent(WebRequest webRequest) throws CommonException;
}
