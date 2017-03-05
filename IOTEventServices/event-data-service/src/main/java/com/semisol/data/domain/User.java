package com.semisol.data.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class User {
	@Id
	@PrimaryKeyColumn(name = "userid", type = PrimaryKeyType.PARTITIONED)
	private UUID userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNo;
	private String password;
	private Date lastModified;
	private boolean status;
	private UUID orgId;
	private UUID gId;
	private List<UUID> device = new ArrayList<UUID>();
	/**
	 * @return the userId
	 */
	public UUID getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", mobileNo=" + mobileNo + ", password=" + password
				+ ", lastModified=" + lastModified + ", status=" + status + ", orgId=" + orgId + ", gId=" + gId
				+ ", device=" + device + "]";
	}

}
