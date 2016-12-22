package com.event.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.event.dao.LevelDao;
import com.event.exception.CommonException;
import com.event.model.LevelInfo;
import com.event.transformation.utils.CommonCodes;

@Repository("levelDao")
public class LevelDaoImpl implements LevelDao {

	@Autowired
	private EntityManager emManager;

	public LevelInfo getLevelByName(String name) {
		Query query = emManager.createNamedQuery("LevelInfo.findByLevelname");
		query.setParameter("levelname", name);
		@SuppressWarnings("unchecked")
		List<LevelInfo> levels = query.getResultList();
		if (null != levels && !levels.isEmpty()) {
			return levels.get(0);
		}
		return null;
	}

	public String addLevel(LevelInfo levelInfo) throws CommonException {
		try {
			emManager.persist(levelInfo);
			return CommonCodes.SUCCESS;
		} catch (Exception e) {
			throw new CommonException(e.getMessage());
		}
	}

	public String removeLevel(LevelInfo levelInfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
