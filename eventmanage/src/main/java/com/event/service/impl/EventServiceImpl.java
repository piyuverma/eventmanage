package com.event.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.event.dao.EventDao;
import com.event.dao.LocationDao;
import com.event.dto.EventInfoDto;
import com.event.dto.SessionInfoDto;
import com.event.exception.CommonException;
import com.event.model.EventInfo;
import com.event.model.Location;
import com.event.model.WebRequest;
import com.event.service.EventService;
import com.event.service.SessionService;
import com.event.transformation.utils.CommonCodes;
import com.event.transformation.utils.DtoToModel;
import com.event.transformation.utils.ModelToDto;

@Service("EventServiceImpl")
@EnableAsync
@Transactional(propagation=Propagation.REQUIRED)
public class EventServiceImpl implements EventService {

	@PersistenceContext
	private EntityManager emManager;

	@Autowired
	private EventDao eventDao;

	@Autowired
	private LocationDao locationDao;

	@Autowired
	private SessionService sessionService;

	public Map<EventInfoDto, List<SessionInfoDto>> getAllEvents() throws CommonException {

		Map<EventInfoDto, List<SessionInfoDto>> eventMap = new HashMap<EventInfoDto, List<SessionInfoDto>>();
		List<EventInfo> events = eventDao.getAllEvents();
		List<EventInfoDto> eventsDto = new ArrayList<EventInfoDto>();
		for (EventInfo eventInfo : events) {
			eventsDto.add(ModelToDto.getEventDto(eventInfo));
		}
		for (EventInfoDto eventInfoDto : eventsDto) {
			WebRequest webRequest = new WebRequest();
			webRequest.setEvent(eventInfoDto);
			List<SessionInfoDto> eventSessions = sessionService.getEventSessions(webRequest);
			eventMap.put(eventInfoDto, eventSessions);

		}
		return eventMap;
	}

	public String addEvent(WebRequest webRequest) throws CommonException {

		EventInfo eventInfo = DtoToModel.getEventModel(webRequest.getEvent());
		EventInfo evenInfoFromDB = eventDao.getEventByName(eventInfo);
		if (null != evenInfoFromDB) {
			throw new CommonException("Event Already Exists with the name: " + eventInfo.getEventname());
		}

		Location location = DtoToModel.getLocationModel(webRequest.getEvent().getLocationDto());
		Location locationFromDB = locationDao.getLocationByAddressCityProvince(location);
		if (locationFromDB == null) {
			locationDao.addLocation(location);
			locationFromDB = locationDao.getLocationByAddressCityProvince(location);
		}
		location.setLocationId(locationFromDB.getLocationId());
		eventInfo.setLocationId(location);
		eventDao.addEvent(eventInfo);
		sessionService.addSession(webRequest);

		return CommonCodes.SUCCESS;
	}

	public String removeEvent(WebRequest webRequest) throws CommonException {

		EventInfo eventInfo = DtoToModel.getEventModel(webRequest.getEvent());
		EventInfo eventInfoFromDB = eventDao.getEventByName(eventInfo);
		if (null != eventInfoFromDB) {
			eventDao.removeEvent(eventInfoFromDB);
		} else {
			throw new CommonException("Event does not exist with the name : " + eventInfo.getEventname());
		}
		return CommonCodes.SUCCESS;

	}

}
