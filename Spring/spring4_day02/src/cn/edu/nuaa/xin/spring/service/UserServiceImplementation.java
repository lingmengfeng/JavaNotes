package cn.edu.nuaa.xin.spring.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.edu.nuaa.xin.spring.dao.UserDAO;

@Service("userService")//<bean id="userService" class="cn.edu.nuaa.xin.spring.service.UserServiceImplementation"/>
public class UserServiceImplementation implements UserService {

	
	//×¢ÈëDAO
//	@Autowired
//	@Qualifier(value="userDAO")
	
	@Resource(name="userDAO")
	private UserDAO userDAO;
	
	
	@Override
	public void save() {
		System.out.println("UserServiceImplementation has been executed....");
		userDAO.save();
		
	}

}
