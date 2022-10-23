package com.portfolio.dyport.service;

import java.util.List;
import java.util.Map;

import com.portfolio.dyport.vo.DeptVO;

public interface DeptServiceImple {
	
	//총 부서 나오는 로직
	public List<Map<String,Object>> getDept(int page);
	
	//부서 선택
	public DeptVO getDeptByDeptno(int deptno);
	
	//부서 등록
	public int getDeptInsert(DeptVO vo);
	
	//부서 수정
	public int getDeptUpdate(DeptVO vo);
	
	//부서 삭제
	public int getDeptDelect(int deptno);
}
