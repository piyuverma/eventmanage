/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.event.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PVerma
 */
@Entity
@Table(name = "location")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
		@NamedQuery(name = "Location.findByLocationId", query = "SELECT l FROM Location l WHERE l.locationId = :locationId"),
		@NamedQuery(name = "Location.findByAddress", query = "SELECT l FROM Location l WHERE l.address = :address"),
		@NamedQuery(name = "Location.findByCity", query = "SELECT l FROM Location l WHERE l.city = :city"),
		@NamedQuery(name = "Location.findByProvince", query = "SELECT l FROM Location l WHERE l.province = :province"),
		@NamedQuery(name = "Location.findByAddress,City and Province", query = "SELECT l FROM Location l WHERE l.address=:address and l.city=:city and l.province = :province") })
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "location_id")
	private Integer locationId;
	@Column(name = "address")
	private String address;
	@Column(name = "city")
	private String city;
	@Column(name = "province")
	private String province;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "locationId")
	private List<EventInfo> eventInfoList;

	public Location() {
	}

	public Location(Integer locationId) {
		this.locationId = locationId;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@XmlTransient
	public List<EventInfo> getEventInfoList() {
		return eventInfoList;
	}

	public void setEventInfoList(List<EventInfo> eventInfoList) {
		this.eventInfoList = eventInfoList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (locationId != null ? locationId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Location)) {
			return false;
		}
		Location other = (Location) object;
		if ((this.locationId == null && other.locationId != null)
				|| (this.locationId != null && !this.locationId.equals(other.locationId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.event.model.Location[ locationId=" + locationId + " ]";
	}

}
