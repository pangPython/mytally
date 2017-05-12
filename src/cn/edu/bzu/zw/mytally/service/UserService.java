package cn.edu.bzu.zw.mytally.service;

import cn.edu.bzu.zw.mytally.bean.User;
import cn.edu.bzu.zw.mytally.dao.UserDaoImpl;

public class UserService {
	
	UserDaoImpl userDaoImpl = new UserDaoImpl();
	
		public String login(String username,String password){
			String result = null;
			User user = new User();
			if((user =userDaoImpl.findUserByNameAndPwd(username, password))!=null){
				result = user.getUuid();
			}
			return result;
		}
}
