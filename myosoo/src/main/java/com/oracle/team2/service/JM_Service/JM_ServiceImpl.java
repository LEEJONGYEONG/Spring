package com.oracle.team2.service.JM_Service;

import org.springframework.stereotype.Service;

import com.oracle.team2.dao.JM_Dao.JM_Dao_Interface;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JM_ServiceImpl implements JM_Service_Interface {

	private final JM_Dao_Interface jmd;
}
