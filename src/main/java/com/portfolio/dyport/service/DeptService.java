package com.portfolio.dyport.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.portfolio.dyport.mapper.DeptMapper;
import com.portfolio.dyport.vo.DeptVO;

@Service
public class DeptService implements DeptServiceImple{
	@Autowired
	private DeptMapper mapper;

	//총 부서 나오는 로직
	@Override
	public List<Map<String, Object>> getDept(int page) {
		int PageSize = 10;
		PageHelper.startPage(page,PageSize);
		return mapper.selectDeptAll();
	}

	//부서 선택
	@Override
	public DeptVO getDeptByDeptno(int deptno) {
		return mapper.selectDept(deptno);
	}
	
	//부서 등록
	@Override
	public int getDeptInsert(DeptVO vo) {
		return mapper.insertDept(vo);
	}
	
	//부서 수정
	@Override
	public int getDeptUpdate(DeptVO vo) {
		return mapper.updateDept(vo);
	}
	
	//부서 삭제
	@Override
	public int getDeptDelect(int deptno) {
		return mapper.deleteDept(deptno);
	}

}
