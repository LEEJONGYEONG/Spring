package com.oracle.team2.service.YS_Service;



import org.springframework.stereotype.Service;


import com.oracle.team2.dao.YS_Dao.YS_Dao_Interface;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class YS_ServiceImpl implements YS_Service_Interface {
	private final YS_Dao_Interface ysd;
	


}
