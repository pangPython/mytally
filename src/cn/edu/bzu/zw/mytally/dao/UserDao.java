package cn.edu.bzu.zw.mytally.dao;

import cn.edu.bzu.zw.mytally.bean.User;

/**
 *  @package cn.edu.bzu.zw.mytally.dao
 *  @project MyTally
 *	@author zhangwei
 * 	@time 2017年6月8日 下午3:45:01
 * 用户数据库操作接口
 */
public interface UserDao {
	public User findById(int id);
	public User findUserByNameAndPwd(String username,String password);
}
