package com.oracle.team2.dao.JH_Dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;




import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JH_DaoImpl implements JH_Dao_Interface {

	private final SqlSession session;

	

}// class
