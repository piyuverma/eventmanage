package com.event.service;

import com.event.exception.CommonException;
import com.event.model.LevelInfo;

public interface LevelService {

	public String addLevel(LevelInfo levelInfo) throws CommonException;

	public String removeLevel(LevelInfo levelInfo);

}
