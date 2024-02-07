package com.oracle.oBootJpaApi01.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.oBootJpaApi01.domain.Member;
import com.oracle.oBootJpaApi01.repository.JpaMemberRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 지정된 속성에 생성자를 만듦
@Transactional // 서비스단위로 무결성을 체크하기위해
public class MemberService {
	
	private final JpaMemberRepository memberRepository;

	public List<Member> getListAllMember() {
		List<Member> listMember = memberRepository.findAll();
		System.out.println("MemberService getListAllMember listMember.size() - > " + listMember.size());
		
		return listMember;
	}

	public Long saveMember(@Valid Member member) {
		System.out.println("MemberService saveMember member.getName() -> " + member.getName());
		Long id = memberRepository.save(member);
		
		return id;
	}

	public void updateMember(Long id, String name, Long sal) {
		Member member = new Member();
		member.setId(id);
		member.setName(name);
		member.setSal(sal);
		System.out.println("MemberService updateMember member.getName() -> " + member.getName());
		System.out.println("MemberService updateMember member.getSal() -> " + member.getSal());
		memberRepository.updateByMember(member);
		
		return;
	}
	
	public Member findByMember(Long memberId) {
		Member member = memberRepository.findByMember(memberId);
		System.out.println("MemberService findByMember member.get().getId() -> " + member.getId());
		System.out.println("MemberService findByMember member.get().getName() -> " + member.getName());
		
		return member;
	}
	
}
