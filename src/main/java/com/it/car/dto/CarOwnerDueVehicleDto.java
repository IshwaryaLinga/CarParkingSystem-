package com.it.car.dto;

import java.math.BigDecimal;
import java.util.Date;

public class CarOwnerDueVehicleDto {

	private String make;
	private String color;
	private String licensePlateNumber;
	private String model;
	private String state;
	private String year;
	private BigDecimal fee;
	private BigDecimal paid;
	private BigDecimal due;
	private Date date;

	public String getMake() {
		return make;
	}

	public String getColor() {
		return color;
	}

	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}

	public String getModel() {
		return model;
	}

	public String getState() {
		return state;
	}

	public String getYear() {
		return year;
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

	public void setMake(String make) {
		this.make = make;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setYear(String year) {
		this.year = year;
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

}
