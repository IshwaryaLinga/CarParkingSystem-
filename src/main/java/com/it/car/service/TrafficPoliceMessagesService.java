package com.it.car.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.car.dto.TrafficPoliceNoParkingVehicleDto;
import com.it.car.repository.TrafficPoliceNoParkingRepository;

@Service
public class TrafficPoliceMessagesService {

	@Autowired
	private TrafficPoliceNoParkingRepository trafficPoliceNoParkingRepository;

	public List<TrafficPoliceNoParkingVehicleDto> getNoParkingVehicles() {
		List<TrafficPoliceNoParkingVehicleDto> dtos = new ArrayList<>();

		List<Object[]> objList = trafficPoliceNoParkingRepository.getNoParkingVehicles();
		for (Object[] obj : objList) {
			TrafficPoliceNoParkingVehicleDto dto = new TrafficPoliceNoParkingVehicleDto();
			dto.setColor((String) obj[1]);
			dto.setDate((Date) obj[6]);
			dto.setLicensePlateNumber((String) obj[2]);
			dto.setMake((String) obj[0]);
			dto.setModel((String) obj[3]);
			dto.setState((String) obj[4]);
			dto.setYear((String) obj[5]);
			dto.setUsername((String) obj[8]);
			dto.setVehicleId(((BigDecimal) obj[7]).longValue());
			dtos.add(dto);
		}
		return dtos;
	}
	
}
