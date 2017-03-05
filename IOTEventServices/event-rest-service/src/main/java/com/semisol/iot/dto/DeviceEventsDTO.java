package com.semisol.iot.dto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import com.semisol.data.domain.DeviceEvent;

public class DeviceEventsDTO {
	private UUID eventId;
	private String devId;
	private String loginId;
	private String type;
	private Timestamp eventTime;
	private Map<String, String> attributes;
	/**
	 * @return the eventId
	 */
	public UUID getEventId() {
		return eventId;
	}
	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(UUID eventId) {
		this.eventId = eventId;
	}
	/**
	 * @return the devId
	 */
	public String getDevId() {
		return devId;
	}
	/**
	 * @param devId the devId to set
	 */
	public void setDevId(String devId) {
		this.devId = devId;
	}
	/**
	 * @return the loginId
	 */
	public String getLoginId() {
		return loginId;
	}
	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the eventTime
	 */
	public Timestamp getEventTime() {
		return eventTime;
	}
	/**
	 * @param eventTime the eventTime to set
	 */
	public void setEventTime(Timestamp eventTime) {
		this.eventTime = eventTime;
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
	
	@Override
	public String toString() {
		return "IotEvents [eventId=" + eventId + ", devId=" + devId + ", loginId=" + loginId + ", type=" + type
				+ ", eventTime=" + eventTime + ", attributes=" + attributes + "]";
	}

}
