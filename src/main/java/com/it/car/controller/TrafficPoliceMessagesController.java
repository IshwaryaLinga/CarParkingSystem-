package com.it.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it.car.dto.TrafficPoliceNoParkingVehicleDto;
import com.it.car.service.TrafficPoliceMessagesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/api/traffic-police-alert-messages")
@RestController
@Tag(name = "Controller - As a Traffic Police, I want to receive alerts on my system, so that I can view the cars that are in No Parking area")
public class TrafficPoliceMessagesController {

	@Autowired
	private TrafficPoliceMessagesService trafficPoliceMessagesService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@Operation(summary = "Get all Vehicles, which are in no parking area")
	public List<TrafficPoliceNoParkingVehicleDto> getNoParkingVehicles() {
		return trafficPoliceMessagesService.getNoParkingVehicles();
	}

}
