package com.event.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.event.dao.LevelDao;
import com.event.exception.CommonException;
import com.event.model.LevelInfo;
import com.event.service.LevelService;
import com.event.transformation.utils.CommonCodes;

@Service("LevelServiceImpl")
@EnableAsync
@Transactional
public class LevelServiceImpl implements LevelService {

	@Autowired
	private LevelDao levelDao;

	public String addLevel(LevelInfo levelInfo) throws CommonException {
		LevelInfo levelInfoFromDB = levelDao.getLevelByName(levelInfo.getLevelname());
		if (null == levelInfoFromDB) {
			levelDao.addLevel(levelInfo);
		}

		return CommonCodes.SUCCESS;
	}

	public String removeLevel(LevelInfo levelInfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
