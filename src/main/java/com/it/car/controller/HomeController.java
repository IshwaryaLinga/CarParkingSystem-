package com.it.car.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(ModelMap model) throws Exception {
		return "redirect:swagger-ui/index.html";
	}
}
