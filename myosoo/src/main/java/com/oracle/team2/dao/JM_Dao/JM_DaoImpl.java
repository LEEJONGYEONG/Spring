package com.oracle.team2.dao.JM_Dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.team2.model.Member;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JM_DaoImpl implements JM_Dao_Interface {

	private final SqlSession session;


	@Override
	public Member login(String username, String password) {
		System.out.println("로그인 다오 시작...");
		Member member = new Member();
		try {
			member.setMember_id(username);
			member.setMember_pw(password);
			System.out.println("!!!!!!!!!!!!!!!"+member.getMember_id());
			member = session.selectOne("jmLogin", member);
		} catch (Exception e) {
			System.out.println("익셉션--? "+e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("정보는 갖고오는가..-->"+member);
		return member;
	}	

}// class
