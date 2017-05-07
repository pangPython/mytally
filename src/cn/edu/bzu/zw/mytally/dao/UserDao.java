package cn.edu.bzu.zw.mytally.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.edu.bzu.zw.mytally.bean.User;


/**
 * @author zw
 * 用户数据库操作类
 *
 */
public class UserDao {
	
	private Connection conn = null;
	private QueryRunner qr = null;
	private String sql = null;
	private User user = null;
	
	
	
	public UserDao() {
		conn = DB.getConnection();
		qr = new QueryRunner();
	}

	//根据id查找用户
	public User findById(int id){
		sql  = "select * from tbl_user where id = ?";
		try {
			user = qr.query(conn, sql, new BeanHandler<>(User.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
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
