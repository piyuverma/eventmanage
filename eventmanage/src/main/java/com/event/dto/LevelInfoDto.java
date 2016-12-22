package com.event.dto;

import java.io.Serializable;

public class LevelInfoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer levelId;
	private String levelname;

	/**
	 * @return the levelId
	 */
	public Integer getLevelId() {
		return levelId;
	}

	/**
	 * @param levelId
	 *            the levelId to set
	 */
	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	/**
	 * @return the levelname
	 */
	public String getLevelname() {
		return levelname;
	}

	/**
	 * @param levelname
	 *            the levelname to set
	 */
	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}

	@Override
	public int hashCode() {
		return this.getLevelId();

	}

	@Override
	public boolean equals(Object obj) {
		if (this.getLevelId() == ((LevelInfoDto) obj).getLevelId())
			return true;
		else
			return false;
	}

}
