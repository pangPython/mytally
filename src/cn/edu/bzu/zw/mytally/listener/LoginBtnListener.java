package cn.edu.bzu.zw.mytally.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cn.edu.bzu.zw.mytally.dao.UserDao;
import cn.edu.bzu.zw.mytally.dao.UserDaoImpl;
import cn.edu.bzu.zw.mytally.service.UserService;
import cn.edu.bzu.zw.mytally.view.LoginFrame;
import cn.edu.bzu.zw.mytally.view.MainFrame;




/**
 * @author zw
 *	登录按钮监听器
 */
public class LoginBtnListener implements ActionListener {
	
	private JTextField jtfUserName;
	private JTextField jtfPassWord;
	private MainFrame mainFrame;
	private LoginFrame loginFrame;


	public LoginBtnListener(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		jtfUserName = loginFrame.getJtfUserName();
		jtfPassWord = loginFrame.getJtfPassWord();
		if(jtfUserName.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "请填写用户名！");
			return;
		}
		if(jtfPassWord.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "请填写密码！");
			return;
		}
		if(login(jtfUserName.getText(), jtfPassWord.getText())){
			JOptionPane.showMessageDialog(null, "登录成功");
			loginFrame.setVisible(false);
			mainFrame = new MainFrame("个人记账系统");
			mainFrame.setVisible(true);
		}
		
	}
	//登录方法
	private boolean login(String username,String password) {
		System.out.println("UserName:"+username);
		System.out.println("Password:"+password);
		UserService userService = new UserService();
		if(userService.login(username, password)){
			return true;
		}
		
		return false;
	}

}
