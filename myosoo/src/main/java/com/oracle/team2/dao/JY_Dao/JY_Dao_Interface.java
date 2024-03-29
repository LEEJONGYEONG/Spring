package com.oracle.team2.dao.JY_Dao;

import java.util.List;

import com.oracle.team2.model.StFile;
import com.oracle.team2.model.Study;

public interface JY_Dao_Interface {

	int totalStudy();

	List<Study> studyGroupAppList(Study study);

	int condTotalEmp(Study study);

	List<Study> studyGroupAppSearch(Study study);

	int totalStFile();

	List<StFile> stFileList(StFile stFile);
	
}
