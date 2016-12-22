package com.event.dao;

import java.util.List;

import com.event.exception.CommonException;
import com.event.model.EventInfo;

public interface EventDao {
	
	public List<EventInfo> getAllEvents() throws CommonException;

	public String addEvent(EventInfo eventInfo) throws CommonException;

	public EventInfo getEventByName(EventInfo eventInfo) throws CommonException;

	public String removeEvent(EventInfo eventInfo) throws CommonException;
}
