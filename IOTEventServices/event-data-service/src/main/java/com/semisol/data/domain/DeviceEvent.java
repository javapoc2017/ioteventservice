package com.semisol.data.domain;

import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table("device_events")
public class DeviceEvent {
	@PrimaryKeyColumn(name = "eventId", ordinal = 0, type = PrimaryKeyType.CLUSTERED)
	private UUID eventId;
	@Column(value = "devId")
	private String devId;
	@Column(value = "loginId")
	private String loginId;
	@Column(value = "type")
	private String type;
	@PrimaryKeyColumn(name = "eventTime", ordinal = 3, type = PrimaryKeyType.PARTITIONED)
	private Timestamp eventTime;
	@Column(value = "attributes")
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
