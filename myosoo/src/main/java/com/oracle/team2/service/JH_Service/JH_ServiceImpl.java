package com.oracle.team2.service.JH_Service;

import org.springframework.stereotype.Service;

import com.oracle.team2.dao.JH_Dao.JH_Dao_Interface;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JH_ServiceImpl implements JH_Service_Interface {

	private final JH_Dao_Interface jhd;
}
