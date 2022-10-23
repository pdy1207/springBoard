package com.portfolio.dyport.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.portfolio.dyport.service.EmpService;
import com.portfolio.dyport.vo.EmpVO;

@RestController
@RequestMapping("/api/d1")
@CrossOrigin
public class EmpController {
	
		@Autowired
		private EmpService service;
		
		//사원 수 평균급여 부서 수 보너스 합
		@GetMapping("/emp")
		public Map<String,Object> callEmpTitlAll(){
			return service.getTitlAll();
		}
		
		//사원 등록
		@PostMapping("/emp")
		public int callEmpInsert(@RequestBody EmpVO vo) {
			return service.getEmpInsert(vo);
		}
		
		//전체 사원 조회
//		@GetMapping("/empall")
//		public List<Map<String,Object>> callEmpAll(){
//			return service.getEmpAll();
//		}
		
		//페이징 처리
		@GetMapping("/emppageall")
		public PageInfo<Map<String,Object>> callEmpPage(@RequestParam int page){
			List<Map<String,Object>> list = service.getEmpAll(page);
			int navigatePages = 5;
			return new PageInfo<Map<String,Object>>(list, navigatePages);
		}
		
		//특정 사원 조회
		@GetMapping("/empall/{empno}")
		public EmpVO callEmpByEmpno(@PathVariable int empno) {
			return service.getEmpByEmpno(empno);
		}
		
		//사원 수정
		@PatchMapping("/emp")
		public int callEmpByUpdate(@RequestBody EmpVO vo) {
			return service.getEmpUpdate(vo);
		}
		
		//회원 탈퇴
		@PatchMapping("/empall/empno/{empno}")
		public int callEmpUseUpdate(@PathVariable int empno) {
			return service.getEmpUseUpdate(empno);
		}
}
