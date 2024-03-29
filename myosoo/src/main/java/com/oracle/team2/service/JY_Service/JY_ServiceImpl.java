package com.oracle.team2.service.JY_Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oracle.team2.dao.DY_Dao.DY_Dao_Interface;
import com.oracle.team2.dao.JY_Dao.JY_Dao_Interface;
import com.oracle.team2.model.StFile;
import com.oracle.team2.model.Study;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JY_ServiceImpl implements JY_Service_Interface {

	private final JY_Dao_Interface jyd;

	@Override
	public int totalStudy() {
		System.out.println("JY_ServiceImpl totalStudy Start");
		int totalStudyCnt = jyd.totalStudy();
		System.out.println("JY_ServiceImpl totalStudy totalStudyCnt -> " + totalStudyCnt);
		
		return totalStudyCnt;
	}

	@Override
	public List<Study> studyGroupAppList(Study study) {
		List<Study> listStudyGroupApp = null;
		System.out.println("JY_ServiceImpl listStudyGroupApp Start");
		listStudyGroupApp = jyd.studyGroupAppList(study);
		System.out.println("JY_ServiceImpl listStudyGroupApp.size() -> " + listStudyGroupApp.size());
		
		return listStudyGroupApp;
	}

	@Override
	public int condTotalStudy(Study study) {
		int totalStudyCount = 0;
		System.out.println("JY_ServiceImpl condTotalEmp Start...");
		totalStudyCount = jyd.condTotalEmp(study);
		System.out.println("JY_ServiceImpl condTotalEmp totalStudyCount -> " + totalStudyCount);
		
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
	public int totalStFile() {
		System.out.println("JY_ServiceImpl totalStFile Start");
		int totalStFileCnt = jyd.totalStFile();
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
	
} // class
