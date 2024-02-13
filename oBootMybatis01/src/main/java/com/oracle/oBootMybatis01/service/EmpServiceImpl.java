package com.oracle.oBootMybatis01.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oracle.oBootMybatis01.dao.DeptDao;
import com.oracle.oBootMybatis01.dao.EmpDao;
import com.oracle.oBootMybatis01.model.Dept;
import com.oracle.oBootMybatis01.model.Emp;
import com.oracle.oBootMybatis01.model.EmpDept;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {
   
   private final EmpDao ed;
   private final DeptDao dd;
   
   @Override
   public int totalEmp() {
      System.out.println("EmpServiceImpl start total...");
      int totEmpCnt = ed.totalEmp();
      System.out.println("EmpServiceImpl totalEmp totEmpCnt->" + totEmpCnt);
      
      return totEmpCnt;
   }

   @Override
   public List<Emp> listEmp(Emp emp) {
	   List<Emp> empList = null;
	   System.out.println("EmpServiceImpl listManager start...");
	   empList = ed.listEmp(emp);
	   System.out.println("EmpServiceImp listEmp empList.size() -> " + empList.size());
	   
	   return empList;
   }

   @Override
   public Emp detailEmp(int empno) {
	   System.out.println("EmpServiceImpl detail...");
	   Emp emp = null;
	   emp = ed.detailEmp(empno);
	   
	   return emp;
   }

	@Override
	public int updateEmp(Emp emp) {
		int updateCount = 0;
		System.out.println("EmpServiceImpl update...");
		updateCount = ed.updateEmp(emp);
		
		return updateCount;
	}

	@Override
	public List<Emp> listManager() {
		List<Emp> empList = null;
		System.out.println("EmpServiceImpl listManager...");
		empList = ed.listManager();
		System.out.println("EmpServiceImpl listManager empList.size() -> " + empList.size());
		
		return empList;
	}

	@Override
	public List<Dept> deptSelect() {
		List<Dept> deptList = null;
		System.out.println("EmpServiceImpl deptSelect Start...");
		deptList = dd.deptSelect();
		System.out.println("EmpServiceImpl deptSelect deptList.size() -> " + deptList.size());
		
		return deptList;
	}

	@Override
	public int insertEmp(Emp emp) {
		int insertResult = 0;
		System.out.println("EmpServiceImpl insertEmp start...");
		insertResult = ed.insertEmp(emp);
		
		return insertResult;
	}

	@Override
	public int deleteEmp(int empno) {
		int deleteResult = 0;
		System.out.println("EmpServiceImpl deleteEmp start...");
		deleteResult = ed.deleteEmp(empno);
		
		return deleteResult;
	}

	@Override
	public List<Emp> listSearchEmp(Emp emp) {
		List<Emp> empSearchList = null;
		System.out.println("EmpServiceImpl listEmp Start...");
		empSearchList = ed.empSearchList3(emp);
		System.out.println("EmpServiceImpl listSearchEmp empSearchList.size() -> " + empSearchList.size());
		
		return empSearchList;
	}

	@Override
	public int condTotalEmp(Emp emp) {
		int totEmpCount = 0;
		System.out.println("EmpServiceImpl condTotalEmp Start...");
		totEmpCount = ed.condTotalEmp(emp);
		System.out.println("EmpServiceImpl condTotalEmp totEmpCnt -> " + totEmpCount);
		
		return totEmpCount;
	}

	@Override
	public List<EmpDept> listEmpDept() {
		List<EmpDept> empDeptList = null;
		System.out.println("EmpServiceImpl listEmpDept Start...");
		empDeptList = ed.listEmpDept();
		System.out.println("EmpServiceImpl listEmpDept empDeptList -> " + empDeptList);
		
		return empDeptList;
	}

}