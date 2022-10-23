package com.portfolio.dyport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.portfolio.dyport.mapper.LogsMapper;
import com.portfolio.dyport.vo.LogsVO;

@Service
public class LogsService implements LogsServiceImple{

	@Autowired
	private LogsMapper mapper;
	
	//로그 전체 조회
	@Override
	public List<List<LogsVO>> getLogs(int page) {
		int PageSize = 10;
		PageHelper.startPage(page,PageSize);
		return mapper.selectLogs(page);
	}

	//선택 로그 나오게
	@Override
	public LogsVO getLogsByLogsId(int logId) {
		return mapper.selectLogsByLogId(logId);
	}
}
