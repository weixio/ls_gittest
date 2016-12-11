package com.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//把这个类生命为一个切面
@Component
@Aspect
public class AsceptDemo {
		/**
		 * 前置通知：在方法执行之前做的事
		 * @param jp
		 */
		@Order(1) //指定切面优先级
		@Before("execution(public * com.mark.service.testService.*(..))")
		public void beforeMethod(JoinPoint jp){
			String methodName = jp.getSignature().getName();
			Object[] args = jp.getArgs();
			System.out.println("method name:"+methodName+" begins with:"+Arrays.asList(args));
		}
		/**
		 * 后置通知：方法执行之后执行，无论该方法是否异常
		 * @param jp
		 */
		@After("execution(public * com.mark.service.testService.*(..))")
		public void aftermothod(JoinPoint jp){
			String methodName = jp.getSignature().getName();
			Object[] args = jp.getArgs();
			System.out.println("method name:"+methodName+" end");
		}
		
		/**
		 * 返回通知：方法正常执行之后的通知（没有异常）
		 * 可以获得返回值 result
		 * @param jp
		 */
		@AfterReturning(value="execution(public * com.mark.service.testService.*(..))",returning="result")
		public void afterReturn(JoinPoint jp,Object result){
			System.out.println(result);
		}
		/**
		 * 异常通知
		 * @param jp
		 * @param result
		 */
		@AfterThrowing(value="execution(public * com.mark.service.testService.*(..))",throwing="ex")
		public void AfterThrowing(JoinPoint jp,Exception ex){
			System.out.println(ex.toString());
		}
		
//		/**
//		 * 环绕通知相当于一个动态代理类，手工写执行过程（一般不用）
//		 * @param pjp
//		 * @return
//		 */
//		@Around(value="execution(public * com.mark.service.testService.*(..))")
//		public Object around(ProceedingJoinPoint pjp){
//			Object result = null;
//			//获取方法名
//			String method = pjp.getSignature().getName();
//			
//			try {
//				//前置通知
//				System.out.println("前置通知");
//				//执行指定方法
//				result = pjp.proceed();
//				//返回通知
//				System.out.println("返回通知");
//			} catch (Throwable e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				//异常通知
//				System.out.println("异常通知");
//			}
//			return 0;
//		}
}
