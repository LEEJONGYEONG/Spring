package com.oracle.team2.dao.MS_Dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;



import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MS_DaoImpl implements MS_Dao_Interface {

	private final SqlSession session;	

}// class
