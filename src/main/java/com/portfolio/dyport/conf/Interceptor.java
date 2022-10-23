package com.portfolio.dyport.conf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.portfolio.dyport.mapper.LogsMapper;
import com.portfolio.dyport.vo.LogsVO;

@Component
public class Interceptor implements HandlerInterceptor{
	
	@Autowired
	private LogsMapper logsmapper;
	
	private final Logger logger = LoggerFactory.getLogger(Interceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//이제 System.out.println(); 그만
		//logger를 이용해서 기록을 남기자
		//logger를 이용하면 원하는 레벨에 맞게 출력이 가능하다.
		//레벨 ? 디버깅 모드 경고 모드 출력 모드		
		
		logger.info("===================================");
		String requestUrl = request.getRequestURI(); //접속 url 호출
		String httpMethod = request.getMethod(); // http 메소드 호출
		String userIP = request.getHeader("X-Forwarded-For");
		if(userIP == null) userIP = request.getRemoteAddr();
		
		logger.info("요청 URL : " + requestUrl);
		logger.info("요청 HTTP Method : " + httpMethod);
		logger.info("사용자 IP : " + userIP);
		logger.info("===================================");
		
		LogsVO logVO = new LogsVO();
		logVO.setHttpMethod(httpMethod);
		logVO.setIp(userIP);
		logVO.setUrl(requestUrl);
		
		logsmapper.insertLogs(logVO);
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
}
