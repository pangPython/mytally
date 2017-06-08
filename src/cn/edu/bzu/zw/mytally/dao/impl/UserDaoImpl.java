package cn.edu.bzu.zw.mytally.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.edu.bzu.zw.mytally.bean.User;
import cn.edu.bzu.zw.mytally.dao.BaseDao;
import cn.edu.bzu.zw.mytally.dao.UserDao;

/**
 *  @package cn.edu.bzu.zw.mytally.dao.impl
 *  @project MyTally
 *	@author zhangwei
 * 	@time 2017年6月8日 下午3:45:30
 * 用户数据库操作实现类
 * 
 */
public class UserDaoImpl extends BaseDao implements UserDao{
	
	private User user = null;
	
	public UserDaoImpl() {
	}

	//根据id查找用户
	@Override
	public User findById(int id){
		sql  = "select * from tbl_user where id = ?";
		try {
			user = qr.query(conn, sql, new BeanHandler<>(User.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	/**
	 * 
	 */
	@Override
	public User findUserByNameAndPwd(String username,String password){
		sql  = "select * from tbl_user where username = ? and password = ?";
		try {
			user = qr.query(conn, sql, new BeanHandler<>(User.class),username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
