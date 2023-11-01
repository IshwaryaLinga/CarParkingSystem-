package com.it.car.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.car.domain.UserCarInfo;
import com.it.car.domain.UserInfo;
import com.it.car.dto.CreateUserCarResponse;
import com.it.car.dto.CreateUserResponse;
import com.it.car.dto.UserCarDto;
import com.it.car.dto.UserDto;
import com.it.car.repository.UserCarInfoRepository;
import com.it.car.repository.UserInfoRepository;

@Service
public class LoginService {

	@Autowired
	private UserInfoRepository userInfoRepository;
	@Autowired
	private UserCarInfoRepository userCarInfoRepository;

	public CreateUserResponse createUser(UserDto dto) {
		CreateUserResponse response = new CreateUserResponse();
		response.setCreateFlag(false);

		long count = userInfoRepository.validateUsername(dto.getUsername().toLowerCase());
		if (count > 0) {
			response.setErrorMessage("Username already Exists");
		} else {
			try {
				UserInfo userInfo = new UserInfo();
				userInfo.setCreateDate(new Date());
				userInfo.setFirstName(dto.getFirstName());
				userInfo.setLastName(dto.getLastName());
				userInfo.setUsername(dto.getUsername());
				userInfo.setPassword(dto.getPassword());
				userInfo.setUserType(dto.getUserType());
				userInfo = userInfoRepository.save(userInfo);
				response.setCreateFlag(true);
				response.setUserId(userInfo.getId());
			} catch (Exception e) {
				response.setErrorMessage("Error occured during User creation in database");
			}
		}

		return response;
	}

	public boolean loginUser(UserDto dto) {
		boolean flag = false;
		long count = userInfoRepository.validateUser(dto.getUsername(), dto.getPassword());
		if (count == 1) {
			flag = true;
		}
		return flag;
	}

	public CreateUserCarResponse createUserCar(UserCarDto dto) {
		CreateUserCarResponse response = new CreateUserCarResponse();
		response.setCreateFlag(false);

		Long userId = userCarInfoRepository.validateUserCar(dto.getLicensePlateNumber().toLowerCase());
		if (userId != null) {
			if (userId == dto.getUserId()) {
				response.setErrorMessage("Car already registered with this user");
			} else {
				response.setErrorMessage("Car already registered with other user");
			}
		} else {
			try {
				UserCarInfo info = new UserCarInfo();
				info.setCreateDate(new Date());
				info.setColor(dto.getColor());
				info.setLicensePlateNumber(dto.getLicensePlateNumber());
				info.setMake(dto.getMake());
				info.setModel(dto.getModel());
				info.setState(dto.getState());
				info.setUserId(dto.getUserId());
				info.setYear(dto.getYear());
				info = userCarInfoRepository.save(info);
				response.setCreateFlag(true);
				response.setCarId(info.getId());
			} catch (Exception e) {
				response.setErrorMessage("Error occured during User creation in database");
			}
		}

		return response;
	}

}
