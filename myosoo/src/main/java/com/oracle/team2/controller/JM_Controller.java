package com.oracle.team2.controller;

import org.springframework.stereotype.Controller;

import com.oracle.team2.service.JM_Service.JM_Service_Interface;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class JM_Controller {
	private final JM_Service_Interface  jms;
	private final CommonController cc;
}
