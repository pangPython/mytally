package cn.edu.bzu.zw.mytally.bean;

/**
 *  @package cn.edu.bzu.zw.mytally.bean
 *  @project MyTally
 *	@author zhangwei
 * 	@time 2017年6月8日 下午3:42:59
 * 	用户实体类
 * 
 */
public class User {
	private int id;
	private String username = null;
	private String password = null;
	private String uuid = null;
	
	
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
