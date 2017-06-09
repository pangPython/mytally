package cn.edu.bzu.zw.mytally.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.commons.io.FileUtils;
import org.junit.experimental.theories.Theories;

import cn.edu.bzu.zw.mytally.service.UserService;
import cn.edu.bzu.zw.mytally.view.LoginFrame;
import cn.edu.bzu.zw.mytally.view.MainFrame;


/**
 *  @package cn.edu.bzu.zw.mytally.listener
 *  @project MyTally
 *	@author zhangwei
 * 	@time 2017年6月8日 下午3:48:59
 * 登录按钮监听器
 * 
 */
public class LoginBtnListener implements ActionListener {
	
	Logger logger = Logger.getLogger(LoginBtnListener.class.getName());
	
	private JTextField jtfUserName;
	private JTextField jtfPassWord;
	private MainFrame mainFrame;
	private LoginFrame loginFrame;
	


	public LoginBtnListener(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		String uuid = null;
		//获取登录窗体中的用户名输入框
		jtfUserName = loginFrame.getJtfUserName();
		//获取登录窗体中的密码输入框
		jtfPassWord = loginFrame.getJtfPassWord();
		//用户名为空检测
		if(jtfUserName.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "请填写用户名！");
			return;
		}
		//密码为空检测
		if(jtfPassWord.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "请填写密码！");
			return;
		}
		//把用户输入的用户名密码去数据库查询，查询到之后返回uuid，查询不到返回null
		if((uuid = login(jtfUserName.getText(), jtfPassWord.getText())) != null){
			//设置本地文件存储用户信息
			File file = new File("temp/user.dat");
			try {
				//把用户uuid写入文件
				FileUtils.writeStringToFile(file, uuid, "UTF-8", false);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//记录日志
			logger.info(jtfUserName.getText()+" 登录成功 "+System.currentTimeMillis());
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
