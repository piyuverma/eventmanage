package com.event.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.event.dao.SessionDao;
import com.event.dto.EventInfoDto;
import com.event.dto.SessionInfoDto;
import com.event.exception.CommonException;
import com.event.model.DurationInfo;
import com.event.model.LevelInfo;
import com.event.model.SessionInfo;
import com.event.model.WebRequest;
import com.event.service.DurationService;
import com.event.service.LevelService;
import com.event.service.SessionService;
import com.event.transformation.utils.CommonCodes;
import com.event.transformation.utils.DtoToModel;
import com.event.transformation.utils.ModelToDto;

@Service("SessionServiceImpl")
@EnableAsync
@Transactional
public class SessionServiceImpl implements SessionService {

	@Autowired
	private SessionDao sessionDao;

	@Autowired
	private DurationService durationService;

	@Autowired
	private LevelService levelService;

	public List<SessionInfoDto> getEventSessions(WebRequest webRequest) throws CommonException {
		EventInfoDto eventInfoDto = webRequest.getEvent();
		List<SessionInfo> sessions = sessionDao.getAllSessions(eventInfoDto.getEventId());
		List<SessionInfoDto> sessionsDto = new ArrayList<SessionInfoDto>();
		for (SessionInfo sessionInfo : sessions) {
			sessionsDto.add(ModelToDto.getSessionDto(sessionInfo));
		}
		return sessionsDto;
	}

	public String addSession(WebRequest webRequest) throws CommonException {
		List<SessionInfoDto> sessions = webRequest.getSessions();

		for (SessionInfoDto sessionInfoDto : sessions) {
			SessionInfo sessionInfo = DtoToModel.getSessionModel(sessionInfoDto);
			DurationInfo durationInfo = sessionInfo.getDurationId();
			LevelInfo levelInfo = sessionInfo.getLevelId();
			Integer durationId = durationService.addDuration(durationInfo);
			levelService.addLevel(levelInfo);
			sessionInfo.getDurationId().setDurationId(durationId);
			SessionInfo sessionInfoFromDB = sessionDao.getSessionByName(sessionInfo.getSessionname());
			if (null == sessionInfoFromDB) {
				sessionDao.addSession(sessionInfo);
			}
		}
		return CommonCodes.SUCCESS;
	}

	public String removeSession(WebRequest webRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateSession(WebRequest webRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
