package com.oracle.oBootBoard.command;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.oracle.oBootBoard.dao.BDao;
import com.oracle.oBootBoard.dao.JdbcDao;
import com.oracle.oBootBoard.dto.BDto;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class BExecuteCommand {
	
	private final BDao jdbcDao;
	
	public BExecuteCommand (BDao jdbcDao) {
		this.jdbcDao = jdbcDao;
	}
	
	public void bListCmd (Model model) {
		// Dao 연결
		ArrayList<BDto> boardDtoList = jdbcDao.boardList();
		System.out.println("BListCommand boardList.size() ->" + boardDtoList.size());
		model.addAttribute("boardList", boardDtoList);
	}

	public void bWriteCmd(Model model) {
//		  1)  model이용 , map 선언
		Map<String, Object> map = model.asMap();
		
//		  2) request 이용 ->  bName  ,bTitle  , bContent  추출
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bName = request.getParameter("bName");
		String bTitle= request.getParameter("bTitle");
		String bContent= request.getParameter("bContent");
		
//		  3) dao  instance 선언
//		  4) write method 이용하여 저장(bName, bTitle, bContent)
		JdbcDao.write(bName, bTitle, bContent);
		

		
	}

	public void bContentCmd(Model model) {
		// 1. model 이를 Map으로 전환
		// 2. request -> bId get
		// 3. HW3
		BDto board = jdbcDao.contentView(bId);
		
		model.addAttribute("mvc_board", board);
		
	}

}
