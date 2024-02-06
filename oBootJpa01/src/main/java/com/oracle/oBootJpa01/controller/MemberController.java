package com.oracle.oBootJpa01.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.oracle.oBootJpa01.domain.Member;
import com.oracle.oBootJpa01.service.MemberService;

@Controller // 스프링 프레임워크에게 해당 클래스가 컨트롤러임을 나타냄
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class); // 컨트롤러에서 로깅을 위해 SLF4J(LoggerFactory)를 사용
																															 //  MemberController 클래스에 대한 Logger를 정적으로 선언
	private final MemberService memberService; // MemberService를 주입받기 위한 필드를 선언
																   // 이 필드는 MemberController 클래스 내에서 사용될 것 
	
	@Autowired // 생성자를 통한 의존성 주입을 수행합니다. MemberService 타입의 빈을 주입받음
	public MemberController(MemberService memberService) {
		this.memberService = memberService; // MemberController의 생성자를 정의
															   // 이 생성자는 MemberService를 주입받아서 멤버 변수인 memberService에 할당
															   // 이를 통해 MemberService의 메서드를 사용하여 비즈니스 로직을 처리
	}
	
	@GetMapping(value = "/members/new")
	public String createForm() {
		System.out.println("MemberController /member/new start...");
		
		return "members/createMemberForm";
	}
	
	@PostMapping(value = "members/save")
	public String memberSave(Member member) {
		System.out.println("MemberController memberSave start...");
		System.out.println("member.getId()->" + member.getId());
		System.out.println("member.getName()->" + member.getName());
		memberService.memberSave(member);
		System.out.println("MemberController memberSave After...");
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/members") // 이 어노테이션은 GET HTTP 요청을 처리하는 핸들러 메서드임을 나타냄. "/members" 경로로 들어오는 GET 요청을 처리
	public String listMember (Model model) {
		List<Member> memberList = memberService.getListAllMember(); // MemberService의 getListAllMember 메서드를 호출하여 모든 Member 엔터티의 목록을 가져옴. 이 목록은 List<Member> 타입의 memberList에 저장
		logger.info("memberList.size() -> {}.", memberList.size()); // 로그 메시지를 생성하여 memberList의 크기를 출력
		model.addAttribute("members", memberList); // Model 객체에 "members"라는 이름으로 memberList를 추가. 이렇게 함으로써 뷰에서 해당 목록에 접근가능
		
		return "members/memberList";
	}
	
	@PostMapping(value = "members/search") // 이 어노테이션은 POST HTTP 요청을 처리하는 핸들러 메서드임을 나타냄. "/members/search" 경로로 들어오는 POST 요청을 처리
	public String memberSearch(Member member, Model model) {
		System.out.println("member/search member.getName() ->" + member.getName());
		List<Member> memberList = memberService.getListSearchMember(member.getName());
		System.out.println("/members/search memberList.size() ->" + memberList.size());
		model.addAttribute("members", memberList);
		
		return "members/memberList";
	}
	
}
