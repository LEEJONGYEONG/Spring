package com.oracle.team2.service.MS_Service;

import org.springframework.stereotype.Service;

import com.oracle.team2.dao.MS_Dao.MS_Dao_Interface;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MS_ServiceImpl implements MS_Service_Interface {

	private final MS_Dao_Interface msd;
}
