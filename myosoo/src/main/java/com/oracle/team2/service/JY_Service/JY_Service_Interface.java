package com.oracle.team2.service.JY_Service;

import java.util.List;

import com.oracle.team2.model.StFile;
import com.oracle.team2.model.Student;
import com.oracle.team2.model.Study;

public interface JY_Service_Interface {

	int condTotalStudy(Study study);

	List<Study> studyGroupAppSearch(Study study);

	int totalStFile(StFile stFile);

	List<StFile> stFileList(StFile stFile);

	int stFileInsert(StFile stFile);

	StFile stFileDetail(int stfile_key);

	int stFileDelete(int stfile_key);

	int stFileUpdate(StFile stFile);

	int studyGroupApp(Student student);

	boolean searchMyApp(Student student);

	int condTotalStudent(Study study);

	List<Study> studyJoinApproval(Study study);

}
