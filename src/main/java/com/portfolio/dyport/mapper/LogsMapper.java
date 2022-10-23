package com.portfolio.dyport.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.portfolio.dyport.vo.LogsVO;

@Mapper
public interface LogsMapper {

	public int insertLogs(LogsVO vo); //로그 추가 
	
	public List<List<LogsVO>> selectLogs(int page); //로그 조회
	
	public LogsVO selectLogsByLogId(int logId);	//선택 로그 나오게
	
}
