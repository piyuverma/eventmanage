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
@Table(name = "level_info")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LevelInfo.findAll", query = "SELECT l FROM LevelInfo l"),
		@NamedQuery(name = "LevelInfo.findByLevelId", query = "SELECT l FROM LevelInfo l WHERE l.levelId = :levelId"),
		@NamedQuery(name = "LevelInfo.findByLevelname", query = "SELECT l FROM LevelInfo l WHERE l.levelname = :levelname") })
public class LevelInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "level_id")
	private Integer levelId;
	@Column(name = "levelname")
	private String levelname;

	public LevelInfo() {
	}

	public LevelInfo(Integer levelId) {
		this.levelId = levelId;
	}

	public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public String getLevelname() {
		return levelname;
	}

	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (levelId != null ? levelId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LevelInfo)) {
			return false;
		}
		LevelInfo other = (LevelInfo) object;
		if ((this.levelId == null && other.levelId != null)
				|| (this.levelId != null && !this.levelId.equals(other.levelId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.event.model.LevelInfo[ levelId=" + levelId + " ]";
	}

}
