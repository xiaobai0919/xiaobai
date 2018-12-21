package com.crm.ssh2.base.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crm.ssh2.util.PageBean;

public class BaseTest {

	private static ApplicationContext applicationContext;
	
	static {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
	}
	
	protected PageBean pageBean;
	
	public BaseTest() {
		
	}
	
	protected Object getBean(String name) {
		return applicationContext.getBean(name);
	}
	
	@Before
	public void setUp() throws Exception {
		pageBean = new PageBean();
	}

	@Before
	public void tearDown() throws Exception {
		
	}
	
}
