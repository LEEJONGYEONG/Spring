package com.oracle.oBootJpa01.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oracle.oBootJpa01.domain.Member;

import jakarta.persistence.EntityManager;

@Repository
public class JpaMemberRepository implements MemberRepository {
	
	// JPA DML --> EntityManager 필수
	private final EntityManager em;
	
	public JpaMemberRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public Member memberSave(Member member) { // public 접근 제한자를 가진, Member 타입의 매개변수를 받고 
																		// Member 타입의 값을 반환하는 memberSave 메서드를 정의
		// 저장 method
		em.persist(member); // EntityManager(em) 객체를 사용하여 주어진 Member 엔터티를 영속화(persist). 
									  // 즉, 데이터베이스에 해당 엔터티를 저장하고 영속성 컨텍스트에 추가
		System.out.println("JpaMemberRepository memberSave member After...");
		return member;
	}

	@Override
	public List<Member> findAllMember() {
		List<Member> memberList = em.createQuery("select m from Member m", Member.class)
				.getResultList(); // EntityManager(em) 객체를 사용하여 JPQL(Java Persistence Query Language) 쿼리를 실행. 
									   // 이 쿼리는 "select m from Member m"으로, 데이터베이스의 모든 Member 엔터티를 조회하는 쿼리입니다. 
									   // 조회된 결과는 Member.class 타입의 List에 저장
		System.out.println("JpaMemberRepository findAllMember memberList.size() ->" + memberList.size());
		return memberList;
	}

	@Override
	public List<Member> findByNames(String searchName) {
		String pname = searchName + '%'; // 입력된 검색어를 기반으로 검색할 이름 패턴을 생성
														  // 여기서는 입력된 이름으로 시작하는 모든 이름을 검색하기 위해 "%"를 추가하여 패턴을 만듦
		System.out.println("JpaMemberRepository findByName pname -> " + pname);
		List<Member> memberList = em.createQuery("select m from Member m where name Like : name", Member.class)
				.setParameter("name", pname)
				.getResultList(); // EntityManager(em) 객체를 사용하여 JPQL(Java Persistence Query Language) 쿼리를 실행
									   // 이 쿼리는 "name Like :name" 조건을 사용하여 Member 엔터티 중에서 이름이 pname 패턴과 일치하는 것을 조회하는 쿼리
									   // pname을 ":name" 파라미터에 바인딩하여 쿼리를 실행하고, 그 결과를 Member.class 타입의 List에 저장
		System.out.println("JpaMemberRepository memberList.size() -> " + memberList.size());
		
		return memberList;
	}

}
