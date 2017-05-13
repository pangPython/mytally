package cn.edu.bzu.zw.mytally.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.edu.bzu.zw.mytally.bean.User;
import cn.edu.bzu.zw.mytally.dao.DB;

public class ModelTest {
	public static void main(String[] args) {
		Connection conn = DB.getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from tbl_user where id = ?";
		User user = null;
		try {
			user = qr.query(conn, sql, new BeanHandler<>(User.class),1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(user.getUsername()+":"+user.getPassword());
		
		
		
	}
}
