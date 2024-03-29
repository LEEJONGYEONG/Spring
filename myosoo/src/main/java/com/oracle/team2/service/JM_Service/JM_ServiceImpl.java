package com.oracle.team2.service.JM_Service;

import org.springframework.stereotype.Service;

import com.oracle.team2.dao.JM_Dao.JM_Dao_Interface;
import com.oracle.team2.model.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JM_ServiceImpl implements JM_Service_Interface {

	private final JM_Dao_Interface jmd;


	@Override
	public Member login(String username, String password) {
		System.out.println("로그인 서비스 시작...");
		Member member = jmd.login(username, password);
		System.out.println("여기까진 오나????");
		return member;
	}
}
