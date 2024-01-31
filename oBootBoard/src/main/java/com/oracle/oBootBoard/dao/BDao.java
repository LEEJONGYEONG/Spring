package com.oracle.oBootBoard.dao;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.oracle.oBootBoard.dto.BDto;

public interface BDao {
	
	public ArrayList<BDto> boardList();
	
	public void write(String bName, String bTitle, String bContent);
	
	public void bContentCmd(Model model);

}
