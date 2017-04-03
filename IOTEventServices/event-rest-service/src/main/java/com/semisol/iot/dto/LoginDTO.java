package com.semisol.iot.dto;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class LoginDTO implements UserDetails{
	
	private String username ;
	private String firsName;
	private String lasName;
	private String email;
	private String mobileNo;
	private String password;
	private UUID orgId;
	private List<UUID> device;
	private boolean status;
	 private Date lastPasswordReset;
	  private Collection<? extends GrantedAuthority> authorities;
	  private Boolean accountNonExpired = true;
	  private Boolean accountNonLocked = true;
	  private Boolean credentialsNonExpired = true;
	  private Boolean enabled = true;
	  
	/**
	 * @return the lastPasswordReset
	 */
	public Date getLastPasswordReset() {
		return lastPasswordReset;
	}
	/**
	 * @param lastPasswordReset the lastPasswordReset to set
	 */
	public void setLastPasswordReset(Date lastPasswordReset) {
		this.lastPasswordReset = lastPasswordReset;
	}
	/**
	 * @return the accountNonExpired
	 */
	 @JsonIgnore
	public Boolean getAccountNonExpired() {
		return accountNonExpired;
	}
	/**
	 * @param accountNonExpired the accountNonExpired to set
	 */
	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	/**
	 * @return the accountNonLocked
	 */
	 @JsonIgnore
	public Boolean getAccountNonLocked() {
		return accountNonLocked;
	}
	/**
	 * @param accountNonLocked the accountNonLocked to set
	 */
	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	/**
	 * @return the credentialsNonExpired
	 */
	 @JsonIgnore
	public Boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	/**
	 * @param credentialsNonExpired the credentialsNonExpired to set
	 */
	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	/**
	 * @return the enabled
	 */
	 @JsonIgnore
	public Boolean getEnabled() {
		return enabled;
	}
	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
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
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return this.getAccountNonExpired();
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return this.getAccountNonLocked();
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return this.getCredentialsNonExpired();
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.getEnabled();
	}
	
	
}
