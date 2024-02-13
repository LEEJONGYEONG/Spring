package com.oracle.oBootMybatis01.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.oBootMybatis01.model.Dept;
import com.oracle.oBootMybatis01.model.Emp;
import com.oracle.oBootMybatis01.model.EmpDept;

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
	public int updateEmp(Emp emp) {
		int updateCount = 0;
		System.out.println("EmpDaoImpl update start...");
		System.out.println("EmpDaoImpl update emp->"+emp);
		try {
			updateCount = session.update("tkEmpUpdate", emp);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl updateEmp Exception -> " + e.getMessage());
		}
		return updateCount;
	}

	@Override
	public List<Emp> listManager() {
		System.out.println("EmpDaoImpl listManager start...");
		List<Emp> empList = null;
		 try {
			   //                                         Map ID        
			 empList = session.selectList("tkSelectManager");
		 } catch (Exception e) {
			   System.out.println("EmpDaoImpl listManager Exception -> " + e.getMessage());
		 }
		 return empList;
	}

	@Override
	public int insertEmp(Emp emp) {
		int insertResult = 0;
		System.out.println("EmpDaoImpl insertEmp Start...");
		try {
			insertResult = session.insert("insertEmp", emp);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl e.getMassage() -> " + e.getMessage());
		}
		return insertResult;
	}

	@Override
	public int deleteEmp(int empno) {
		int deleteResult = 0;
		System.out.println("EmpDaoImpl deleteEmp start...");
		try {
			deleteResult = session.delete("deleteEmp", empno);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl e.getMassage() -> " + e.getMessage());
		}
		return deleteResult;
	}

	@Override
	public List<Emp> empSearchList3(Emp emp) {
		List<Emp> empSearchList3 = null;
		System.out.println("EmpDaoImpl empSearchList3 Start...");
		System.out.println("EmpDaoImpl empSearchList3 emp -> " + emp);
		try {
			// keyword 검색
			// Naming Rule                                       Map Id        ,  parameter
			empSearchList3 = session.selectList("tkEmpSearchList3", emp);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listEmp Exception -> " + e.getMessage());
		}
		return empSearchList3;
	}

	@Override
	public int condTotalEmp(Emp emp) {
		int totEmpCount = 0;
		System.out.println("EmpDaoImpl condTotalEmp Start...");
		System.out.println("EmpDaoImpl Start emp -> " + emp);
		try {
			totEmpCount = session.selectOne("contTotalEmp", emp);
			System.out.println("EmpDaoImpl totalEmp totEmpCount -> " + totEmpCount);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl totalEmp Exception -> " + e.getMessage());
		}
		return totEmpCount;
	}

	@Override
	public List<EmpDept> listEmpDept() {
		List<EmpDept> empDeptList = null;
		System.out.println("EmpDaoImpl listEmpDept Start...");
		try {
			empDeptList = session.selectList("tkListEmpDept");
			System.out.println("EmpDaoImpl listEmpDept empDeptList.size() -> " + empDeptList.size());
		} catch (Exception e) {
			System.out.println("EmpDaoImpl empDeptList Exception -> " + e.getMessage());
		}
		return empDeptList;
	}
	
	

}