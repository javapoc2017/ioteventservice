package com.semisol.data.domain;

import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class Device {
	
	@PrimaryKeyColumn(name = "devid", type = PrimaryKeyType.PARTITIONED)
	private UUID devid;
	private String dev_macid;
	private String devname;
	private Map<String,String> attributes;
	private Timestamp updated_time;
	/**
	 * @return the devid
	 */
	public UUID getDevid() {
		return devid;
	}
	/**
	 * @param devid the devid to set
	 */
	public void setDevid(UUID devid) {
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
	/**
	 * @return the updated_time
	 */
	public Timestamp getUpdated_time() {
		return updated_time;
	}
	/**
	 * @param updated_time the updated_time to set
	 */
	public void setUpdated_time(Timestamp updated_time) {
		this.updated_time = updated_time;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributes == null) ? 0 : attributes.hashCode());
		result = prime * result + ((dev_macid == null) ? 0 : dev_macid.hashCode());
		result = prime * result + ((devid == null) ? 0 : devid.hashCode());
		result = prime * result + ((devname == null) ? 0 : devname.hashCode());
		result = prime * result + ((updated_time == null) ? 0 : updated_time.hashCode());
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
		Device other = (Device) obj;
		if (attributes == null) {
			if (other.attributes != null)
				return false;
		} else if (!attributes.equals(other.attributes))
			return false;
		if (dev_macid == null) {
			if (other.dev_macid != null)
				return false;
		} else if (!dev_macid.equals(other.dev_macid))
			return false;
		if (devid == null) {
			if (other.devid != null)
				return false;
		} else if (!devid.equals(other.devid))
			return false;
		if (devname == null) {
			if (other.devname != null)
				return false;
		} else if (!devname.equals(other.devname))
			return false;
		if (updated_time == null) {
			if (other.updated_time != null)
				return false;
		} else if (!updated_time.equals(other.updated_time))
			return false;
		return true;
	}
	

}
