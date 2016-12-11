package com.except;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3) {
		
		
		CustomException c = null;
		if(arg3 instanceof CustomException){
			c = (CustomException)arg3;
		}else{
			c = new CustomException("未知异常");
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", c.getMessage());
		mv.setViewName("error.jsp");
		return mv;
	}

}
