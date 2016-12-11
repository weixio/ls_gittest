package com.mark.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mark.po.UserPo;
import com.mark.service.testService;

@Controller    //将这个类放入容器中
@RequestMapping("/mark")
public class testController{
	
	
	@Resource(name="testService")   //从容器中注入service
	private testService testservice;

	@RequestMapping("/init")  //指定跳转地址映射
	public ModelAndView dotest(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse) throws Exception {
		System.out.println(testservice.getClass().getName());
		testservice.doservice();
		UserPo po = testservice.getUserPobyId(1);
		ModelAndView mav = new ModelAndView();
		mav.addObject("ss",po.toString());
		mav.setViewName("test.jsp");
		return mav;
	}
	@RequestMapping("/doajax")
	public void doajax(HttpServletRequest request,
			HttpServletResponse response){
		String id = request.getParameter("id");
		UserPo po = testservice.getUserPobyId(1);
		
		try {
			response.getWriter().write(po.getUsername());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//参数绑定
	@RequestMapping("/doParam")
	public void doParam(HttpServletRequest request,HttpServletResponse response,@RequestParam(value="id",required=true) String id,UserPo po) throws IOException{
		response.setCharacterEncoding("utf-8");
		JSONObject js = JSONObject.fromObject(po);
		response.getWriter().write(js.toString());
	}
	
	//json交互
	@RequestMapping("/dojson")
	public @ResponseBody UserPo doParam(@RequestBody UserPo po){
		//JSONObject js = JSONObject.fromObject(po);
		return po;
	}
	//接受po_id数组
	@RequestMapping("/doArray")
	public ModelAndView doArray(String[] po_id) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("ss","ggg");
		mav.setViewName("test.jsp");
		return mav;
	}
	//@Validated BindingResult br配套出现  ，位置固定
	@RequestMapping("/dovalidate")
	public String dovalidate(Model model, 
			@ModelAttribute("model")//指定数据回显的名称 request.setAttribute("model",po)
		@Validated UserPo po,BindingResult br){
		if(br.hasErrors()){
			List<ObjectError> allErrors = br.getAllErrors();
			for (ObjectError objectError : allErrors) {
				System.out.println(objectError.getDefaultMessage());
			}
			model.addAttribute("allErrors",allErrors);
			return "test.jsp";
		}
		return "test.jsp";
	}
	public void run(){
		
	}
}
