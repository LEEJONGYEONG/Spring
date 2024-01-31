package com.oracle.oBootHello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.oBootHello.domain.Emp;

@Controller
public class HelloController {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class); // 로그 메시지를 출력

	// Prefix -> templates      ==   템플릿 파일들이 "templates" 디렉토리에 저장되어있음
	// suffix -> .html      ==     템플릿 파일들의 확장자가 ".html"
	@RequestMapping("hello")
	public String hello(Model model) {
		System.out.println("hello start...");
		logger.info("start..."); 		// Logger 객체를 사용하여 "start..." 문자열을 info 레벨로 로그에 기록
		model.addAttribute("parameter", "boot start...");			// Model 객체에 "parameter"라는 이름으로 "boot start..."라는 문자열 속성을 추가합니다. 이렇게 모델에 속성을 추가하면 해당 데이터가 뷰에 전달
		// D/S --> templates / + hello + .html
		return "hello";			 //  "hello"라는 이름의 뷰를 보여줌
	}
	
	@ResponseBody    //    해당 메서드가 반환하는 값을 HTTP 응답 본문에 직접 쓰도록 지정
	@GetMapping("ajaxString") // HTTP GET 요청을 "/ajaxString" 경로에 매핑  |  "/ajaxString" 경로로 들어오는 GET 요청을 처리
	public String ajaxString(@RequestParam("ajaxName")String aName) { // HTTP 요청에서 "ajaxName"이라는 파라미터 값을 받아들임
		System.out.println("HelloController ajaxString aName->" + aName); // 서버 측 로그에 요청에 전달된 값이 기록
		return aName;
	}
	
	@ResponseBody
	@GetMapping("ajaxEmp")
	public Emp ajaxEmp(@RequestParam("empno") String empno, @RequestParam("ename") String ename) {
		System.out.println("HelloController ajaxEmp empno->" + empno);
		logger.info("ename -> { }", ename);
		Emp emp = new Emp();
		emp.setEmpno(empno);
		emp.setEname(ename);
		
		return emp;
	}

}
