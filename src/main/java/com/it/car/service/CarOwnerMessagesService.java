package com.it.car.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.car.dto.CarOwnerNoParkingVehicleDto;
import com.it.car.repository.CarOwnerNoParkingRepository;

@Service
public class CarOwnerMessagesService {

	@Autowired
	private CarOwnerNoParkingRepository carOwnerNoParkingRepository;

	public List<CarOwnerNoParkingVehicleDto> getNoParkingVehicles(String username) {
		List<CarOwnerNoParkingVehicleDto> dtos = new ArrayList<>();

		List<Object[]> objList = carOwnerNoParkingRepository.getNoParkingVehicles(username);
		for (Object[] obj : objList) {
			CarOwnerNoParkingVehicleDto dto = new CarOwnerNoParkingVehicleDto();
			dto.setColor((String) obj[1]);
			dto.setDate((Date) obj[6]);
			dto.setLicensePlateNumber((String) obj[2]);
			dto.setMake((String) obj[0]);
			dto.setModel((String) obj[3]);
			dto.setState((String) obj[4]);
			dto.setYear((String) obj[5]);
			dto.setVehicleId(((BigDecimal) obj[7]).longValue());
			dtos.add(dto);
		}
		return dtos;
	}
	
	public void removeVehicleFromNoParkingArea(long vehicleId) {
		carOwnerNoParkingRepository.deleteById(vehicleId);
	}

}
