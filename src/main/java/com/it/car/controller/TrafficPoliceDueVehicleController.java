package com.it.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it.car.dto.VehicleUserInfoDto;
import com.it.car.service.TrafficPoliceDueVehicleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/api/traffic-police-due-vehicle")
@RestController
@Tag(name = "Controller to get Traffice Police Due Vehicles")
public class TrafficPoliceDueVehicleController {

	@Autowired
	private TrafficPoliceDueVehicleService trafficPoliceDueVehicleService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@Operation(summary = "Get all Vehicles, which are in due")
	public List<VehicleUserInfoDto> getDueVehicles() {
		return trafficPoliceDueVehicleService.getDueVehicles();
	}

}
