package com.oracle.team2.dao.YS_Dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;




import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class YS_DaoImpl implements YS_Dao_Interface {

	private final SqlSession session;

	

}// class
