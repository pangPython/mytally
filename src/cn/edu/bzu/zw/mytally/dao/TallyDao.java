package cn.edu.bzu.zw.mytally.dao;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import cn.edu.bzu.zw.mytally.bean.Tally;

/**
 * @author zw
 *	账目数据库操作类
 */
public interface TallyDao {

	
	/**
	 * 添加账目
	 * @param tally
	 * @return
	 */
	public boolean addTally(Tally tally);
	
	/**
	 * 
	 * @return
	 */
	public List<Tally> getTallys();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Tally getTallyById(int id);
	
	
	
}
