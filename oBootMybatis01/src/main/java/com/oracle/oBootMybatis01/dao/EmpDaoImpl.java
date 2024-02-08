package com.oracle.oBootMybatis01.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.oBootMybatis01.model.Emp;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor 
public class EmpDaoImpl implements EmpDao {
   // Mybatis DB 연동
   private final SqlSession session;
   
   @Override
   public int totalEmp() {
      int totEmpCount = 0;
      System.out.println("EmpDaoImpl Start total...");
      
      try {
         totEmpCount = session.selectOne("com.oracle.oBootMybatis01.EmpMapper.empTotal");
         System.out.println("EmpDaoImpl totalEmp totEmpCount->"+totEmpCount);
      } catch(Exception e) {
         System.out.println("EmpDaoImpl totalEmp Exception->"+e.getMessage());
      }
      return totEmpCount;
   }

   @Override
   public List<Emp> listEmp(Emp emp) {
	   List<Emp> empList = null;
	   System.out.println("EmpDaoImpl listEmp Start...");
	   try {
		   //                                         Map ID         parameter
		   empList = session.selectList("tkEmpListAll", emp);
		   System.out.println("EmpDaoImpl listEmp empList.size() -> " + empList.size());
	   } catch (Exception e) {
		   System.out.println("EmpDaoImpl listEmp e.getMessage() -> " + e.getMessage());
	   }
	   return empList;
   }

	@Override
	public Emp detailEmp(int empno) {
		System.out.println("EmpDaoImpl datail start...");
		Emp emp = new Emp();
		try {
			//                                     mapper ID  ,  Parameter   
			emp = session.selectOne("tkEmpSelOne", empno);
			System.out.println("EmpDaoImpl detail getName ->" + emp.getEname());
		} catch (Exception e) {
			System.out.println("EmpDaoImpl detail Exception -> " + e.getMessage());
		}
		return emp;
	}

	@Override
	public Emp updateEmp(Emp emp1) {
		// TODO Auto-generated method stub
		return null;
	}

}