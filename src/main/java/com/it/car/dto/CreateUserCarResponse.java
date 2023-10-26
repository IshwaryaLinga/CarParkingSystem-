package com.it.car.dto;

public class CreateUserCarResponse {

	private long carId;
	private boolean createFlag;
	private String errorMessage;

	public long getCarId() {
		return carId;
	}

	public boolean isCreateFlag() {
		return createFlag;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}

	public void setCreateFlag(boolean createFlag) {
		this.createFlag = createFlag;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
