package cn.edu.bzu.zw.mytally.dao;

import cn.edu.bzu.zw.mytally.bean.User;

public interface UserDao {
	public User findById(int id);
	public User findUserByNameAndPwd(String username,String password);
}
