package com.it.car.dto;

import java.math.BigDecimal;
import java.util.Date;

public class VehicleUserInfoDto {

	private long vehicleId;
	private BigDecimal fee;
	private BigDecimal paid;
	private BigDecimal due;
	private Date date;

	private long carId;
	private String licensePlateNo;
	private String state;
	private String model;
	private String make;
	private String year;
	private String color;
	private long userId;
	private String firstName;
	private String lastName;
	private String username;

	public long getVehicleId() {
		return vehicleId;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public BigDecimal getPaid() {
		return paid;
	}

	public BigDecimal getDue() {
		return due;
	}

	public Date getDate() {
		return date;
	}

	public long getCarId() {
		return carId;
	}

	public String getLicensePlateNo() {
		return licensePlateNo;
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

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public void setPaid(BigDecimal paid) {
		this.paid = paid;
	}

	public void setDue(BigDecimal due) {
		this.due = due;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}

	public void setLicensePlateNo(String licensePlateNo) {
		this.licensePlateNo = licensePlateNo;
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

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
