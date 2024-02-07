package com.oracle.oBootJpaApi01.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.oBootJpaApi01.domain.Member;
import com.oracle.oBootJpaApi01.service.MemberService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// Controller + ResponseBody
// 사용목적 --> Ajax + RestApi
@RestController
@RequiredArgsConstructor // 지정된 속성에 생성자를 만듦
@Slf4j // 이를 클래스에 적용하면 해당 클래스에 로그를 작성할 때 사용하는 Logger 객체를 자동으로 생성
public class JpaRestApiController {
	
	private final MemberService memberService;
	
	// postman ---> Body --> raw---> JSON	 
    //  예시    {	    "name" : "kkk222"	    }
	
	@PostMapping("/restApi/v1/memberSave") // v1(구버전) = Bad API (보안 위험)
	// @RequestBody : Json(member)으로 온것을  --> Member member Setting
	public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member) {
		System.out.println("JpaRestApiController /api/v1/memberSave member.getId() -> " + member.getId());
		log.info("member.getName() -> {}.", member.getName());
		log.info("member.getSal() -> {}.", member.getSal());
		
		Long id = memberService.saveMember(member);
		
		return new CreateMemberResponse(id); 
	}
	
	// 목적  : Entity Member member --> 직접 화면이나 API위한 Setting 금지 (보안때문)
	// 예시  : @NotEmpty  -->	@Column(name = "userName")
	@PostMapping("/restApi/v2/memberSave") // v2(신버전) Good API (보안 안전)
	public CreateMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberRequest cMember) {
		System.out.println("JpaRestApiController /api/v2/memberSave member.getId() -> " + cMember.getName());
		log.info("cMember.getName() -> {}.", cMember.getName());
		log.info("cMember.getSal() -> {}.", cMember.getSal());
		Member member = new Member();
		member.setName(cMember.getName());
		member.setSal(cMember.getSal());
		
		Long id = memberService.saveMember(member);
		
		return new CreateMemberResponse(id);
	}
	
	@Data
	static class CreateMemberRequest {
		@NotEmpty
		private String name;
		private Long sal;
	}
	
	@Data
	@RequiredArgsConstructor
	static class CreateMemberResponse {
		private final Long id;
		// public CreateMemberResponse(Long id) {
		// 	this.id = id;
		// }
	}

	// Bad API
	@GetMapping("/restApi/v1/members")
	public List<Member> membersVer1() {
		System.out.println("JpaRestApiController /restApi/v1/members start...");
		List<Member> listMember = memberService.getListAllMember();
		
		return listMember;
	}
	
}
