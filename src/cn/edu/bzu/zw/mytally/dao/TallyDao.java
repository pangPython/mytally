package cn.edu.bzu.zw.mytally.dao;

import java.util.List;

import cn.edu.bzu.zw.mytally.bean.Tally;


/**
 *  @package cn.edu.bzu.zw.mytally.dao
 *  @project MyTally
 *	@author zhangwei
 * 	@time 2017年6月8日 下午3:44:49
 * 账目数据库操作接口
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
	/**
	 * 获取收入列表
	 * @param uid
	 * @return
	 */
	public List<Tally> getinList(String uid);
	
	/**
	 * 获取支出列表
	 * @param uid
	 * @return
	 */
	public List<Tally> getoutList(String uid);
	/**
	 *更新收支 
	 * @param tally
	 * @return
	 */
	public int update(Tally tally);
	/**
	 * 删除收支
	 * @param tallyID
	 * @return
	 */
	public int del(int tallyID);
}
