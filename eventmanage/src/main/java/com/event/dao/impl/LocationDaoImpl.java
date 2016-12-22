package com.event.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.event.dao.LocationDao;
import com.event.model.Location;

@Repository("locationDao")
public class LocationDaoImpl implements LocationDao {

	@PersistenceContext
	private EntityManager emManager;

	@SuppressWarnings("unchecked")
	public Location getLocationByAddressCityProvince(Location location) {

		List<Location> locations = new ArrayList<Location>();
		Query query = emManager.createNamedQuery("Location.findByAddress,City and Province");

		query.setParameter("address", location.getAddress());
		query.setParameter("city", location.getCity());
		query.setParameter("province", location.getProvince());
		locations = query.getResultList();

		if (null != locations && !locations.isEmpty())
			return locations.get(0);
		else
			return null;
	}

	@SuppressWarnings("unchecked")
	public Location getLocationById(Integer id) {

		List<Location> locations = new ArrayList<Location>();
		Query query = emManager.createNamedQuery("Location.findByLocationId");
		query.setParameter(0, id);

		locations = query.getResultList();

		if (null != locations && !locations.isEmpty())
			return locations.get(0);
		else
			return null;
	}

	public void addLocation(Location location) {

		emManager.persist(location);

	}

}
