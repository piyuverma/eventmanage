package com.event.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.event.dao.DurationDao;
import com.event.exception.CommonException;
import com.event.model.DurationInfo;
import com.event.transformation.utils.CommonCodes;

@Repository("durationDao")
public class DurationDaoImpl implements DurationDao {

	@PersistenceContext
	private EntityManager emManager;

	public String addDuration(DurationInfo durationInfo) throws CommonException {
		try {
			emManager.persist(durationInfo);
			return CommonCodes.SUCCESS;
		} catch (Exception e) {

			throw new CommonException(e.getMessage());
		}

	}

	public String removeDuration(DurationInfo durationInfo) throws CommonException {
		try {
			emManager.remove(durationInfo);
			return CommonCodes.SUCCESS;
		} catch (Exception e) {

			throw new CommonException(e.getMessage());
		}

	}

	public DurationInfo getDuration(DurationInfo durationInfo) {

		Query query = emManager.createNamedQuery("DurationInfo.findByDuration");
		query.setParameter("duration", durationInfo.getDuration());
		@SuppressWarnings("unchecked")
		List<DurationInfo> durations = query.getResultList();
		if (null != durations && !durations.isEmpty()) {
			return durations.get(0);
		}
		return null;
	}
}
