package com.oracle.team2.model;

import lombok.Data;

@Data // 학습자료
public class StFile {
	private int stfile_key; // 학습자료 일련번호(PK)
	private int member_key; // 회원일련번호(FK)
	private int stfile_makey; // 자료구분 대분류
	private int stfile_mikey; // 자료구분 소분류
	private String stfile_method; // 자료유형
	private String stfile_addr; // 자료파일주소
	private int stfilesv_makey; // 서비스구분 대분류
	private int stfilesv_mikey; // 서비스구분 소분류
	private String stfile_content; // 자료내용
	private String stfile_img; // 썸네일

	
}
