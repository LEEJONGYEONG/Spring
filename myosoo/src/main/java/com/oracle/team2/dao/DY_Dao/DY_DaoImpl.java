package com.oracle.team2.dao.DY_Dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;



import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DY_DaoImpl implements DY_Dao_Interface {

	private final SqlSession session;	

}// class
