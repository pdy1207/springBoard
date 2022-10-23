package com.portfolio.dyport.service;

import java.util.List;

import com.portfolio.dyport.vo.LogsVO;

public interface LogsServiceImple {
	
	//로그 전체 조회
	public List<List<LogsVO>> getLogs(int page);
	
	//선택 로그 나오게
	public LogsVO getLogsByLogsId(int logId);

}
