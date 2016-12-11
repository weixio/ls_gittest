package com.mark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mark.dao.UserDao;
import com.mark.dao.testDao;
import com.mark.po.UserPo;

@Service(value="testService")
public class testServiceImpl implements testService{
	@Autowired
	private testDao testdao;
	@Autowired
	private UserDao userdao;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW,
			isolation=Isolation.READ_COMMITTED,
			timeout=5000)  //默认传播行为
	public void doservice() {
		System.out.println("testServiceImpl  doservice...");
		testdao.doDao();
		UserPo po = userdao.getUserbyId(1);
		System.out.println(po);
	}
	@Override
	public UserPo getUserPobyId(int id) {
		return userdao.getUserbyId(id);
	}

}
