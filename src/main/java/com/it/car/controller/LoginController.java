package com.it.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it.car.dto.CreateUserCarResponse;
import com.it.car.dto.CreateUserResponse;
import com.it.car.dto.UserCarDto;
import com.it.car.dto.UserDto;
import com.it.car.service.LoginService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/api/login")
@RestController
@Tag(name = "Controller to register user, user login, register car")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@Operation(summary = "Register Trafic Police or Car Owner")
	public CreateUserResponse createUser(@RequestBody UserDto dto) {
		return loginService.createUser(dto);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@Operation(summary = "Login Trafic Police or Car Owner")
	public boolean loginUser(@RequestBody UserDto dto) {
		return loginService.loginUser(dto);
	}
	
	@RequestMapping(value = "/create-user-car", method = RequestMethod.POST)
	@Operation(summary = "Register Car Owner's Car")
	public CreateUserCarResponse createUserCar(@RequestBody UserCarDto dto) {
		return loginService.createUserCar(dto);
	}

}
