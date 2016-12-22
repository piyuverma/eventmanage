package com.event.service;

import com.event.exception.CommonException;
import com.event.model.DurationInfo;

public interface DurationService {
	public Integer addDuration(DurationInfo durationInfo) throws CommonException;

	public String removeDuration(DurationInfo durationInfo);

	public String updateDuration(DurationInfo durationInfo);

}
