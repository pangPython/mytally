package cn.edu.bzu.zw.mytally.bean;

import java.sql.Timestamp;

/**
 *  @package cn.edu.bzu.zw.mytally.bean
 *  @project MyTally
 *	@author zhangwei
 * 	@time 2017年6月8日 下午3:42:37
 * 	账目实体类
 * 
 */
public class Tally {
	private int id;
	private String useruuid;
	public void setUseruuid(String useruuid) {
		this.useruuid = useruuid;
	}
	private int direction;
	private int amount;
	private String note;
	private Timestamp tallytime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getUseruuid() {
		return useruuid;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Timestamp getTallytime() {
		return tallytime;
	}
	public void setTallytime(Timestamp tallytime) {
		this.tallytime = tallytime;
	}

	
	
}
