package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Dept;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptMapperTests {
	
	@Autowired
	DeptMapper mapper;
	@Test
	public void test01_selectAll(){
		System.out.println("mapper=" + mapper);
		List<Dept> list = mapper.selectAll();
		
		for (Dept d : list) {
			System.out.println(d.getDeptno() +","+d.getDname()+"," + d.getLoc());
		}
	}
	@Test
	public void test02_selectByDeptno(){
		Dept d1 = mapper.selectByDeptno(10);
		Dept d2 = mapper.selectByDeptno(20);
		Dept d3 = mapper.selectByDeptno(88);
		
		System.out.println("d1====>"+ d1.getDeptno() +","+d1.getDname()+"," + d1.getLoc());
		System.out.println("d2====>"+ d2.getDeptno() +","+d2.getDname()+"," + d2.getLoc());
		System.out.println("d3====>" + d3);
	}
	@Test
	public void test03_insert(){
		Dept dept = new Dept();
		dept.setDeptno(50);
		dept.setDname("xxx");
		dept.setLoc("yyy");
		
	try{
		int rtn = mapper.insert(dept);
		System.out.println("rtn =" + rtn);
	}catch(DuplicateKeyException e){
		System.out.println("중복에러 deptno=" + dept.getDeptno());
	}
}	
	
@Test
public void test04_updateByDeptno(){
	Dept dept = new Dept();
	dept.setDeptno(50);
	dept.setDname("총무부");
	dept.setLoc("서울");
	
	int rtn = mapper.updateByDeptno(dept);
	System.out.println("update rtn=" + rtn);
	}

@Test
public void test05_deleteByDeptno(){
	
	int rtn = mapper.deleteByDeptno(60);
	System.out.println("delete rtn=" + rtn);
	}
}