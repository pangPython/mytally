package cn.edu.bzu.zw.mytally.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.bzu.zw.mytally.bean.Tally;
import cn.edu.bzu.zw.mytally.bean.User;
import cn.edu.bzu.zw.mytally.dao.BaseDao;
import cn.edu.bzu.zw.mytally.dao.TallyDao;

/**
 *  @package cn.edu.bzu.zw.mytally.dao.impl
 *  @project MyTally
 *	@author zhangwei
 * 	@time 2017年6月8日 下午3:45:57
 * 	账目数据库操作实现类
 * 
 */
public class TallyDaoImpl extends BaseDao implements TallyDao {

	
	
	
	private Tally tally;

	public TallyDaoImpl() {
	}

	//把账单写入数据库
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
		sql  = "select * from tbl_tally where id = ?";
		try {
			tally = qr.query(conn, sql, new BeanHandler<>(Tally.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tally;
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

	@Override
	public int update(Tally tally) {
		int result = 0; 
//		System.out.println(tally.getNote());
        try { 
        	result = qr.update(conn, "UPDATE tbl_tally SET amount = ?, direction = ?, note = ? ,tallytime = ? WHERE id = ?", tally.getAmount(), tally.getDirection(), tally.getNote(),tally.getTallytime(),tally.getId()); 
        } catch (SQLException e) { 
                e.printStackTrace(); 
        } 
        return result; 
	}

	@Override
	public int del(int tallyID) {
		int result = 0; 
        try { 
        	
        	result = qr.update(conn, "delete from tbl_tally WHERE id = ?", tally.getId());
        	
        } catch (SQLException e) { 
                e.printStackTrace(); 
        } finally { 
                try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
        } 
        return result; 
	}

}
