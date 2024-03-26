package com.oracle.team2.model;

import java.util.Date;

import lombok.Data;

@Data // 숙제
public class Homework {
	private int homework_key; // 숙제 일련번호(PK)
	private int study_key; // 학습그룹 일련번호(FK)
	private String homework_gname; // 게임콘텐츠
	private String homework_teacher; // 교육자
	private String homework_name; // 숙제명
	private String homework_content; // 숙제내용
	private int homework_level; // 학습레벨
	private Date homework_date; // 제출기한

}
