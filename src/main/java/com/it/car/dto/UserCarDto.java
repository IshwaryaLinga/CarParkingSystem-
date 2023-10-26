package com.it.car.dto;

public class UserCarDto {

	private String licensePlateNumber;
	private String state;
	private String model;
	private String make;
	private String year;
	private String color;
	private long userId;

	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}

	public String getState() {
		return state;
	}

	public String getModel() {
		return model;
	}

	public String getMake() {
		return make;
	}

	public String getYear() {
		return year;
	}

	public String getColor() {
		return color;
	}

	public long getUserId() {
		return userId;
	}

	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
