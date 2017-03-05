package com.semisol.data.domain;

import java.util.Date;
import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

public class Category {
	@Id
	@PrimaryKeyColumn(name = "catId", type = PrimaryKeyType.PARTITIONED)
	private UUID catId;
	private String name;
	private String description;
	private Date lastModified;
	/**
	 * @return the catId
	 */
	public UUID getCatId() {
		return catId;
	}
	/**
	 * @param catId the catId to set
	 */
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
	 * @param name the name to set
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
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the lastModified
	 */
	public Date getLastModified() {
		return lastModified;
	}
	/**
	 * @param lastModified the lastModified to set
	 */
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Category [catId=" + catId + ", name=" + name + ", description=" + description + ", lastModified="
				+ lastModified + "]";
	}

}
