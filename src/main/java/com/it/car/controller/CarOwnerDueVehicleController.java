package com.it.car.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it.car.dto.CarOwnerDueVehicleDto;
import com.it.car.dto.UserDto;
import com.it.car.service.CarOwnerDueVehicleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/api/car-owner-due-vehicle")
@RestController
@Tag(name = "Controller to get Car Owner Due Vehicles")
public class CarOwnerDueVehicleController {

	@Autowired
	private CarOwnerDueVehicleService carOwnerDueVehicleService;

	@RequestMapping(value = "/all", method = RequestMethod.POST)
	@Operation(summary = "Get all Vehicles, which are in due")
	public List<CarOwnerDueVehicleDto> getDueVehicles(@RequestBody UserDto dto) {
		if(StringUtils.isEmpty(dto.getUsername())) {
			return new ArrayList<>();
		}
		return carOwnerDueVehicleService.getDueVehicles(dto.getUsername());
	}

}
