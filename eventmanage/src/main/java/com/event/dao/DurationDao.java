package com.event.dao;

import com.event.exception.CommonException;
import com.event.model.DurationInfo;

public interface DurationDao {

	public String addDuration(DurationInfo durationInfo) throws CommonException;

	public String removeDuration(DurationInfo durationInfo) throws CommonException;

	public DurationInfo getDuration(DurationInfo durationInfo);

}
