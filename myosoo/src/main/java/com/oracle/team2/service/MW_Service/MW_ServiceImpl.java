package com.oracle.team2.service.MW_Service;

import org.springframework.stereotype.Service;

import com.oracle.team2.dao.MW_Dao.MW_Dao_Interface;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MW_ServiceImpl implements MW_Service_Interface {

	private final MW_Dao_Interface mwd;
}
