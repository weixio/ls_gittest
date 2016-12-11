package com.mark.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mark.controller.beanTest;
import com.mark.dao.UserDao;
import com.mark.po.UserPo;
import com.mark.test.test;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-*.xml")
public class test {
	@Autowired
	private UserDao userdao;
	
	@Test
	public void testspring(){
		ApplicationContext app = new FileSystemXmlApplicationContext("/config/spring-scan.xml");
		beanTest b = (beanTest) app.getBean("beantest");
		System.out.println(b.a);
	}
	@Test
	public void testMybatis(){
		String mybatisConfig = "mybatis/mybatis-config.xml";
		
		try {
			InputStream inputstream = Resources.getResourceAsStream(mybatisConfig);
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputstream);
			SqlSession ss = ssf.openSession();
			UserPo user = ss.selectOne("test.findUserById",1);
			System.out.println(user);
			ss.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testSpringMybatis(){
		
		UserPo po = userdao.getUserbyId(1);
		System.out.println(po);
	}
}
