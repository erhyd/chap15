package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.domain.Emp;

@Mapper
public interface EmpMapper {

	@Select("select * from emp")
	List<Emp> selectAll();
	
	@Select("select * from emp where deptno=#{deptno}")
	List<Emp> selectByDeptno(int deptno);
	
	@Insert("insert into emp(deptno, empno, ename, job) values(#{deptno}, #{empno}, #{ename}, #{job})")
	int insert(Emp emp);
	
	@Update({
		"update emp",
		"set deptno = #{deptno},",
		"	job = #{job}	",
		"where empno = #{empno}"
	})
	int updateByEmpno(Emp emp);
	
	@Delete("delete from emp where deptno=#{deptno}")
	int deleteByDeptno(int deptno);
}
