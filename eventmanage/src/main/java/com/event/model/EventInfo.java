/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.event.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PVerma
 */
@Entity
@Table(name = "event_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventInfo.findAll", query = "SELECT e FROM EventInfo e"),
    @NamedQuery(name = "EventInfo.findByEventId", query = "SELECT e FROM EventInfo e WHERE e.eventId = :eventId"),
    @NamedQuery(name = "EventInfo.findByEventname", query = "SELECT e FROM EventInfo e WHERE e.eventname = :eventname"),
    @NamedQuery(name = "EventInfo.findByTimings", query = "SELECT e FROM EventInfo e WHERE e.timings = :timings")})
public class EventInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "event_id")
    private Integer eventId;
    
    @Column(name = "eventname")
    private String eventname;
    
    @Column(name = "timings")
    @Temporal(TemporalType.TIME)
    private Date timings;
    
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
    @ManyToOne(optional = false)
    private Location locationId;
  
    public EventInfo() {
    }

    public EventInfo(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public Date getTimings() {
        return timings;
    }

    public void setTimings(Date timings) {
        this.timings = timings;
    }

    public Location getLocationId() {
        return locationId;
    }

    public void setLocationId(Location locationId) {
        this.locationId = locationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventInfo)) {
            return false;
        }
        EventInfo other = (EventInfo) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.event.model.EventInfo[ eventId=" + eventId + " ]";
    }
    
}
