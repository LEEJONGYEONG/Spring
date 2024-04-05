package com.oracle.team2.service.JY_Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oracle.team2.dao.DY_Dao.DY_Dao_Interface;
import com.oracle.team2.dao.JY_Dao.JY_Dao_Interface;
import com.oracle.team2.model.StFile;
import com.oracle.team2.model.Student;
import com.oracle.team2.model.Study;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JY_ServiceImpl implements JY_Service_Interface {

	private final JY_Dao_Interface jyd;

	@Override
	public int condTotalStudy(Study study) {
		int totalStudyCount = 0;
		System.out.println("JY_ServiceImpl condTotalStudy Start...");
		totalStudyCount = jyd.condTotalStudy(study);
		System.out.println("JY_ServiceImpl condTotalStudy totalStudyCount -> " + totalStudyCount);
		
		return totalStudyCount;
	}

	@Override
	public List<Study> studyGroupAppSearch(Study study) {
		List<Study> searchStudyGroupApp = null;
		System.out.println("JY_ServiceImpl studyGroupAppSearch Start...");
		searchStudyGroupApp = jyd.studyGroupAppSearch(study);
		System.out.println("JY_ServiceImpl studyGroupAppSearch searchStudyGroupApp.size() -> " + searchStudyGroupApp.size());
		
		return searchStudyGroupApp;
	}

	@Override
	public int totalStFile(StFile stFile) {
		int totalStFileCnt = 0;
		System.out.println("JY_ServiceImpl totalStFile Start");
		totalStFileCnt = jyd.totalStFile(stFile);
		System.out.println("JY_ServiceImpl totalStFile totalStFileCnt -> " + totalStFileCnt);
		
		return totalStFileCnt;
	}

	@Override
	public List<StFile> stFileList(StFile stFile) {
		List<StFile> listStFile = null;
		System.out.println("JY_ServiceImpl stFileList Start");
		listStFile = jyd.stFileList(stFile);
		System.out.println("JY_ServiceImpl listStFile.size() -> " + listStFile.size());
		
		return listStFile;
	}

	@Override
	public int stFileInsert(StFile stFile) {
		System.out.println("JY_ServiceImpl stFileInsert start...");
		int insertStFile = 0;
		insertStFile = jyd.stFileInsert(stFile);
		
		return insertStFile;
	}

	@Override
	public StFile stFileDetail(int stfile_key) {
		System.out.println("JY_ServiceImpl stFileDetail start...");
		StFile detailStFile = null;
		detailStFile = jyd.stFileDetail(stfile_key);
		
		return detailStFile;
	}

	@Override
	public int stFileDelete(int stfile_key) {
		System.out.println("JY_ServiceImpl stFileDelete start...");
		int deleteStFile = 0;
		deleteStFile = jyd.stFileDelete(stfile_key);
		
		return deleteStFile;
	}

	@Override
	public int stFileUpdate(StFile stFile) {
		System.out.println("JY_ServiceImpl stFileUpdate start...");
		int updateStFile = 0;
		updateStFile = jyd.stFileUpdate(stFile);
		
		return updateStFile;
	}

	@Override
	public int stFileApp(Student student) {
		System.out.println("JY_ServiceImpl stFileApp start...");
		int appStFile = 0;
		appStFile = jyd.stFileApp(student);
		
		return appStFile;
	}

	@Override
	public boolean searchMyApp(Student student) {
		System.out.println("JY_ServiceImpl searchMyApp start...");
		boolean myAppSearch = false;
		myAppSearch = jyd.searchMyApp(student);
		
		return myAppSearch;
	}
	
} // class
