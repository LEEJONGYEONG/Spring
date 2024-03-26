package com.oracle.team2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.team2.service.DY_Service.DY_Service_Interface;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DY_Controller {
	private final DY_Service_Interface  dys;
	private final CommonController cc;
	
	
	@RequestMapping(value = "loginView")
	public String login() {
		
		return "DY_views/login";
	}
}
