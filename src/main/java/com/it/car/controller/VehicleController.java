package com.it.car.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it.car.dto.AssignVehicleFeeRequest;
import com.it.car.dto.VehicleUserInfoDto;
import com.it.car.service.VehicleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/api/vehicle")
@RestController
@Tag(name = "Controller to get No Parking vehicles, assign fee, send reminder message etc..")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@RequestMapping(value = "/no-parking-vehicles", method = RequestMethod.GET)
	@Operation(summary = "Get all No Parking Vehicles")
	public List<VehicleUserInfoDto> getNoParkingVehicles() {
		return vehicleService.getNoParkingVehicles();
	}

	@RequestMapping(value = "/assign-fee", method = RequestMethod.POST)
	@Operation(summary = "Assign Fee")
	public Map<Long, Boolean> assignFee(@RequestBody List<AssignVehicleFeeRequest> requests) {
		return vehicleService.assignFee(requests);
	}

	@RequestMapping(value = "/send-reminder-message", method = RequestMethod.POST)
	@Operation(summary = "Send reminder message")
	public Map<Long, Boolean> sendRemiderMessage(@RequestBody List<Long> vehicleIds) {
		return vehicleService.sendRemiderMessage(vehicleIds);
	}

}
