package com.mark.dao;

import org.springframework.stereotype.Repository;

import com.mark.po.UserPo;

public interface UserDao {
	public UserPo getUserbyId(int id);
}
