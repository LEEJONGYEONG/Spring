package com.oracle.oBootJpaApi01.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@SequenceGenerator(
      name = "member_seq_gen5",               // 객체 Seq
      sequenceName = "member_seq_generate5",      // DB Seq
      initialValue = 1,                     // 시퀀스의 시작값
      allocationSize = 1                     // 시퀀스에서 한 번에 할당하는 범위
      )
@Table(name = "member5")
public class Member {
   @Id
   @GeneratedValue(
         strategy = GenerationType.SEQUENCE,
         generator = "member_seq_gen5"
         )
   @Column(name = "member_id")
   private Long id;
   
   @Column(name = "userName")
   private String name;
   private Long sal;
   
   // 관계 설정
   @ManyToOne
   @JoinColumn(name = "team_id")
   private Team team;
   
   // 실제Column X --> Buffer용도
   @Transient
   private String teamname;
   
   @Transient
   private Long teamid;

}