package com.event.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.event.dao.SessionDao;
import com.event.exception.CommonException;
import com.event.model.SessionInfo;
import com.event.transformation.utils.CommonCodes;

@Repository("sessionDao")
public class SessionDaoImpl implements SessionDao {

	@Autowired
	private EntityManager emManager;

	@SuppressWarnings("unchecked")
	public List<SessionInfo> getAllSessions(Integer eventId) throws CommonException {

		List<SessionInfo> sessions = null;
		try {
			Query query = emManager.createNamedQuery("SessionInfo.findByEventId");
			query.setParameter("eventId", eventId);
			sessions = query.getResultList();
		} catch (Exception e) {
			emManager.getTransaction().rollback();
			throw new CommonException(e.getMessage());
		}
		return sessions;
	}

	public String addSession(SessionInfo sessionInfo) throws CommonException {
		try {

			emManager.persist(sessionInfo);

			return CommonCodes.SUCCESS;
		} catch (Exception e) {
			emManager.getTransaction().rollback();

			throw new CommonException(e.getMessage());
		}
	}

	public String removeSession(SessionInfo sessionInfo) throws CommonException {
		try {

			emManager.remove(sessionInfo);

			return CommonCodes.SUCCESS;
		} catch (Exception e) {

			emManager.getTransaction().rollback();
			throw new CommonException(e.getMessage());
		}
	}

	public SessionInfo getSessionByName(String sessionname) throws CommonException {
		SessionInfo sessionInfoFromDB = null;

		try {
			Query query = emManager.createNamedQuery("SessionInfo.findBySessionname");
			query.setParameter("sessionname", sessionname);
			@SuppressWarnings("unchecked")
			List<SessionInfo> sessions = query.getResultList();
			if (null != sessions && !sessions.isEmpty()) {
				sessionInfoFromDB = sessions.get(0);
			}
		} catch (Exception e) {
			emManager.getTransaction().rollback();
			throw new CommonException(e.getMessage());
		}

		return sessionInfoFromDB;
	}

}
