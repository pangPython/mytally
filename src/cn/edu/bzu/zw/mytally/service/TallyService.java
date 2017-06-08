package cn.edu.bzu.zw.mytally.service;

import java.util.List;

import cn.edu.bzu.zw.mytally.bean.Tally;
import cn.edu.bzu.zw.mytally.dao.impl.TallyDaoImpl;

/**
 *  @package cn.edu.bzu.zw.mytally.service
 *  @project MyTally
 *	@author zhangwei
 * 	@time 2017年6月8日 下午3:49:51
 * 	账单 service层 服务层 供其它类中调用，本层调用TallyDao的实现类
 */
public class TallyService {
	
	TallyDaoImpl tallyDaoImpl = new TallyDaoImpl();
	
	public boolean add(Tally tally){
		return tallyDaoImpl.addTally(tally);
	}

	public List<Tally> getTallys() {
		return tallyDaoImpl.getTallys();
	}
	
	public List<Tally> getoutList(String uid){
		return tallyDaoImpl.getoutList(uid);
	}
	public List<Tally> getinList(String uid){
		return tallyDaoImpl.getinList(uid);
	}
}
