package com.oracle.team2.model;

import java.util.Date;

import lombok.Data;

@Data // 구매이력
public class Payment {
	private int game_key; // 게임콘텐츠 일련번호(PK)(FK)
	private int member_key; // 회원일련번호(PK)(FK)
	private String payment_mname; // 구매자
	private Date payment_date; // 구매일자
	private int payment_price; // 결제금액
	private String payment_gname; // 구매상품명
	private int payment_method; // 결제방법 (카카오페이 0 / 계좌이체 1 / 무통장입금 2) 
	private String payment_mtel; // 연락처
	private String payment_payer; // 입금자명




}
