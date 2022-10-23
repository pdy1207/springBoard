package com.portfolio.dyport.service;

import java.util.List;
import java.util.Map;

import com.portfolio.dyport.vo.EmpVO;

public interface EmpServiceImple {
	
	//사원 수 평균급여 부서 수 보너스 합
	public Map<String,Object> getTitlAll();
	
	//사원 등록
	public int getEmpInsert(EmpVO vo);
	
	//전체 사원 조회
	public List<Map<String,Object>> getEmpAll(int page);
	
	//특정 사원 조회
	public EmpVO getEmpByEmpno(int empno);
	
	//사원 수정
	public int getEmpUpdate(EmpVO vo);
	
	//회원 탈퇴
	public int getEmpUseUpdate(int empno);
}
