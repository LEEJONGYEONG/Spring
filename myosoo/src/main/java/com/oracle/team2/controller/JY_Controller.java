package com.oracle.team2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.team2.model.StFile;
import com.oracle.team2.model.Study;
import com.oracle.team2.service.JY_Service.JY_Paging;
import com.oracle.team2.service.JY_Service.JY_Service_Interface;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class JY_Controller {
	private final JY_Service_Interface  jys;
	private final CommonController cc;
	
	@RequestMapping(value = "stFileInsertView")
	public String stFileInsert() {
		
		return "JY_views/stFile";
	}
	
	@RequestMapping(value = "stFileListView")
	public String stFileList(StFile stFile, Model model) {
		System.out.println("JY_Controller stFileList Start...");
		
		int totalStFile = jys.totalStFile();
		System.out.println("JY_Controller Start totalStFile -> " + totalStFile);
		
		JY_Paging page = new JY_Paging(totalStFile, stFile.getCurrentPage());
		stFile.setStart(page.getStart());
		stFile.setEnd(page.getEnd());
				
		List<StFile> listStFile = jys.stFileList(stFile);
		System.out.println("JY_Controller listStFile.size() -> " + listStFile.size());
		
		model.addAttribute("totalStFile", totalStFile);
		model.addAttribute("listStFile", listStFile);
		model.addAttribute("page", page);
		
		return "JY_views/stFileList";
	}
	
	@RequestMapping(value = "stFileDetailView")
	public String stFileDetail() {
		
		return "JY_views/stFileDetail";
	}
	
	@RequestMapping(value = "studyGroupApplication")
	public String studyGroupAppList(Study study, Model model) {
		System.out.println("JY_Controller studyGroupAppList Start...");
		
		int totalStudy = jys.totalStudy();
		System.out.println("JY_Controller Start totalStudy -> " + totalStudy);
		
		JY_Paging page = new JY_Paging(totalStudy, study.getCurrentPage());
		study.setStart(page.getStart());
		study.setEnd(page.getEnd());
				
		List<Study> listStudyGroupApp = jys.studyGroupAppList(study);
		System.out.println("JY_Controller listDtudyGroupApp.size() -> " + listStudyGroupApp.size());
		
		model.addAttribute("totalStudy", totalStudy);
		model.addAttribute("listStudyGroupApp", listStudyGroupApp);
		model.addAttribute("page", page);
		
		return "JY_views/studyGroupApplication";
	}
	
	@RequestMapping(value = "studyGroupAppSearch")
	public String studyGroupNameSearch(Study study, Model model) {
		System.out.println("JY_Controller studyGroupNameSearch Start...");
		
		int totalStudy = jys.condTotalStudy(study);
		System.out.println("JY_Controller Start totalStudy -> " + totalStudy);
		
		JY_Paging page = new JY_Paging(totalStudy, study.getCurrentPage());
		study.setStart(page.getStart());
		study.setEnd(page.getEnd());
				
		List<Study> searchStudyGroupApp = jys.studyGroupAppSearch(study);
		System.out.println("JY_Controller searchStudyGroupApp.size() -> " + searchStudyGroupApp.size());
		
		model.addAttribute("totalStudy", totalStudy);
		model.addAttribute("listStudyGroupApp", searchStudyGroupApp);
		model.addAttribute("page", page);
		
		return "JY_views/studyGroupApplication";
	}
} // class
