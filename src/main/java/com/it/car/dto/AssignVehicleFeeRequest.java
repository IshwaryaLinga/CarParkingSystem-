package com.it.car.dto;

import java.math.BigDecimal;

public class AssignVehicleFeeRequest {

	private long vehicleId;
	private BigDecimal fee;

	public long getVehicleId() {
		return vehicleId;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

}
