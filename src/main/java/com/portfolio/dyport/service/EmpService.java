package com.portfolio.dyport.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.portfolio.dyport.mapper.EmpMapper;
import com.portfolio.dyport.vo.EmpVO;

@Service
public class EmpService  implements EmpServiceImple{
	
	@Autowired
	private EmpMapper mapper;

	//사원 수 평균급여 부서 수 보너스 합
	@Override
	public Map<String, Object> getTitlAll() {
		return mapper.selectTitlAll();
	}
	
	//사원 등록
	@Override
	public int getEmpInsert(EmpVO vo) {
		int empno = vo.getEmpno();
		int count = mapper.selectCountByEmpno(empno);
		if(count > 0) {
			return 0;
		}
		return mapper.insertEmp(vo);
	}
	
	//전체 사원 조회 & 페이징 처리
	@Override
	public List<Map<String, Object>> getEmpAll(int page) {
		int pageSize = 9;
		PageHelper.startPage(page,pageSize);
		return mapper.selectEmpAll();
	}
	
	
	
	//특정 사원 조회
	@Override
	public EmpVO getEmpByEmpno(int empno) {
		return mapper.selectEmpByEmpno(empno);
	}
	
	//사원 수정
	@Override
	public int getEmpUpdate(EmpVO vo) {
		return mapper.updateEmpByEmpno(vo);
	}
	
	//회원 탈퇴
	@Override
	public int getEmpUseUpdate(int empno) {
		return mapper.moveEmp(empno);
	}
	
}
