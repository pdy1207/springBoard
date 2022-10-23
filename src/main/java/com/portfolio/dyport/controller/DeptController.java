package com.portfolio.dyport.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.portfolio.dyport.service.DeptService;
import com.portfolio.dyport.vo.DeptVO;

@RestController
@RequestMapping("api/d1")
@CrossOrigin
public class DeptController {
	
	@Autowired
	private DeptService service;
	
	//총 부서 나오는 로직
//	@GetMapping("/dept")
//	public List<Map<String, Object>> callDept(){
//		return service.getDept();
//	}
	
	//페이징처리
	@GetMapping("/deptpage")
	public PageInfo<Map<String,Object>> callDeptPage(@RequestParam int page){
		List<Map<String,Object>> list = service.getDept(page);
		int navigatePages = 5;
		return new PageInfo<Map<String,Object>>(list,navigatePages);
	}
	
	//부서 선택
	@GetMapping("/dept/{deptno}")
	public DeptVO callDeptByDeptno(@PathVariable int deptno) {
		return service.getDeptByDeptno(deptno);
	}
	
	//부서 등록
	@PostMapping("/dept")
	public int callDeptInsert(@RequestBody DeptVO vo) {
		return service.getDeptInsert(vo);
	}
	
	//부서 수정
	@PatchMapping("/dept")
	public int callDeptUpdate(@RequestBody DeptVO vo) {
		return service.getDeptUpdate(vo);
	}
	
	//부서 삭제
	@DeleteMapping("/dept/{deptno}")
	public int callDeptDelect(@PathVariable int deptno) {
		return service.getDeptDelect(deptno);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
