package cn.edu.bzu.zw.mytally.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  @package cn.edu.bzu.zw.mytally.dao
 *  @project MyTally
 *	@author zhangwei
 * 	@time 2017年6月8日 下午3:44:24
 * 	数据库连接类
 * 
 */
public class DB {
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytally?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull","root","root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
