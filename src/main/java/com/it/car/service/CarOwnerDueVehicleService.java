package com.it.car.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.car.dto.CarOwnerDueVehicleDto;
import com.it.car.repository.CarOwnerDueVehicleRepository;

@Service
public class CarOwnerDueVehicleService {

	@Autowired
	private CarOwnerDueVehicleRepository carOwnerDueVehicleRepository;

	public List<CarOwnerDueVehicleDto> getDueVehicles(String username) {
		List<CarOwnerDueVehicleDto> dtos = new ArrayList<>();

		List<Object[]> objList = carOwnerDueVehicleRepository.getDueVehicles(username);
		for (Object[] obj : objList) {
			CarOwnerDueVehicleDto dto = new CarOwnerDueVehicleDto();
			dto.setColor((String) obj[1]);
			dto.setDate((Date) obj[9]);
			dto.setDue((BigDecimal) obj[8]);
			dto.setFee((BigDecimal) obj[6]);
			dto.setLicensePlateNumber((String) obj[2]);
			dto.setMake((String) obj[0]);
			dto.setModel((String) obj[3]);
			dto.setPaid((BigDecimal) obj[7]);
			dto.setState((String) obj[4]);
			dto.setYear((String) obj[5]);
			dtos.add(dto);
		}

		return dtos;
	}

}
