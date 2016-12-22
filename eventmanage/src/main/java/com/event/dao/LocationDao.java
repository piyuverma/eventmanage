package com.event.dao;

import com.event.model.Location;

public interface LocationDao {

	public Location getLocationById(Integer id);

	public Location getLocationByAddressCityProvince(Location location);

	public void addLocation(Location location);

}
