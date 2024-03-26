package com.oracle.team2.dao.JY_Dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;




import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JY_DaoImpl implements JY_Dao_Interface {

	private final SqlSession session;

	

}// class
