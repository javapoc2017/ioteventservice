package com.semisol.iot.dto;

import java.util.Date;
import java.util.UUID;

public class CategoryDTO {
	private UUID catId;
	private String name;
	private String description;
	private Date lastModified;

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public UUID getCatId() {
		return catId;
	}

	public void setCatId(UUID catId) {
		this.catId = catId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
