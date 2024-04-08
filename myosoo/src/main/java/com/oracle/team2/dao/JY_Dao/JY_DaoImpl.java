package com.oracle.team2.dao.JY_Dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.team2.model.StFile;
import com.oracle.team2.model.Student;
import com.oracle.team2.model.Study;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JY_DaoImpl implements JY_Dao_Interface {

	private final SqlSession session;

	@Override
	public int condTotalStudy(Study study) {
		int totalStudyCount = 0;
		System.out.println("JY_DaoImpl condTotalStudy Start...");
		System.out.println("JY_DaoImpl Start study -> " + study);
		try {
			totalStudyCount = session.selectOne("jyCondTotalStudy", study);
			System.out.println("JY_DaoImpl condTotalStudy totalStudyCount -> " + totalStudyCount);
		} catch (Exception e) {
			System.out.println("JY_DaoImpl condTotalStudy Exception -> " + e.getMessage());
		}
		
		return totalStudyCount;
	}

	@Override
	public List<Study> studyGroupAppSearch(Study study) {
		List<Study> searchStudyGroupApp = null;
		System.out.println("JY_DaoImpl studyGroupAppSearch Start...");
		System.out.println("JY_DaoImpl studyGroupAppSearch study -> " + study);
		try {
			searchStudyGroupApp = session.selectList("jyStudyGroupAppSearch", study);
		} catch (Exception e) {
			System.out.println("JY_DaoImpl studyGroupAppSearch Exception -> " + e.getMessage());
		}
		
		return searchStudyGroupApp;
	}

	@Override
	public int totalStFile(StFile stFile) {
		int totalStFileCnt = 0;
		System.out.println("JY_DaoImpl totalStFile Start");
		
		try {
			totalStFileCnt = session.selectOne("jyTotalStFile", stFile);
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
		if (stFile.getKeyword() == null) stFile.setKeyword("");
		
		try {
			listStFile = session.selectList("jyStFileList", stFile);
			System.out.println("JY_DaoImpl listStFile.size() -> " + listStFile.size());
		} catch (Exception e) {
			System.out.println("JY_DaoImpl stFileList Exception -> " + e.getMessage());
		}
		
		return listStFile;
	}

	@Override
	public int stFileInsert(StFile stFile) {
		int insertStFile = 0;
		System.out.println("JY_DaoImpl stFileInsert start...");
		try {
			insertStFile = session.insert("jyStFileInsert", stFile);
		} catch (Exception e) {
			System.out.println("JY_DaoImpl stFileInsert Exception ->" + e.getMessage());
		}
		
		return insertStFile;
	}

	@Override
	public StFile stFileDetail(int stfile_key) {
		System.out.println("JY_DaoImpl stFileDetail start...");
		StFile detailStFile = new StFile();
		
		try {
			detailStFile = session.selectOne("jyStFileDetail", stfile_key);
		} catch (Exception e) {
			System.out.println("JY_DaoImpl stFileDetail Exception -> " + e.getMessage());
		}
		
		return detailStFile;
	}

	@Override
	public int stFileDelete(int stfile_key) {
		System.out.println("JY_DaoImpl stFileDelete start...");
		int deleteStFile = 0;
		
		try {
			deleteStFile = session.delete("jyStFileDelete", stfile_key);
		} catch (Exception e) {
			System.out.println("JY_DaoImpl stFileDelete Exception -> " + e.getMessage());
		}
		
		return deleteStFile;
	}

	@Override
	public int stFileUpdate(StFile stFile) {
		System.out.println("JY_DaoImpl stFileUpdate start...");
		int updateStFile = 0;
		
		try {
			updateStFile = session.update("jyStFileUpdate", stFile);
		} catch (Exception e) {
			System.out.println("JY_DaoImpl stFileUpdate Exception -> " + e.getMessage());
		}
		
		return updateStFile;
	}

	@Override
	public int studyGroupApp(Student student) {
		System.out.println("JY_DaoImpl studyGroupApp start...");
		int appStudyGroup = 0;
		
		try {
			appStudyGroup = session.insert("jyStudyGroupApp", student);
		
		} catch (Exception e) {
			System.out.println("JY_DaoImpl studyGroupApp Exception -> " + e.getMessage());
		}
		
		return appStudyGroup;
	}

	@Override
	public boolean searchMyApp(Student student) {
		System.out.println("JY_DaoImpl searchMyApp start...");
		boolean myAppSearch = false;
		
		try {
			Student myAppList = session.selectOne("jySearchMyApp", student);
			if (myAppList != null) {
	            myAppSearch = true;
	        }
		} catch (Exception e) {
			System.out.println("JY_DaoImpl searchMyApp Exception -> " + e.getMessage());
		}
		
		return myAppSearch;
	}

	@Override
	public int condTotalStudent(Study study) {
		System.out.println("JY_DaoImpl condTotalStudent start...");
		int studentCondTotal = 0;
		try {
			studentCondTotal = session.selectOne("jyCondTotalStudent", study);
		} catch (Exception e) {
			System.out.println("JY_DaoImpl condTotalStudent Exception -> " + e.getMessage());
		}
		
		return studentCondTotal;
	}

	@Override
	public List<Study> studyJoinApproval(Study study) {
		System.out.println("JY_DaoImpl studyJoinApproval start...");
		List<Study> joinApprovalStudy = null;
		
		try {
			joinApprovalStudy = session.selectList("jyStudyJoinApproval", study);
		} catch (Exception e) {
			System.out.println("JY_DaoImpl studyJoinApproval Exception -> " + e.getMessage());
		}
		
		return joinApprovalStudy;
	}

}// class
