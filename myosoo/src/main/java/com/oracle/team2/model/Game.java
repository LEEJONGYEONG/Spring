package com.oracle.team2.model;

import lombok.Data;

@Data // 게임콘텐츠
public class Game {
	private int game_key; // 게임콘텐츠 일련번호(PK)
	private int member_key; // 회원일련번호(FK)
	private String game_name; // 게임콘텐츠명
	private int game_maxlevel; // 최대레벨
	private int game_submonth; // 구독개월
	private String game_subdate; // 구독기간
	private int game_subpercount; // 구독가능인원
	private int game_regularprice; // 정가
	private int game_discount; // 할인율
	private int game_price; // 판매가
	private String game_package; // 패키지내용
	private String game_img; // 썸네일



	
}
