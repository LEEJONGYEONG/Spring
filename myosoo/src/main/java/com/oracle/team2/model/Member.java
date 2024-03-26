package com.oracle.team2.model;

import java.util.Date;

import lombok.Data;

@Data // 회원
public class Member {
	private int member_key; //회원일련번호
	private String member_name; //이름
	private String member_email; //이메일주소
	private String member_id; //아이디
	private String member_pw; //패스워드
	private String member_birth; //생년월일
	private String member_mtel; //휴대폰번호
	private int makey; //회원구분대분류
	private int mikey; //회원구분소분류
	private String member_gender; //성별
	private String member_tel; //전화번호
	private String member_is; //수신동의구분
	private Date member_regdate; //가입일자
	private int member_isfree; //자격(무료 0/ 무료 1)
}
