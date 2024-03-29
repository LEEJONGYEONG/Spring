package com.oracle.team2.dao.JY_Dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.team2.model.StFile;
import com.oracle.team2.model.Study;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JY_DaoImpl implements JY_Dao_Interface {

	private final SqlSession session;

	@Override
	public int totalStudy() {
		int totalStudyCnt = 0;
		System.out.println("JY_DaoImpl totalStudy Start");
		
		try {
			totalStudyCnt = session.selectOne("jyTotalStudy");
			System.out.println("JY_DaoImpl totalStudy totalStudyCnt -> " + totalStudyCnt);
		} catch (Exception e) {
			System.out.println("JY_DaoImpl totalStudy Exception -> " + e.getMessage());
		}
		
		return totalStudyCnt;
	}

	@Override
	public List<Study> studyGroupAppList(Study study) {
		List<Study> listStudyGroupApp = null;
		System.out.println("JY_DaoImpl studyGroupAppList Start");
		
		try {
			listStudyGroupApp = session.selectList("jyStudyGroupAppList", study);
			System.out.println("JY_DaoImpl listStudyGroupApp.size() -> " + listStudyGroupApp.size());
		} catch (Exception e) {
			System.out.println("JY_DaoImpl studyGroupAppList Exception -> " + e.getMessage());
		}
		
		return listStudyGroupApp;
	}

	@Override
	public int condTotalEmp(Study study) {
		int totalStudyCount = 0;
		System.out.println("JY_DaoImpl condTotalEmp Start...");
		System.out.println("JY_DaoImpl Start emp -> " + study);
		try {
			totalStudyCount = session.selectOne("jyCondTotalEmp", study);
			System.out.println("JY_DaoImpl condTotalEmp totalStudyCount -> " + totalStudyCount);
		} catch (Exception e) {
			System.out.println("JY_DaoImpl condTotalEmp Exception -> " + e.getMessage());
		}
		
		return totalStudyCount;
	}

	@Override
	public List<Study> studyGroupAppSearch(Study study) {
		List<Study> searchStudyGroupApp = null;
		System.out.println("JY_DaoImpl studyGroupAppSearch Start...");
		System.out.println("JY_DaoImpl studyGroupAppSearch emp -> " + study);
		try {
			searchStudyGroupApp = session.selectList("jyStudyGroupAppSearch", study);
		} catch (Exception e) {
			System.out.println("JY_DaoImpl studyGroupAppSearch Exception -> " + e.getMessage());
		}
		
		return searchStudyGroupApp;
	}

	@Override
	public int totalStFile() {
		int totalStFileCnt = 0;
		System.out.println("JY_DaoImpl totalStFile Start");
		
		try {
			totalStFileCnt = session.selectOne("jyTotalStFile");
			System.out.println("JY_DaoImpl totalStFile totalStFileCnt -> " + totalStFileCnt);
		} catch (Exception e) {
			System.out.println("JY_DaoImpl totalStFile Exception -> " + e.getMessage());
		}
		
		return totalStFileCnt;
	}

	@Override
	public List<StFile> stFileList(StFile stFile) {
		List<StFile> listStFile = null;
		System.out.println("JY_DaoImpl stFileList start...");
		
		try {
			listStFile = session.selectList("jyStFileList", stFile);
			System.out.println("JY_DaoImpl listStFile.size() -> " + listStFile.size());
		} catch (Exception e) {
			System.out.println("JY_DaoImpl stFileList Exception -> " + e.getMessage());
		}
		
		return listStFile;
	}

}// class
