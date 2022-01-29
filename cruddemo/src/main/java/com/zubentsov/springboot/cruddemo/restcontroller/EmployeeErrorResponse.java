package com.zubentsov.springboot.cruddemo.restcontroller;

public class EmployeeErrorResponse {
	
	private int errorId;
	private String message;
	private long currentTime;
	
	public EmployeeErrorResponse(int errorId, String message, long currentTime) {
		super();
		this.errorId = errorId;
		this.message = message;
		this.currentTime = currentTime;
	}

	public int getErrorId() {
		return errorId;
	}

	public void setErrorId(int errorId) {
		this.errorId = errorId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(long currentTime) {
		this.currentTime = currentTime;
	}

	@Override
	public String toString() {
		return "CustomerErrorResponse [errorId=" + errorId + ", message=" + message + ", currentTime=" + currentTime
				+ "]";
	}
	
	

}
