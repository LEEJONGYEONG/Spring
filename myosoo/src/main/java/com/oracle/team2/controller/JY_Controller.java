package com.oracle.team2.controller;

import org.springframework.stereotype.Controller;

import com.oracle.team2.service.JY_Service.JY_Service_Interface;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class JY_Controller {
	private final JY_Service_Interface  jys;
	private final CommonController cc;
}
