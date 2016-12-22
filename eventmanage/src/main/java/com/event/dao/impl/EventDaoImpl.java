package com.event.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.event.dao.EventDao;
import com.event.exception.CommonException;
import com.event.model.EventInfo;
import com.event.transformation.utils.CommonCodes;

@Repository("eventDao")
public class EventDaoImpl implements EventDao {

	@PersistenceContext
	private EntityManager emManager;

	@SuppressWarnings("unchecked")
	public List<EventInfo> getAllEvents() throws CommonException {
		List<EventInfo> events = new ArrayList<EventInfo>();
		try {
			Query query = emManager.createNamedQuery("EventInfo.findAll");
			events = query.getResultList();
		} catch (Exception e) {
			emManager.getTransaction().rollback();
			throw new CommonException(e.getMessage());
		}
		return events;
	}

	public String addEvent(EventInfo eventInfo) throws CommonException {
		try {
			emManager.persist(eventInfo);
			return CommonCodes.SUCCESS;
		} catch (Exception e) {

			throw new CommonException(e.getMessage());
		}
	}

	public EventInfo getEventByName(EventInfo eventInfo) throws CommonException {
		EventInfo eventInfoFromDB = null;
		try {
			Query query = emManager.createNamedQuery("EventInfo.findByEventname");
			query.setParameter("eventname", eventInfo.getEventname());
			@SuppressWarnings("unchecked")
			List<EventInfo> events = query.getResultList();
			if (null != events && !events.isEmpty()) {
				eventInfoFromDB = events.get(0);
			}
		} catch (Exception e) {
			emManager.getTransaction().rollback();
			throw new CommonException(e.getMessage());
		}
		return eventInfoFromDB;
	}

	public String removeEvent(EventInfo eventInfo) throws CommonException {
		try {

			emManager.remove(eventInfo);

			return CommonCodes.SUCCESS;
		} catch (Exception e) {

			throw new CommonException(e.getMessage());
		}

	}

}
