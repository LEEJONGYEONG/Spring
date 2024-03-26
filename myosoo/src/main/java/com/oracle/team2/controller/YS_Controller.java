package com.oracle.team2.controller;


import org.springframework.stereotype.Controller;


import com.oracle.team2.service.YS_Service.YS_Service_Interface;


import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class YS_Controller {
	private final YS_Service_Interface yss;
	private final CommonController cc;
	
	
	
}//class 
