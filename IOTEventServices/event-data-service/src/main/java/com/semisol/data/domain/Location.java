package com.semisol.data.domain;

import java.util.Date;
import java.util.UUID;

public class Location {
	private UUID locId;
	private String name;
	private String latitude;
	private String longitude;
	private String description;
	private Date lastModified;
	private boolean status;

	/**
	 * @return the locId
	 */
	public UUID getLocId() {
		return locId;
	}

	/**
	 * @param locId
	 *            the locId to set
	 */
	public void setLocId(UUID locId) {
		this.locId = locId;
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
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
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

	/**
	 * @return the lastModified
	 */
	public Date getLastModified() {
		return lastModified;
	}

	/**
	 * @param lastModified
	 *            the lastModified to set
	 */
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Location [locId=" + locId + ", name=" + name + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", description=" + description + ", lastModified=" + lastModified + ", status=" + status + "]";
	}

}
