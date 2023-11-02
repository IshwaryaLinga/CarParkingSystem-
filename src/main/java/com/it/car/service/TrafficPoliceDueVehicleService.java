package com.it.car.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.car.domain.UserCarInfo;
import com.it.car.domain.UserInfo;
import com.it.car.domain.VehicleNoParkingInfo;
import com.it.car.dto.VehicleUserInfoDto;
import com.it.car.repository.UserCarInfoRepository;
import com.it.car.repository.UserInfoRepository;
import com.it.car.repository.TrafficPoliceDueVehicleRepository;

@Service
public class TrafficPoliceDueVehicleService {

	@Autowired
	private TrafficPoliceDueVehicleRepository trafficPoliceDueVehicleRepository;
	@Autowired
	private UserCarInfoRepository userCarInfoRepository;
	@Autowired
	private UserInfoRepository userInfoRepository;

	public List<VehicleUserInfoDto> getDueVehicles() {
		List<VehicleUserInfoDto> dtos = new ArrayList<>();

		Set<Long> carIds = new HashSet<>();
		Map<Long, UserCarInfo> carMap = new HashMap<>();
		Set<Long> userIds = new HashSet<>();
		Map<Long, UserInfo> userMap = new HashMap<>();

		List<VehicleNoParkingInfo> vehicleNoParkingInfos = trafficPoliceDueVehicleRepository.getDueVehicles();
		for (VehicleNoParkingInfo vehicleNoParkingInfo : vehicleNoParkingInfos) {
			carIds.add(vehicleNoParkingInfo.getCarId());
		}

		List<UserCarInfo> userCarInfos = userCarInfoRepository.getCarInfosByIds(carIds);
		for (UserCarInfo userCarInfo : userCarInfos) {
			carMap.put(userCarInfo.getId(), userCarInfo);
			userIds.add(userCarInfo.getUserId());
		}

		List<UserInfo> userInfos = userInfoRepository.getUserInfoByIds(userIds);
		for (UserInfo userInfo : userInfos) {
			userMap.put(userInfo.getId(), userInfo);
		}

		for (VehicleNoParkingInfo vehicleNoParkingInfo : vehicleNoParkingInfos) {
			VehicleUserInfoDto dto = new VehicleUserInfoDto();

			dto.setVehicleId(vehicleNoParkingInfo.getId());
			dto.setFee(vehicleNoParkingInfo.getFee());
			dto.setPaid(vehicleNoParkingInfo.getPaid());
			dto.setDue(vehicleNoParkingInfo.getDue());
			dto.setDate(vehicleNoParkingInfo.getCreateDate());

			dto.setCarId(vehicleNoParkingInfo.getCarId());
			UserCarInfo userCarInfo = carMap.get(vehicleNoParkingInfo.getCarId());
			dto.setColor(userCarInfo.getColor());
			dto.setLicensePlateNo(userCarInfo.getLicensePlateNumber());
			dto.setMake(userCarInfo.getMake());
			dto.setModel(userCarInfo.getModel());
			dto.setState(userCarInfo.getState());
			dto.setYear(userCarInfo.getYear());

			dto.setUserId(userCarInfo.getUserId());
			UserInfo userInfo = userMap.get(userCarInfo.getUserId());
			dto.setFirstName(userInfo.getFirstName());
			dto.setLastName(userInfo.getLastName());
			dto.setUsername(userInfo.getUsername());

			dtos.add(dto);
		}

		return dtos;
	}

}
