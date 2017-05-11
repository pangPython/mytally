package cn.edu.bzu.zw.mytally.dao.impl;

import java.sql.SQLException;
import java.util.List;

import cn.edu.bzu.zw.mytally.bean.Tally;
import cn.edu.bzu.zw.mytally.dao.BaseDao;
import cn.edu.bzu.zw.mytally.dao.TallyDao;

public class TallyDaoImpl extends BaseDao implements TallyDao {

	
	
	
	public TallyDaoImpl() {
	}

	@Override
	public boolean addTally(Tally tally) {
		sql = "insert into tally";
		int result = 0;
		try {
			result = qr.update( "INSERT INTO Person (userName,age) VALUES (?,?)",
			        "zhanghongjie", 122 );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
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
