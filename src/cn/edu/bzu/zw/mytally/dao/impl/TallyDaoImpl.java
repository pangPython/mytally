package cn.edu.bzu.zw.mytally.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.bzu.zw.mytally.bean.Tally;
import cn.edu.bzu.zw.mytally.dao.BaseDao;
import cn.edu.bzu.zw.mytally.dao.TallyDao;

public class TallyDaoImpl extends BaseDao implements TallyDao {

	
	
	
	public TallyDaoImpl() {
	}

	@Override
	public boolean addTally(Tally tally) {
		boolean rtn = false;
		sql = "insert into tbl_tally(useruuid,direction,amount,note) values(?,?,?,?)";
		int result = 0;
		try {
			result = qr.update(conn,sql,tally.getUseruuid(),tally.getDirection(),tally.getAmount(),tally.getNote());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result>0){
			rtn = true;
		}
		return rtn;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tally> getTallys() {
		sql = "select * from tbl_tally";
		List<Tally> list = new ArrayList<>();
		try {
			list = (List) qr.query(conn, sql, new BeanListHandler(Tally.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Tally getTallyById(int id) {
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Tally> getinList(String uid) {
		sql = "select * from tbl_tally where direction = 1 and useruuid = ?";
		List<Tally> list = new ArrayList<>();
		try {
			list = (List) qr.query(conn, sql, new BeanListHandler(Tally.class),uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Tally> getoutList(String uid) {
		sql = "select * from tbl_tally where direction = 0 and useruuid = ?";
		List<Tally> list = new ArrayList<>();
		try {
			list = (List) qr.query(conn, sql, new BeanListHandler(Tally.class),uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
