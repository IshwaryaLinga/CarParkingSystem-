package com.it.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it.car.dto.AssignVehicleFeeRequest;
import com.it.car.service.CarOwnerPaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/api/car-owner-payment")
@RestController
@Tag(name = "Controller to pay Car Owner Due")
public class CarOwnerPaymentController {

	@Autowired
	private CarOwnerPaymentService carOwnerPaymentService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	@Operation(summary = "Get all Vehicles, which are in due")
	public String payDue(@RequestBody AssignVehicleFeeRequest request) {
		boolean flag = carOwnerPaymentService.payDue(request);
		if(flag) {
			return "Payment success";
		} else {
			return "Payment failed. Please try after some time.";
		}
	}

}
