package com.it.car.dto;

public class CreateUserResponse {

	private long userId;
	private boolean createFlag;
	private String errorMessage;

	public long getUserId() {
		return userId;
	}

	public boolean isCreateFlag() {
		return createFlag;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setCreateFlag(boolean createFlag) {
		this.createFlag = createFlag;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
