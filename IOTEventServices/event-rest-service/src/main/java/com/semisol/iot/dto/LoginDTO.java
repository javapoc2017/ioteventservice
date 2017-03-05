package com.semisol.iot.dto;

import java.util.List;
import java.util.UUID;

public class LoginDTO {
	
	private String username ;
	private String firsName;
	private String lasName;
	private String email;
	private String mobileNo;
	private String password;
	private UUID orgId;
	private List<UUID> device;
	private boolean status;
	/**
	 * @return the gId
	 */
	public UUID getgId() {
		return gId;
	}
	/**
	 * @param gId the gId to set
	 */
	public void setgId(UUID gId) {
		this.gId = gId;
	}
	private UUID gId;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the firsName
	 */
	public String getFirsName() {
		return firsName;
	}
	/**
	 * @param firsName the firsName to set
	 */
	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}
	/**
	 * @return the lasName
	 */
	public String getLasName() {
		return lasName;
	}
	/**
	 * @param lasName the lasName to set
	 */
	public void setLasName(String lasName) {
		this.lasName = lasName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}
	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	/**
	 * @return the device
	 */
	public List<UUID> getDevice() {
		return device;
	}
	/**
	 * @param device the device to set
	 */
	public void setDevice(List<UUID> device) {
		this.device = device;
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
	
	
}
