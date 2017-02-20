package com.semisol.iot.dto;

import java.util.Map;

public class DeviceDTO {
	private String devid;
	private String dev_macid;
	private String devname;
	private Map<String,String> attributes;
	/**
	 * @return the devid
	 */
	public String getDevid() {
		return devid;
	}
	/**
	 * @param devid the devid to set
	 */
	public void setDevid(String devid) {
		this.devid = devid;
	}
	/**
	 * @return the dev_macid
	 */
	public String getDev_macid() {
		return dev_macid;
	}
	/**
	 * @param dev_macid the dev_macid to set
	 */
	public void setDev_macid(String dev_macid) {
		this.dev_macid = dev_macid;
	}
	/**
	 * @return the devname
	 */
	public String getDevname() {
		return devname;
	}
	/**
	 * @param devname the devname to set
	 */
	public void setDevname(String devname) {
		this.devname = devname;
	}
	/**
	 * @return the attributes
	 */
	public Map<String, String> getAttributes() {
		return attributes;
	}
	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	
	

}
