package cn.edu.bzu.zw.mytally.dao;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;

public class BaseDao {

	protected Connection conn = null;
	protected QueryRunner qr = null;
	protected String sql = null;

	public BaseDao() {
		conn = DB.getConnection();
		qr = new QueryRunner();
	}
	
	
	
}
