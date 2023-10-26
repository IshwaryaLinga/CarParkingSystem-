package com.it.car.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "POC_VEHICLE_NO_PARKING_INFO")
@SequenceGenerator(name = "POC_CAR_SERVICE_SEQ", sequenceName = "POC_CAR_SERVICE_SEQ", allocationSize = 1, initialValue = 1)
public class VehicleNoParkingInfo {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POC_CAR_SERVICE_SEQ")
	private Long id;

	// FK to UserCarInfo class/table
	@Column(name = "car_id")
	private long carId;

	@Column(name = "fee")
	private BigDecimal fee;

	@Column(name = "paid")
	private BigDecimal paid;

	@Column(name = "due")
	private BigDecimal due;

	@Column(name = "create_date")
	private Date createDate;

	public Long getId() {
		return id;
	}

	public long getCarId() {
		return carId;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCarId(long carId) {
		this.carId = carId;
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

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
