package com.portfolio.dyport.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.portfolio.dyport.vo.DeptVO;

@Mapper
public interface DeptMapper {
	
	//총 부서 나오는 로직
	public List<Map<String,Object>> selectDeptAll();
	
	//부서목록 중 부서를 클릭하였을때
	public DeptVO selectDept(int deptno);
	
	//부서 등록
	public int insertDept(DeptVO vo);
	
	//부서 수정
	public int updateDept(DeptVO vo);
	
	//부서 삭제
	public int deleteDept(int deptno); 
}
