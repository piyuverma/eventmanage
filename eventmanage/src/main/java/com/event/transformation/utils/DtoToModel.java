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

public class DtoToModel {

	public static EventInfo getEventModel(EventInfoDto eventInfoDto) {
		EventInfo eventInfo = new EventInfo();
		eventInfo.setEventId(eventInfoDto.getEventId());
		eventInfo.setEventname(eventInfoDto.getEventName());
		eventInfo.setLocationId(getLocationModel(eventInfoDto.getLocationDto()));
		eventInfo.setTimings(eventInfoDto.getDate());
		return eventInfo;

	}

	public static SessionInfo getSessionModel(SessionInfoDto sessionInfoDto) {
		SessionInfo sessionInfo = new SessionInfo();
		sessionInfo.setSessionId(sessionInfoDto.getSessionId());
		sessionInfo.setDurationId(getDurationModel(sessionInfoDto.getDurationInfoDto()));
		sessionInfo.setEventInfo(getEventModel(sessionInfoDto.getEventInfoDto()));
		sessionInfo.setLevelId(getLevelModel(sessionInfoDto.getLevelInfoDto()));
		sessionInfo.setSessionname(sessionInfoDto.getSessionname());
		sessionInfo.setUsersregistered(sessionInfoDto.getUsersregistered());
		sessionInfo.setUsersvotes(sessionInfoDto.getUsersvotes());
		List<User> users = new ArrayList<User>();
		if (null != sessionInfoDto.getUserList()) {
			for (UserDto userDto : sessionInfoDto.getUserList()) {
				users.add(getUserModel(userDto));

			}
		}
		sessionInfo.setUserList(users);
		return sessionInfo;

	}

	public static Location getLocationModel(LocationDto locationDto) {
		Location location = new Location();
		location.setAddress(locationDto.getAddress());
		location.setCity(locationDto.getCity());
		location.setLocationId(locationDto.getLocationId());
		location.setProvince(locationDto.getProvince());

		return location;

	}

	public static DurationInfo getDurationModel(DurationInfoDto durationInfoDto) {
		DurationInfo durationInfo = new DurationInfo();
		durationInfo.setDuration(durationInfoDto.getDuration());
		durationInfo.setDurationId(durationInfoDto.getDurationId());
		return durationInfo;

	}

	public static LevelInfo getLevelModel(LevelInfoDto levelInfoDto) {
		LevelInfo levelInfo = new LevelInfo();
		levelInfo.setLevelId(levelInfoDto.getLevelId());
		levelInfo.setLevelname(levelInfoDto.getLevelname());
		return levelInfo;

	}

	public static User getUserModel(UserDto userDto) {
		User user = new User();

		user.setAge(userDto.getAge());
		user.setBio(userDto.getBio());
		user.setEmailId(userDto.getEmailId());
		user.setFname(userDto.getFname());
		user.setLname(userDto.getLname());
		user.setPassword(userDto.getPassword());
		user.setUsername(userDto.getUsername());
		user.setUserId(userDto.getUserId());
		List<SessionInfo> sessions = new ArrayList<SessionInfo>();
		for (SessionInfoDto sessionInfoDto : userDto.getSessions()) {
			sessions.add(getSessionModel(sessionInfoDto));
		}
		user.setSessionInfoList(sessions);
		return user;

	}

}
