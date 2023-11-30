package com.it.car.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it.car.dto.CarOwnerNoParkingVehicleDto;
import com.it.car.dto.UsernameDto;
import com.it.car.service.CarOwnerMessagesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/api/car-owner-warning-messages")
@RestController
@Tag(name = "Controller - As a Car Owner, I want to receive warning messages, so that I can remove vehicle from No Parking area.")
public class CarOwnerMessagesServiceController {

	@Autowired
	private CarOwnerMessagesService carOwnerMessagesService;

	@RequestMapping(value = "/all", method = RequestMethod.POST)
	@Operation(summary = "Get all Vehicles, which are in no parking area")
	public List<CarOwnerNoParkingVehicleDto> getNoParkingVehicles(@RequestBody UsernameDto dto) {
		if(StringUtils.isEmpty(dto.getUsername())) {
			return new ArrayList<>();
		}
		return carOwnerMessagesService.getNoParkingVehicles(dto.getUsername());
	}
	
	@RequestMapping(value = "/vehicle/{vehicleId}", method = RequestMethod.DELETE)
	@Operation(summary = "Remove vehicle from No Parking area after receiving warning message to Car Owner")
	public String removeVehicleFromNoParkingArea(@PathParam("vehicleId") long vehicleId) {
		carOwnerMessagesService.removeVehicleFromNoParkingArea(vehicleId);
		return "Vehicle removed from No Parking area";
	}

}
