package com.oracle.team2.service.DY_Service;

import org.springframework.stereotype.Service;

import com.oracle.team2.dao.DY_Dao.DY_Dao_Interface;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DY_ServiceImpl implements DY_Service_Interface {

	private final DY_Dao_Interface dyd;
}
