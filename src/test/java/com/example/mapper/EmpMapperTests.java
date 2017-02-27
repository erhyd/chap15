package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Emp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpMapperTests {

	@Autowired
	EmpMapper mapper;
	@Test
	public void test01_selectAll(){
		System.out.println("mapper=" + mapper);
		List<Emp> list = mapper.selectAll();
		
		for (Emp e : list){
			System.out.println(e.getComm() + "," + e.getDeptno() + "," + e.getEmpno() +"," + e.getEname() + "," + e.getHiredate() + "," + e.getJob() + "," + e.getMgr() + "," + e.getSal());
		}
	}
	@Test
	public void test02_selectByDeptno(){
		List<Emp> list1 = mapper.selectByDeptno(10);
		
		for(Emp e : list1){
		System.out.println("e1 ===>"+ e.getDeptno() + "," + e.getEname());
		}
	}
	@Test
	public void test03_insert(){
		Emp emp = new Emp();
		emp.setDeptno(40);
		emp.setEmpno(8000);
		emp.setEname("남상혁");
		emp.setJob("연구원");
		
		try{
			int rtn = mapper.insert(emp);
			System.out.println("rtn="+rtn);
		}catch(DuplicateKeyException e){
			System.out.println("중복에러 empno=" + emp.getEmpno());
		}
	}
	@Test
	public void test04_updateByEmpno(){
		Emp emp = new Emp();
		emp.setEmpno(8000);
		emp.setDeptno(50);
		emp.setJob("건축공학 연구원");
		
		int rtn = mapper.updateByEmpno(emp);
		System.out.println("rtn =" + rtn);
	}
	@Test
	public void test05_deleteByDeptno(){
		
		int rtn = mapper.deleteByDeptno(50);
		System.out.println("rtn =" + rtn);
	}
}