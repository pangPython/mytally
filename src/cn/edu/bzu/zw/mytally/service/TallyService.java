package cn.edu.bzu.zw.mytally.service;

import java.util.List;

import cn.edu.bzu.zw.mytally.bean.Tally;
import cn.edu.bzu.zw.mytally.dao.impl.TallyDaoImpl;

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
