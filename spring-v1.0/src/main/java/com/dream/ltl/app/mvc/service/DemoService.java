package com.dream.ltl.app.mvc.service;


import com.dream.ltl.mvcframework.annotations.GPService;

/**
 * 核心业务逻辑
 */
@GPService
public class DemoService implements IDemoService{

	public String get(String name) {
		return "My name is " + name + " from Service";
	}

}
