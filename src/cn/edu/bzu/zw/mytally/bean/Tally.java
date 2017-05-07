package cn.edu.bzu.zw.mytally.bean;

import java.sql.Timestamp;

public class Tally {
	private int id;
	private int userid;
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
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
