package cn.edu.bzu.zw.mytally.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.edu.bzu.zw.mytally.bean.Tally;
import cn.edu.bzu.zw.mytally.dao.BaseDao;
import cn.edu.bzu.zw.mytally.dao.TallyDao;

public class TallyDaoImpl extends BaseDao implements TallyDao {

	
	
	
	public TallyDaoImpl() {
	}

	@Override
	public boolean addTally(Tally tally) {
		boolean rtn = false;
		sql = "insert into tally(userid,direction,amount,note) values(?,?,?,?)";
		int result = 0;
		try {
			result = qr.update(conn,sql,new BeanHandler<>(Tally.class),tally.getUserid(),tally.getDirection(),tally.getAmount(),tally.getNote());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result>0){
			rtn = true;
		}
		return rtn;
	}

	@Override
	public List<Tally> getTallys() {
		return null;
	}

	@Override
	public Tally getTallyById(int id) {
		return null;
	}

}
