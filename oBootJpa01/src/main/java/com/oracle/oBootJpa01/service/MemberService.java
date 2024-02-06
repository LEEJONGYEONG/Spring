package com.oracle.oBootJpa01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.oBootJpa01.domain.Member;
import com.oracle.oBootJpa01.repository.MemberRepository;

@Service // 스프링 프레임워크에게 해당 클래스가 서비스 빈임을 나타냄. 즉, 이 클래스가 스프링의 컨테이너에 빈으로 등록
@Transactional // 이 어노테이션은 메서드 또는 클래스에 사용될 수 있으며, 트랜잭션 관리를 자동화
					  // 해당 클래스 내의 모든 메서드가 트랜잭션으로 묶이게 됨
					  // 이는 메서드가 실행될 때 트랜잭션이 시작되고, 메서드가 정상적으로 완료되면 트랜잭션이 커밋되며, 예외가 발생하면 롤백
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	// 회원가입
	public Long memberSave (Member member) {
		System.out.println("MemberService memberSave member-->" + member);
		memberRepository.memberSave(member);
		System.out.println("MemberService memberSave After...");
		
		return member.getId();
	}
	
	public List<Member> getListAllMember() {
		List<Member> listMember = memberRepository.findAllMember();
		System.out.println("MemberService getListAllMember listMember.size() ->" + listMember.size());
		
		return listMember;
	}

	public List<Member> getListSearchMember(String searchName) {
		System.out.println("MemberService getListSearchMember start...");
		System.out.println("MemberService getListSearchMember searchName -> " + searchName);
		List<Member> listMember = memberRepository.findByNames(searchName);
		System.out.println("MemberService getListSearchMember listMember.size() -> " + listMember.size());
		
		return listMember;
	}

}
