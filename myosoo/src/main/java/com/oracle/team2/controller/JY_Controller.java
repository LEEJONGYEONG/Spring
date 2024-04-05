package com.oracle.team2.controller;


import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.oracle.team2.model.StFile;
import com.oracle.team2.model.Student;
import com.oracle.team2.model.Study;
import com.oracle.team2.service.JY_Service.JY_Paging;
import com.oracle.team2.service.JY_Service.JY_Service_Interface;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class JY_Controller {
	private final JY_Service_Interface  jys;
	private final CommonController cc;
	
	@RequestMapping(value = "stFileInsertView")
	public String stFileInsertForm() {
		
		return "JY_views/stFile";
	}
	
	@PostMapping(value = "stFileInsert")
	public String stFileInsert(StFile stFile, Model model, HttpSession session, 
	        @RequestParam(value = "file") MultipartFile file) {    
	    System.out.println("JY_Controller stFileInsert start...");
	    try {
	        // 파일 업로드 처리
	        if (!file.isEmpty()) {
	            byte[] thumbnail = file.getBytes(); // 업로드된 파일을 바이트 배열로 변환
	            stFile.setStfile_img(thumbnail); // 썸네일 데이터 설정
	        }
	        
	        int member_key = (int) session.getAttribute("member_key");
	        stFile.setMember_key(member_key);
	        System.out.println("JY_Controller stFileInsert stFile -> " + stFile);
	        
	        int insertStFile = jys.stFileInsert(stFile);
	        if (insertStFile < 0) {
	        	model.addAttribute("msg", "등록실패 다시 확인해주세요");            
	        } 
	    } catch (Exception e) {
	        // 예외 발생 시 처리
	        System.out.println("JY_Controller stFileInsert Exception -> " + e.getMessage());
	    }
	    
	    return "forward:stFileInsertView";
	}
	
	@RequestMapping(value = "stFileListView")
	public String stFileList(StFile stFile, Model model) {
		System.out.println("JY_Controller stFileList Start...");
		
		int totalStFile = jys.totalStFile(stFile);
		System.out.println("JY_Controller Start totalStFile -> " + totalStFile);
		
		JY_Paging page = new JY_Paging(totalStFile, stFile.getCurrentPage());
		stFile.setStart(page.getStart());
		stFile.setEnd(page.getEnd());
				
		List<StFile> listStFile = jys.stFileList(stFile);
		System.out.println("JY_Controller listStFile.size() -> " + listStFile.size());
		
		// 이미지를 Base64로 인코딩하여 모델에 추가
	    for (StFile stfile : listStFile) {
	        byte[] imgBytes = stfile.getStfile_img();
	        if (imgBytes != null) {
	            String imgBase64 = Base64.getEncoder().encodeToString(imgBytes);
	            stfile.setStfile_imgEncod(imgBase64);
	        }
	    }
		
		model.addAttribute("totalStFile", totalStFile);
		model.addAttribute("listStFile", listStFile);
		model.addAttribute("stFile", stFile);
		model.addAttribute("page", page);
		
		return "JY_views/stFileList";
	}
	
	@GetMapping(value = "stFileDetailView")
	public String stFileDetail(StFile stFile, Model model) {
		System.out.println("JY_Controller stFileDetail start...");
		System.out.println("JY_Controller stFileDetail stFile -> " + stFile);
		StFile detailStFile = jys.stFileDetail(stFile.getStfile_key());
		
		if (detailStFile != null) {
	        byte[] imgBytes = detailStFile.getStfile_img();
	        if (imgBytes != null) {
	            String imgBase64 = Base64.getEncoder().encodeToString(imgBytes);
	            detailStFile.setStfile_imgEncod(imgBase64);
	        }
	    }
		
		model.addAttribute("detailStFile", detailStFile);
		
		return "JY_views/stFileDetail";
	}
	
	@RequestMapping(value = "stFileDelete")
	public String stFileDelete(StFile stFile) {
		System.out.println("JY_Controller stFileDelete start...");
		int deleteStFile = jys.stFileDelete(stFile.getStfile_key());
		
		return "redirect:stFileListView";
	}
	
	@GetMapping(value = "stFileUpdateForm")
	public String stFileUpdateForm(StFile stFile, Model model) {
		System.out.println("JY_Controller stFileUpdateForm start...");
		System.out.println("JY_Controller stFileUpdateForm stFile -> " + stFile);
		StFile updateFormStFile = jys.stFileDetail(stFile.getStfile_key());
		
		model.addAttribute("updateFormStFile", updateFormStFile);
		
		return "JY_views/stFileUpdate";
	}
	
	@PostMapping(value = "stFileUpdate")
	public String stFileUpdate(StFile stFile, Model model, HttpSession session, 
	        @RequestParam(value = "file") MultipartFile file) {
		System.out.println("JY_Controller stFileUpdate start...");
		try {
	        // 파일 업로드 처리
	        if (!file.isEmpty()) {
	            byte[] thumbnail = file.getBytes(); // 업로드된 파일을 바이트 배열로 변환
	            stFile.setStfile_img(thumbnail); // 썸네일 데이터 설정
	        }
	        System.out.println("JY_Controller stFileUpdate stFile -> " + stFile);
	        int updateStFile = jys.stFileUpdate(stFile);
	        if (updateStFile < 0) {
	        	model.addAttribute("msg", "등록실패 다시 확인해주세요");            
	        }
	    } catch (Exception e) {
	        // 예외 발생 시 처리
	        System.out.println("JY_Controller stFileInsert Exception -> " + e.getMessage());
	    }
		
		return "forward:stFileListView";
	}
	
	@RequestMapping(value = "studyGroupAppSearch")
	public String studyGroupNameSearch(Study study, Model model) {
		System.out.println("JY_Controller studyGroupNameSearch Start...");
		System.out.println("JY_Controller Start study -> " + study);
	    if (study.getKeyword1() == null && study.getKeyword2() == null) {
	    	study.setCondition(0);
	    } else if (study.getKeyword1() != null && study.getKeyword2() == null) {
	    	study.setCondition(1);
	    } else if (study.getKeyword1() == null && study.getKeyword2() != null) {
	    	study.setCondition(2);
		} else {
	    	study.setCondition(3);
		}
		
		int totalStudy = jys.condTotalStudy(study);
		System.out.println("JY_Controller Start totalStudy -> " + totalStudy);
		
		JY_Paging page = new JY_Paging(totalStudy, study.getCurrentPage());
		study.setStart(page.getStart());
		study.setEnd(page.getEnd());
				
		List<Study> searchStudyGroupApp = jys.studyGroupAppSearch(study);
		System.out.println("JY_Controller searchStudyGroupApp.size() -> " + searchStudyGroupApp.size());
		
		model.addAttribute("totalStudy", totalStudy);
		model.addAttribute("listStudyGroupApp", searchStudyGroupApp);
		model.addAttribute("study", study);
		model.addAttribute("page", page);
		
		return "JY_views/studyGroupApplication";
	}
	
	@RequestMapping(value = "stFileApp")
	public String stFileApp(Student student, HttpSession session , Model model) {
		System.out.println("JY_Controller stFileApp start...");

		int member_key = (int) session.getAttribute("member_key");
        student.setMember_key(member_key);
        System.out.println("JY_Controller stFileApp stFile -> " + student);
        
        boolean myAppSearch = jys.searchMyApp(student);
        System.out.println("JY_Controller stFileApp myAppSearch -> " + myAppSearch);
        if (myAppSearch) {
        	String resultMsg = null;
        	model.addAttribute("resultMsg" , resultMsg);
        } else {
        	int appStFile = jys.stFileApp(student);
    		System.out.println("JY_Controller stFileApp appStFile -> " + appStFile);
        }

		return "forward:studyGroupAppSearch";
	}
} // class
