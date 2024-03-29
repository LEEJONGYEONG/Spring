package com.oracle.team2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.team2.model.Member;
import com.oracle.team2.service.JM_Service.JM_Service_Interface;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class JM_Controller {
	private final JM_Service_Interface  jms;
	private final CommonController cc;
	
	@RequestMapping(value = "loginViews")
	public String login() {
		return "JM_views/login";
	}
	
	@PostMapping("/login") // AJAX 요청을 처리하는 메소드에는 @PostMapping 어노테이션을 사용합니다.
    @ResponseBody // AJAX 요청에 대한 응답을 직접 작성하기 위해 @ResponseBody 어노테이션을 사용합니다.
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
    		Member member, HttpServletRequest request) {
		System.out.println("로그인 컨트롤러 시작...");
        // 여기에는 로그인 처리 로직을 추가합니다.
        // 예를 들어, 입력된 username과 password를 확인하여 로그인 성공/실패 여부를 결정합니다.
		// String id = username;
		// String pw = password;
		// System.out.println("아이디: "+id+", 패스워드: "+pw);
		member = null;
		
		member = jms.login(username, password);
		
        // 임시적으로 로그인 성공 여부에 따라 응답을 반환하는 예시입니다.
        if (member != null && member.getMember_id().equals(username) && member.getMember_pw().equals(password)) {
        	HttpSession session =  request.getSession();
        	System.out.println("이거 실행되긴하나??");
        	session.setAttribute("member_key", member.getMember_key());
        	session.setAttribute("member_name", member.getMember_name());
        	session.setAttribute("member_email", member.getMember_email());
        	session.setAttribute("member_id", member.getMember_id());
        	session.setAttribute("member_tel", member.getMember_tel());
        	session.setAttribute("member_makey", member.getMember_makey());
        	session.setAttribute("member_mikey", member.getMember_mikey());
        	System.out.println("세션정보 저장되나???"+session.getAttribute("userSession"));
        	 session.setMaxInactiveInterval(60 * 30);
        	 //model.addAttribute("userSession", member); // 세션 정보를 Model에 추가

            return "success"; // 로그인 성공 시 'success' 문자열을 반환합니다.
        } else {
        	System.out.println("로그인 실패!");
            return "failure"; // 로그인 실패 시 'failure' 문자열을 반환합니다.
        }
    }
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		session.invalidate();
		return "index";
		
	}
	
}
