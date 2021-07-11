package com.shares.rest.api.data;

public class BatchUpdateResult {
		
	private boolean updateSuccessfull;
	private String message;
	
	public boolean isUpdateSuccessfull() {
		return updateSuccessfull;
	}
	public void setUpdateSuccessfull(boolean updateSuccessfull) {
		this.updateSuccessfull = updateSuccessfull;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
