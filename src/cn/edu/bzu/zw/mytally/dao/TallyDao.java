package cn.edu.bzu.zw.mytally.dao;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;

import cn.edu.bzu.zw.mytally.bean.Tally;

/**
 * @author zw
 *	账目数据库操作类
 */
public class TallyDao {
	private Connection conn = null;
	private QueryRunner qr = null;
	private String sql = null;
	
	public TallyDao() {
		super();
	}
	
	public boolean addTally(Tally tally){
		
		return false;
	}
	
	
}
