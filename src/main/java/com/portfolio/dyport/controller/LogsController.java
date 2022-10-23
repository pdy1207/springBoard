package com.portfolio.dyport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.portfolio.dyport.service.LogsService;
import com.portfolio.dyport.vo.LogsVO;

@RestController
@RequestMapping("/api/d1")
@CrossOrigin
public class LogsController {
	
	@Autowired
	private LogsService service;
	
	//로그 전체 조회
	@GetMapping("/logs")
	public PageInfo<List<LogsVO>> callLogs(@RequestParam int page){
		List<List<LogsVO>> list = service.getLogs(page);
		int navigatePages = 5;
		return new PageInfo<List<LogsVO>>(list,navigatePages);
	}
	
	//선택 로그 나오게
	@GetMapping("/logs/{logId}")
	public LogsVO callLogsByLogId(@PathVariable int logId) {
		return service.getLogsByLogsId(logId);
	}
}
