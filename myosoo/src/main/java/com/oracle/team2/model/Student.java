package com.oracle.team2.model;

import java.util.Date;

import lombok.Data;

@Data // 그룹 가입학생
public class Student {
	private int study_key; // 학습그룹 일련번호(PK)(FK)
	private int member_key; // 회원일련번호(PK)(FK)
	private int student_level; // 학습레벨
	private Date student_leveldate; // 레벨달성일자
	private Date student_date; // 신청일자
	private int student_confirm; // 승인여부 (미승인 0 / 승인 1)
	private Date student_confirmdate; // 승인일자
	private int study_maxperson; // study table : T/O(정원 수)
	private int study_appperson; // study table : 승인된 인원수
	
	private int[] checkboxes;
	private int appPerson;
}
