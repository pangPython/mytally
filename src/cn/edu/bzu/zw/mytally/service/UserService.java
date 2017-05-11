package cn.edu.bzu.zw.mytally.service;

import cn.edu.bzu.zw.mytally.dao.UserDaoImpl;

public class UserService {
	
	UserDaoImpl userDaoImpl = new UserDaoImpl();
	
		public boolean login(String username,String password){
			boolean result = false;
			if(userDaoImpl.findUserByNameAndPwd(username, password)!=null){
				result = true;
			}
			return result;
		}
}
