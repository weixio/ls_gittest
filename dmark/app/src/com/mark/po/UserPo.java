package com.mark.po;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UserPo {
	@Size(min=1,max=30,message="{user.id.length.error}")
	private String id;
	
	@NotEmpty(message="{user.username.notnull}")
	private String username;
	private String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserPo [id=" + id + ", username=" + username + ", password="
				+ password + "]";
	}
	

}
