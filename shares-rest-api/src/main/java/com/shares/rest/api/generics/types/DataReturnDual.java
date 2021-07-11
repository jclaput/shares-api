package com.shares.rest.api.generics.types;

public class DataReturnDual<T, S> {
	
	private boolean isSuccessfull;
	private String message;
	private T firstReturn;
	private S secondReturn;
	
	public boolean isSuccessfull() {
		return isSuccessfull;
	}
	public void setSuccessfull(boolean isSuccessfull) {
		this.isSuccessfull = isSuccessfull;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getFirstReturn() {
		return firstReturn;
	}
	public void setFirstReturn(T firstReturn) {
		this.firstReturn = firstReturn;
	}
	public S getSecondReturn() {
		return secondReturn;
	}
	public void setSecondReturn(S secondReturn) {
		this.secondReturn = secondReturn;
	}
}
