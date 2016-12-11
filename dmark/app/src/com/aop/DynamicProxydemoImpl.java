package com.aop;

import org.springframework.stereotype.Component;

@Component
public class DynamicProxydemoImpl implements DynamicProxydemo {

	@Override
	public int add(int i, int j) {
		return i+j;
	}

	@Override
	public int sub(int i, int j) {
		return i-j;
	}

}
