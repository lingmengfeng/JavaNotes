package cn.edu.nuaa.xin.spring.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component(value="UserDAO")//相当于在配置文件里配置了<bean id="UserDAO" class="cn.edu.nuaa.xin.spring.UserDAOImplementation"/>
@Repository("userDAO")
public class UserDAOImplementation implements UserDAO {
    
	
	@Value("sdlkfsjd")
	private String name;
    
	@Override
	public void save() {
		System.out.println("UserDAOImplementation has been executed..."+name);

	}

}
