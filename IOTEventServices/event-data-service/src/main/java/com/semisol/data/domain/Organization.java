package com.semisol.data.domain;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;


@Table
public class Organization {
	
	
	private UUID orgid;
	
	@PrimaryKeyColumn(name = "orgname", type = PrimaryKeyType.PARTITIONED)
	private String orgname;
	
	private String description;
	
	private Timestamp updated_time;

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

	/**
	 * @return the orgname
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * @param orgname the orgname to set
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((orgid == null) ? 0 : orgid.hashCode());
		result = prime * result + ((orgname == null) ? 0 : orgname.hashCode());
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
		Organization other = (Organization) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (orgid == null) {
			if (other.orgid != null)
				return false;
		} else if (!orgid.equals(other.orgid))
			return false;
		if (orgname == null) {
			if (other.orgname != null)
				return false;
		} else if (!orgname.equals(other.orgname))
			return false;
		if (updated_time == null) {
			if (other.updated_time != null)
				return false;
		} else if (!updated_time.equals(other.updated_time))
			return false;
		return true;
	}
	
	

}
