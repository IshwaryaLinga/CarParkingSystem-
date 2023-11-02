package com.it.car.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.car.domain.VehicleNoParkingInfo;
import com.it.car.dto.AssignVehicleFeeRequest;
import com.it.car.repository.CarOwnerPaymentRepository;
import com.it.car.repository.VehicleNoParkingInfoRepository;

@Service
public class CarOwnerPaymentService {

	@Autowired
	private CarOwnerPaymentRepository carOwnerPaymentRepository;
	@Autowired
	private VehicleNoParkingInfoRepository vehicleNoParkingInfoRepository;

	public boolean payDue(AssignVehicleFeeRequest request) {
		try {
			VehicleNoParkingInfo info = vehicleNoParkingInfoRepository.getById(request.getVehicleId());
			BigDecimal due = info.getFee().subtract(request.getFee());
			carOwnerPaymentRepository.updatePaidAndDue(request.getVehicleId(), request.getFee(), due);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
