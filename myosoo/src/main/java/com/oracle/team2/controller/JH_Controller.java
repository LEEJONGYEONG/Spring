package com.oracle.team2.controller;

import org.springframework.stereotype.Controller;

import com.oracle.team2.service.JH_Service.JH_Service_Interface;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class JH_Controller {
	private final JH_Service_Interface  jhs;
	private final CommonController cc;
}
