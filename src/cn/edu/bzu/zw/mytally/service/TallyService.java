package cn.edu.bzu.zw.mytally.service;

import cn.edu.bzu.zw.mytally.bean.Tally;
import cn.edu.bzu.zw.mytally.dao.impl.TallyDaoImpl;

public class TallyService {
	
	TallyDaoImpl tallyDaoImpl = new TallyDaoImpl();
	
	public boolean add(Tally tally){
		return tallyDaoImpl.addTally(tally);
	}
	
}
