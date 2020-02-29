package com.dream.ltl.service;

import com.gupaoedu.mvcframework.annotation.GPService;

/**
 * 核心业务逻辑
 */
@GPService
public class DemoService implements IDemoService{

	public String get(String name) {
		return "My name is " + name;
	}

}
