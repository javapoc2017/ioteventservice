package com.semisol.iot.dto;

import java.util.List;

public class RestResponse {
	
	private String token;
	
	private boolean status;
	
	private List<Errors> error;
	public RestResponse(){}

	public RestResponse(String token,boolean status){
		this.token = token;
		this.status= status;
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
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
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
