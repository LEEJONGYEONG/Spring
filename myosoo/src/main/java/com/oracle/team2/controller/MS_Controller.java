package com.oracle.team2.controller;

import org.springframework.stereotype.Controller;

import com.oracle.team2.service.MS_Service.MS_Service_Interface;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MS_Controller {
	private final MS_Service_Interface  mss;
	private final CommonController cc;
}
