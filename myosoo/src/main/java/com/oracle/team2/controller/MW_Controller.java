package com.oracle.team2.controller;


import org.springframework.stereotype.Controller;

import com.oracle.team2.service.MW_Service.MW_Service_Interface;



import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MW_Controller {
	private final MW_Service_Interface mws;
	private final CommonController cc;
	
	
	
}//class 
