package com.portfolio.dyport.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.portfolio.dyport.vo.EmpVO;

@Mapper
public interface EmpMapper {
	
	//사원 수 평균급여 부서 수 보너스 합
	public Map<String,Object> selectTitlAll();
	
	//사원 등록
	public int insertEmp(EmpVO vo);
	
	//전체 사원 조회
	public List<Map<String,Object>> selectEmpAll();
	
	//특정 사원 조회
	public EmpVO selectEmpByEmpno(int empno);
	
	//사원 수정
	public int updateEmpByEmpno(EmpVO vo);
	
	//회원 탈퇴
	public int moveEmp(int empno);
	
	//이미 가입된 사원인지 아닌지 체크
	public int selectCountByEmpno(int empno);
}
