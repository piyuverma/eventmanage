package com.event.dao;

import com.event.exception.CommonException;
import com.event.model.LevelInfo;

public interface LevelDao {

	public LevelInfo getLevelByName(String name);

	public String addLevel(LevelInfo levelInfo) throws CommonException;

	public String removeLevel(LevelInfo levelInfo);

}
