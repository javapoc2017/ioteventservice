package com.semisol.iot.dto;

import java.util.Date;
import java.util.UUID;

public class GatewayDTO {
	private UUID gId;
	private String name;
	private String macId;
	private String description;
	private boolean status;
	private UUID locId;
	private UUID orgId;
	private Date lastModified;
	
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
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
	 * @return the macId
	 */
	public String getMacId() {
		return macId;
	}
	/**
	 * @param macId the macId to set
	 */
	public void setMacId(String macId) {
		this.macId = macId;
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
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	/**
	 * @return the locId
	 */
	public UUID getLocId() {
		return locId;
	}
	/**
	 * @param locId the locId to set
	 */
	public void setLocId(UUID locId) {
		this.locId = locId;
	}
	/**
	 * @return the orgId
	 */
	public UUID getOrgId() {
		return orgId;
	}
	/**
	 * @param orgId the orgId to set
	 */
	public void setOrgId(UUID orgId) {
		this.orgId = orgId;
	}
	public UUID getgId() {
		return gId;
	}
	public void setgId(UUID gId) {
		this.gId = gId;
	}
	
}
