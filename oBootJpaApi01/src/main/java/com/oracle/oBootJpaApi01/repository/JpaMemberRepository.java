package com.oracle.oBootJpaApi01.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oracle.oBootJpaApi01.domain.Member;

import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor // 지정된 속성에 대해 생성자를 만듦
public class JpaMemberRepository implements MemberRepository {
	
	private final EntityManager em;

	@Override
	public List<Member> findAll() {
		List<Member> memberList = em.createQuery("select m from Member m", Member.class).getResultList();
		System.out.println("JpaMemberRepository findAll memberList.size() -> " + memberList.size());
		
		return memberList;
	}

	public Long save(@Valid Member member) {
		System.out.println("JpaMemberRepository save before...");
		em.persist(member);
		
		return member.getId();
	}

}
