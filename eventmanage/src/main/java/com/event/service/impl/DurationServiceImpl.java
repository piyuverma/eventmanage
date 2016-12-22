package com.event.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.event.dao.DurationDao;
import com.event.exception.CommonException;
import com.event.model.DurationInfo;
import com.event.service.DurationService;

@Service("DurationServiceImpl")
@EnableAsync
@Transactional
public class DurationServiceImpl implements DurationService {

	@Autowired
	private DurationDao durationDao;

	public Integer addDuration(DurationInfo durationInfo) throws CommonException {

		DurationInfo durationInfoFromDB = durationDao.getDuration(durationInfo);
		if (null == durationInfoFromDB) {
			durationDao.addDuration(durationInfo);
			return durationInfo.getDurationId();

		}
		return durationInfoFromDB.getDurationId();
	}

	public String removeDuration(DurationInfo durationInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateDuration(DurationInfo durationInfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
