package com.event.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.event.controller.EventController;
import com.event.dto.DurationInfoDto;
import com.event.dto.EventInfoDto;
import com.event.dto.LevelInfoDto;
import com.event.dto.LocationDto;
import com.event.dto.SessionInfoDto;
import com.event.dto.UserDto;
import com.event.model.WebRequest;

class JpaTest {
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-conf/spring.xml");

		EventController eventController = (EventController) ctx.getBean("eventController");

		WebRequest webRequest = new WebRequest();

		EventInfoDto eventInfoDto = new EventInfoDto();
		eventInfoDto.setEventId(2);
		eventInfoDto.setEventName("Angular Boot Camp 2");
		eventInfoDto.setDate(new Date());

		LocationDto locationDto = new LocationDto();
		locationDto.setLocationId(2);
		locationDto.setAddress("Sec-30 Park Centra");
		locationDto.setCity("Gurgaon,Haryana");
		locationDto.setProvince("India");

		eventInfoDto.setLocationDto(locationDto);

		List<SessionInfoDto> sessions = new ArrayList<SessionInfoDto>();

		SessionInfoDto sessionInfoDto = new SessionInfoDto();

		sessionInfoDto.setSessionId(2);
		DurationInfoDto durationInfoDto = new DurationInfoDto();
		durationInfoDto.setDuration(2);
		durationInfoDto.setDurationId(2);

		sessionInfoDto.setDurationInfoDto(durationInfoDto);

		sessionInfoDto.setEventInfoDto(eventInfoDto);

		LevelInfoDto levelInfoDto = new LevelInfoDto();
		levelInfoDto.setLevelId(2);
		levelInfoDto.setLevelname("Advanced");

		sessionInfoDto.setLevelInfoDto(levelInfoDto);
		sessionInfoDto.setSessionname("SessionA");
		sessionInfoDto.setUsersvotes(0);
		sessionInfoDto.setUsersregistered(0);

		List<UserDto> users = new ArrayList<UserDto>();
		UserDto userDto = new UserDto();
		userDto.setAge(20);
		userDto.setBio("Engineer");
		userDto.setEmailId("a@gmail.com");
		userDto.setFname("ABC");
		userDto.setLname("XYZ");
		userDto.setPassword("password");
		users.add(userDto);
		userDto.setSessions(sessions);
		sessions.add(sessionInfoDto);
		sessionInfoDto.setUserList(null);

		sessions.add(sessionInfoDto);
		webRequest.setEvent(eventInfoDto);
		webRequest.setSessions(sessions);
		webRequest.setUsers(users);

		// System.out.println(eventController.addNewEvent(webRequest));
		// System.out.println(eventController.removeEvent(webRequest));
		System.out.println(eventController.fetchAllEvents().getEventMap());

		((ConfigurableApplicationContext) ctx).close();
	}

}