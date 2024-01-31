package com.oracle.oBootDBConnect;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.oracle.oBootDBConnect.repository.JdbcMemberRepository;
import com.oracle.oBootDBConnect.repository.MemberRepository;
import com.oracle.oBootDBConnect.repository.MemoryMemberRepository;

@Configuration
public class SpringConfig {
	
	private final DataSource dataSource;
	public SpringConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Bean  // Component되지 않아 등록이 안되어서 데이터를 등록해주기 위해 Bean 설정
	public MemberRepository memberRepository() {
		return new JdbcMemberRepository(dataSource);  // 데이터베이스에 저장된 값을 가져옴
		// return new MemoryMemberRepository(dataSource);  // 메모리에 저장된 값을 가져옴
	}

}
