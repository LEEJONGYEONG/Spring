package com.oracle.team2.service.JY_Service;

import org.springframework.stereotype.Service;

import com.oracle.team2.dao.DY_Dao.DY_Dao_Interface;
import com.oracle.team2.dao.JY_Dao.JY_Dao_Interface;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JY_ServiceImpl implements JY_Service_Interface {

	private final JY_Dao_Interface jyd;
}
