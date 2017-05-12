package cn.edu.bzu.zw.mytally.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.commons.io.FileUtils;

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
		String uuid = null;
		if(jtfUserName.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "请填写用户名！");
			return;
		}
		if(jtfPassWord.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "请填写密码！");
			return;
		}
		if((uuid = login(jtfUserName.getText(), jtfPassWord.getText())) != null){
			//设置本地文件存储用户信息
			File file = new File("temp/user.dat");
			try {
				FileUtils.writeStringToFile(file, uuid, "UTF-8", false);
			} catch (IOException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "登录成功");
			loginFrame.setVisible(false);
			mainFrame = new MainFrame("个人记账系统");
			mainFrame.setVisible(true);
			
		}else{
			JOptionPane.showMessageDialog(null, "登录失败！");
			return;
		}
		
	}
	//登录方法
	private String login(String username,String password) {
		System.out.println("UserName:"+username);
		System.out.println("Password:"+password);
		UserService userService = new UserService();
		String uuid = null;
		if(userService.login(username, password) != null){
			uuid = userService.login(username, password);
		}
		return uuid;
	}

}
