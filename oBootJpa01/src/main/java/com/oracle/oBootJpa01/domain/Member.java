package com.oracle.oBootJpa01.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity 	// 이 어노테이션은 Member 클래스가 JPA 엔터티(Entity)임을 나타냄. JPA는 이 클래스를 데이터베이스 테이블과 매핑하고, 데이터베이스와 상호작용할 때 사용.
@Table(name = "member1") // 이 어노테이션은 해당 엔터티를 매핑할 데이터베이스 테이블의 이름을 지정,  여기서는 "member1"이라는 이름의 테이블과 매핑
@Getter // Lombok 라이브러리의 어노테이션으로, 해당 필드에 대한 getter와 setter 메서드를 자동으로 생성,  이를 통해 객체의 필드에 접근하고 수정 가능
@Setter // ``
@ToString // Lombok 라이브러리의 어노테이션으로, 해당 클래스의 toString() 메서드를 자동으로 생성, 이를 통해 객체를 문자열로 표현할 때 사용
public class Member {
	@Id // 이 어노테이션은 엔터티 클래스의 기본 키(primary key)를 나타냄. 여기서는 Long 타입의 id 필드가 엔터티의 기본 키임을 나타냄
	private Long id;
	private String name;
	
} // 위 코드는 스프링 부트와 JPA를 사용하여 데이터베이스의 member1 테이블과 매핑되는 Member 엔터티 클래스를 정의하고, Lombok을 통해 코드를 간결하게 유지


	/*
	@Override
	public String toString() {
		// return super.toString
		String returnStr = "";
		returnStr = "[id=" + this.id + ", name=" + this.name + "]";
		return returnStr;
	}
	*/
	
	/*
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	*/	
