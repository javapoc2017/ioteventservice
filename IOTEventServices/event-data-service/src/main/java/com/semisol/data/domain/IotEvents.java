package com.semisol.data.domain;

import java.sql.Timestamp;
import java.util.Map;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table("iot_events")
public class IotEvents {
	@PrimaryKeyColumn(name = "devId", ordinal = 0, type = PrimaryKeyType.CLUSTERED)
	private String devId;
	@Column(value = "loginId")
	private String loginId;
	@Column(value = "type")
	private String type;
	@PrimaryKeyColumn(name = "eventTime", ordinal = 3, type = PrimaryKeyType.PARTITIONED)
	private Timestamp eventTime;
	@Column(value = "attributes")
	private Map<String, String> attributes;

	public String getDevId() {
		return devId;
	}

	public void setDevId(String devId) {
		this.devId = devId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getEventTime() {
		return eventTime;
	}

	public void setEventTime(Timestamp eventTime) {
		this.eventTime = eventTime;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return "Device [devId=" + devId + ", loginId=" + loginId + ", type=" + type + ", eventTime=" + eventTime
				+ ", attributes=" + attributes + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributes == null) ? 0 : attributes.hashCode());
		result = prime * result + ((devId == null) ? 0 : devId.hashCode());
		result = prime * result + ((loginId == null) ? 0 : loginId.hashCode());
		result = prime * result + ((type== null) ? 0 : type.hashCode());
		result = prime * result + ((eventTime == null) ? 0 : eventTime.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IotEvents other = (IotEvents) obj;
		if (attributes == null) {
			if (other.attributes != null)
				return false;
		} else if (!attributes.equals(other.attributes))
			return false;
		if (devId == null) {
			if (other.devId != null)
				return false;
		} else if (!devId.equals(other.devId))
			return false;
		if (loginId == null) {
			if (other.loginId != null)
				return false;
		} else if (!loginId.equals(other.loginId))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (eventTime == null) {
			if (other.eventTime != null)
				return false;
		} else if (!eventTime.equals(other.eventTime))
			return false;
		return true;
	}

}
