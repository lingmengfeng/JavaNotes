package cn.edu.nuaa.xin.spring.dao;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.nuaa.xin.spring.service.UserService;

public class Demo {
	@Test
	/**
	 * traditional way
	 */
	public void demo1() {
		UserDAO userDAO=new UserDAOImplementation();
		userDAO.save();
	}
	
	@Test
	/**
	 * Spring
	 */
	public void demo2() {
		ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		UserDAOImplementation userDAO=(UserDAOImplementation) context.getBean("UserDAOImplementation");
		userDAO.save();
	}
	@Test
	/**
	 * IOC×¢½â¿ª·¢
	 */
	public void demo3() {
		ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		UserDAOImplementation userDao=(UserDAOImplementation) context.getBean("UserDAO");
		userDao.save();
	}
	@Test
	/**
	 * IOC
	 */
	public void demo4() {
		ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		UserService userService=(UserService) context.getBean("userService");
	    userService.save();
	}

}
