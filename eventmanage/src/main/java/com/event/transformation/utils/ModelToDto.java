package com.event.transformation.utils;

import java.util.ArrayList;
import java.util.List;

import com.event.dto.DurationInfoDto;
import com.event.dto.EventInfoDto;
import com.event.dto.LevelInfoDto;
import com.event.dto.LocationDto;
import com.event.dto.SessionInfoDto;
import com.event.dto.UserDto;
import com.event.model.DurationInfo;
import com.event.model.EventInfo;
import com.event.model.LevelInfo;
import com.event.model.Location;
import com.event.model.SessionInfo;
import com.event.model.User;

public class ModelToDto {

	public static EventInfoDto getEventDto(EventInfo eventInfo) {

		EventInfoDto eventInfoDto = new EventInfoDto();

		eventInfoDto.setEventId(eventInfo.getEventId());
		eventInfoDto.setEventName(eventInfo.getEventname());
		eventInfoDto.setLocationDto(getLocationDto(eventInfo.getLocationId()));
		eventInfoDto.setDate(eventInfo.getTimings());
		return eventInfoDto;
	}

	public static SessionInfoDto getSessionDto(SessionInfo sessionInfo) {

		SessionInfoDto sessionInfoDto = new SessionInfoDto();
		sessionInfoDto.setSessionId(sessionInfo.getSessionId());
		sessionInfoDto.setUsersvotes(sessionInfo.getUsersvotes());
		sessionInfoDto.setUsersregistered(sessionInfo.getUsersregistered());
		sessionInfoDto.setEventInfoDto(getEventDto(sessionInfo.getEventInfo()));
		sessionInfoDto.setDurationInfoDto(getDurationDto(sessionInfo.getDurationId()));
		sessionInfoDto.setLevelInfoDto(getLevelDto(sessionInfo.getLevelId()));
		sessionInfoDto.setSessionname(sessionInfo.getSessionname());
		List<User> users = sessionInfo.getUserList();
		List<UserDto> usersDto = new ArrayList<UserDto>();
		if (null != users && !users.isEmpty()) {
			for (User user : users) {
				usersDto.add(getUserDto(user));
			}
		}
		sessionInfoDto.setUserList(usersDto);

		return sessionInfoDto;
	}

	public static LocationDto getLocationDto(Location location) {

		LocationDto locationDto = new LocationDto();
		locationDto.setAddress(location.getAddress());
		locationDto.setCity(location.getCity());
		locationDto.setLocationId(location.getLocationId());
		locationDto.setProvince(location.getProvince());

		return locationDto;
	}

	public static DurationInfoDto getDurationDto(DurationInfo durationInfo) {
		DurationInfoDto durationInfoDto = new DurationInfoDto();
		durationInfoDto.setDuration(durationInfo.getDuration());
		durationInfoDto.setDurationId(durationInfo.getDurationId());
		return durationInfoDto;
	}

	public static LevelInfoDto getLevelDto(LevelInfo levelInfo) {
		LevelInfoDto levelInfoDto = new LevelInfoDto();
		levelInfoDto.setLevelId(levelInfo.getLevelId());
		levelInfoDto.setLevelname(levelInfo.getLevelname());
		return levelInfoDto;
	}

	public static UserDto getUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setUserId(user.getUserId());
		userDto.setUsername(user.getUsername());
		userDto.setEmailId(user.getEmailId());
		userDto.setFname(user.getFname());
		userDto.setLname(user.getLname());
		userDto.setAge(user.getAge());
		userDto.setBio(user.getBio());
		userDto.setPassword(user.getPassword());
		userDto.setSessions(null);
		return userDto;

	}

}
