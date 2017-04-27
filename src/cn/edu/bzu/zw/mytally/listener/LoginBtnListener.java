package cn.edu.bzu.zw.mytally.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import cn.edu.bzu.zw.mytally.model.User;




/**
 * @author zw
 *	登录按钮监听器
 */
public class LoginBtnListener implements ActionListener {
	
	private String userName;
	private String password;
	

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(login(userName, password)){
			JOptionPane.showMessageDialog(null, "登录成功");
		}
	}
	//登录方法
	private boolean login(String userName,String password) {
		System.out.println(userName);
		System.out.println(password);
		User user = User.dao.findFirst("select * from tbl_user where username = ? and password = ?",userName,password);
		
		if (user!=null) {
			return true;
		}
		
		return false;
	}

}
