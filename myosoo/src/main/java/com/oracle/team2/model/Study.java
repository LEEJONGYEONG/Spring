package com.oracle.team2.model;

import java.util.Date;

import lombok.Data;

@Data // 학습그룹
public class Study {
	private int study_key; // 학습그룹 일련번호(PK)
	private int game_key; // 게임콘텐츠 일련번호(FK)
	private int member_key; // 교육자회원일련번호(FK)
	private int study_month; // 학습개월
	private String study_name; // 그룹명
	private Date study_startdate; // 학습시작일자
	private Date study_enddate; // 학습종료일자
	private int study_maxperson; // T/O(정원 수)
	private int study_maxlevel; // 최대레벨
	private String study_bigo; // 비고
	private String member_name; // member table : 학생이름
	private String member_tel; // member table : 휴대폰번호
	private String game_name; // game table : 게임콘텐츠명
	private Date student_date; // student table : 신청일자
	private int student_confirm; // student table : 승인여부 (미승인 0 / 승인 1)
	
	// 조회용
	private String search;
	private String keyword1;
	private String keyword2;
	private int      condition;

	private String pageNum;
	private int start;
	private int end;
		
	// Page 정보
	private String currentPage;

	
	
	
}
