package com.oracle.team2.dao.JM_Dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;



import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JM_DaoImpl implements JM_Dao_Interface {

	private final SqlSession session;	

}// class
