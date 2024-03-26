package com.oracle.team2.model;

import java.util.Date;

import lombok.Data;

@Data // 배포이력
public class Deployment {
	private int deployment_key; // 배포 일련번호(PK)
	private int study_key; // 학습그룹 일련번호(FK)
	private int member_key; // 회원일련번호(FK)
	private int homework_key; // 숙제 일련번호(FK)
	private String deployment_name; // 제출자
	private String deployment_content; // 제출내용
	private String deployment_addcontent; // 추가질의내용
	private Date deployment_date; // 제출일자
	private String deployment_grade; // 평가
	
}
