package com.oracle.team2.dao.MW_Dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;



import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MW_DaoImpl implements MW_Dao_Interface {

	private final SqlSession session;	

}// class
