package com.mark.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aopalliance.intercept.Interceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class demoInterceptor implements HandlerInterceptor{
	//进入handler之后执行
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("拦截器执行afterCompletion");
	}

	//返回modelandview之前执行
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("拦截器执行postHandle");		
	}

	//执行handler之前执行
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
			System.out.println("拦截器执行preHandle");	
		
			//true表示放行
			return true;
	}

}
