/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.event.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PVerma
 */
@Entity
@Table(name = "duration_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DurationInfo.findAll", query = "SELECT d FROM DurationInfo d"),
    @NamedQuery(name = "DurationInfo.findByDurationId", query = "SELECT d FROM DurationInfo d WHERE d.durationId = :durationId"),
    @NamedQuery(name = "DurationInfo.findByDuration", query = "SELECT d FROM DurationInfo d WHERE d.duration = :duration")})
public class DurationInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "duration_id")
    private Integer durationId;
    @Column(name = "duration")
    private Integer duration;

    public DurationInfo() {
    }

    public DurationInfo(Integer durationId) {
        this.durationId = durationId;
    }

    public Integer getDurationId() {
        return durationId;
    }

    public void setDurationId(Integer durationId) {
        this.durationId = durationId;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (durationId != null ? durationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DurationInfo)) {
            return false;
        }
        DurationInfo other = (DurationInfo) object;
        if ((this.durationId == null && other.durationId != null) || (this.durationId != null && !this.durationId.equals(other.durationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.event.model.DurationInfo[ durationId=" + durationId + " ]";
    }
    
}
