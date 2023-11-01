package com.it.car.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "POC_USER_CAR_INFO")
@SequenceGenerator(name = "POC_CAR_SERVICE_SEQ", sequenceName = "POC_CAR_SERVICE_SEQ", allocationSize = 1, initialValue = 1)
public class UserCarInfo {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POC_CAR_SERVICE_SEQ")
	private Long id;

	@Column(name = "license_plate_no")
	private String licensePlateNumber;

	@Column(name = "state")
	private String state;

	@Column(name = "model")
	private String model;

	@Column(name = "make")
	private String make;

	@Column(name = "year")
	private String year;

	@Column(name = "color")
	private String color;

	@Column(name = "create_date")
	private Date createDate;

	// FK to UserInfo class/table
	@Column(name = "user_id")
	private long userId;

	public Long getId() {
		return id;
	}

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

	public Date getCreateDate() {
		return createDate;
	}

	public long getUserId() {
		return userId;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
