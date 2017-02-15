package com.semisol.data.domain;

import java.sql.Timestamp;
import java.util.Map;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class IotEvents {
	private String devid;
	private String devloginid;
	private String devtype;
	//Need to change different field for primarykey may be we can have iotEventID
	@PrimaryKeyColumn(name = "event_time", type = PrimaryKeyType.PARTITIONED)
	private Timestamp event_time;
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
	 * @return the devloginid
	 */
	public String getDevloginid() {
		return devloginid;
	}
	/**
	 * @param devloginid the devloginid to set
	 */
	public void setDevloginid(String devloginid) {
		this.devloginid = devloginid;
	}
	/**
	 * @return the devtype
	 */
	public String getDevtype() {
		return devtype;
	}
	/**
	 * @param devtype the devtype to set
	 */
	public void setDevtype(String devtype) {
		this.devtype = devtype;
	}
	/**
	 * @return the event_time
	 */
	public Timestamp getEvent_time() {
		return event_time;
	}
	/**
	 * @param event_time the event_time to set
	 */
	public void setEvent_time(Timestamp event_time) {
		this.event_time = event_time;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributes == null) ? 0 : attributes.hashCode());
		result = prime * result + ((devid == null) ? 0 : devid.hashCode());
		result = prime * result + ((devloginid == null) ? 0 : devloginid.hashCode());
		result = prime * result + ((devtype == null) ? 0 : devtype.hashCode());
		result = prime * result + ((event_time == null) ? 0 : event_time.hashCode());
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
		if (devid == null) {
			if (other.devid != null)
				return false;
		} else if (!devid.equals(other.devid))
			return false;
		if (devloginid == null) {
			if (other.devloginid != null)
				return false;
		} else if (!devloginid.equals(other.devloginid))
			return false;
		if (devtype == null) {
			if (other.devtype != null)
				return false;
		} else if (!devtype.equals(other.devtype))
			return false;
		if (event_time == null) {
			if (other.event_time != null)
				return false;
		} else if (!event_time.equals(other.event_time))
			return false;
		return true;
	}

}
