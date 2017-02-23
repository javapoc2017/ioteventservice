package com.semisol.iot.dto;

import java.util.List;
import java.util.UUID;

public class LoginDTO {
	
	private String username ;
	private String first_name;
	private String last_name;
	private String email;
	private String mobileno;
	private String password;
	//private Date updated_time;
	private UUID orgid;
	private List<UUID> device;
	
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
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
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
	 * @return the mobileno
	 */
	public String getMobileno() {
		return mobileno;
	}
	/**
	 * @param mobileno the mobileno to set
	 */
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
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
	 * @return the updated_time
	 *//*
	public Date getUpdated_time() {
		return updated_time;
	}
	*//**
	 * @param updated_time the updated_time to set
	 *//*
	public void setUpdated_time(Date updated_time) {
		this.updated_time = updated_time;
	}*/
	/**
	 * @return the orgid
	 */
	public UUID getOrgid() {
		return orgid;
	}
	/**
	 * @param orgid the orgid to set
	 */
	public void setOrgid(UUID orgid) {
		this.orgid = orgid;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoginDTO [username=" + username + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
				+ email + ", mobileno=" + mobileno + ", password=" + password +  ", orgid=" + orgid + ", device=" + device + "]";
	}
}
