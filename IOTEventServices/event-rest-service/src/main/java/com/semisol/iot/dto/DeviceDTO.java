package com.semisol.iot.dto;

import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;

public class DeviceDTO {
	private UUID devId;
	private String macId;
	private String name;
	private Map<String,String> attributes;
	private boolean status;
	private Timestamp lastModified;
	private UUID catId;
	private UUID gId;
	private UUID locId;
	public UUID getDevId() {
		return devId;
	}
	public void setDevId(UUID devId) {
		this.devId = devId;
	}
	public String getMacId() {
		return macId;
	}
	public void setMacId(String macId) {
		this.macId = macId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, String> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Timestamp getLastModified() {
		return lastModified;
	}
	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}
	public UUID getCatId() {
		return catId;
	}
	public void setCatId(UUID catId) {
		this.catId = catId;
	}
	public UUID getgId() {
		return gId;
	}
	public void setgId(UUID gId) {
		this.gId = gId;
	}
	public UUID getLocId() {
		return locId;
	}
	public void setLocId(UUID locId) {
		this.locId = locId;
	}

	@Override
	public String toString() {
		return "Device [devId=" + devId + ", macId=" + macId + ", name=" + name + ", attributes=" + attributes
				+ ", status=" + status + ", lastModified=" + lastModified + ", catId=" + catId + ", gId=" + gId
				+ ", locId=" + locId + "]";
	}
		

}
