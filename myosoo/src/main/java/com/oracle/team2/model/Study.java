package com.oracle.team2.model;

import java.util.Date;

import lombok.Data;

@Data // 학습그룹
public class Study {
	private int study_key; // 학습그룹 일련번호(PK)
	private int game_key; // 게임콘텐츠 일련번호(FK)
	private int member_key; // 회원일련번호(FK)
	private int study_month; // 학습개월
	private String study_img; // 콘텐츠이미지
	private String study_name; // 그룹명
	private String study_teacher; // 교육자명
	private Date study_date; // 학습기간
	private int study_maxperson; // T/O(정원 수)
	private int study_level; // 달성레벨
	private String study_bigo; // 비고

	
	
	
}
