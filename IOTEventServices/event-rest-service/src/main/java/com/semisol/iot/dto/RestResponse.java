package com.semisol.iot.dto;

import java.util.List;

public class RestResponse {
	
	private String sessionId;
	
	private boolean status;
	
	private List<Errors> error;

	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @return the error
	 */
	public List<Errors> getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(List<Errors> error) {
		this.error = error;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
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
	

}
