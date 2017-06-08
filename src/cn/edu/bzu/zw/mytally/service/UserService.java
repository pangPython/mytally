package cn.edu.bzu.zw.mytally.service;

import cn.edu.bzu.zw.mytally.bean.User;
import cn.edu.bzu.zw.mytally.dao.impl.UserDaoImpl;

/**
 *  @package cn.edu.bzu.zw.mytally.service
 *  @project MyTally
 *	@author zhangwei
 * 	@time 2017年6月8日 下午3:51:11
 * 用户 service层 服务层 供其它类中调用，本层调用UserDao的实现类
 */
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
