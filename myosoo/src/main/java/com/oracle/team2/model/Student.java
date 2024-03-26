package com.oracle.team2.model;

import java.util.Date;

import lombok.Data;

@Data // 그룹 가입학생
public class Student {
	private int study_key; // 학습그룹 일련번호(PK)(FK)
	private int member_key; // 회원일련번호(PK)(FK)
	private int student_level; // 학습레벨
	private Date student_date; // 승인요청일자
	private int student_confirm; // 승인여부 (미승인 0 / 승인 1)
	
}
