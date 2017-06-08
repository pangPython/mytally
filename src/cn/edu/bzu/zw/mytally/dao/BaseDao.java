package cn.edu.bzu.zw.mytally.dao;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;

/**
 *  @package cn.edu.bzu.zw.mytally.dao
 *  @project MyTally
 *	@author zhangwei
 * 	@time 2017年6月8日 下午3:44:02
 * 	数据库操作基础父类
 */
public class BaseDao {

	protected Connection conn = null;
	protected QueryRunner qr = null;
	protected String sql = null;

	public BaseDao() {
		conn = DB.getConnection();
		qr = new QueryRunner();
	}
	
	
	
}
