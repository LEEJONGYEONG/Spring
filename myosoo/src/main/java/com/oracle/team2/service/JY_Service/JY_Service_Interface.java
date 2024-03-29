package com.oracle.team2.service.JY_Service;

import java.util.List;

import com.oracle.team2.model.StFile;
import com.oracle.team2.model.Study;

public interface JY_Service_Interface {

	int totalStudy();

	List<Study> studyGroupAppList(Study study);

	int condTotalStudy(Study study);

	List<Study> studyGroupAppSearch(Study study);

	int totalStFile();

	List<StFile> stFileList(StFile stFile);

}
