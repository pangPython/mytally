package cn.edu.bzu.zw.mytally.view;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import cn.edu.bzu.zw.mytally.listener.LoginBtnListener;
import cn.edu.bzu.zw.mytally.view.gbc.LoginJBTNLoginGBC;
import cn.edu.bzu.zw.mytally.view.gbc.LoginJLBPassWordGBC;
import cn.edu.bzu.zw.mytally.view.gbc.LoginJLBUserNameGBC;
import cn.edu.bzu.zw.mytally.view.gbc.LoginJTFPwdGBC;
import cn.edu.bzu.zw.mytally.view.gbc.LoginJTFUserNameGBC;

/**
 *  @package cn.edu.bzu.zw.mytally.view
 *  @project MyTally
 *	@author zhangwei
 * 	@time 2017年6月8日 下午3:58:18
 * 	登录窗口
 * 
 */
public class LoginFrame extends JFrame{

	private static final long serialVersionUID = 260523489127732335L;
	
	private JLabel jlbUserName = null;
	private LoginJLBUserNameGBC JLBUserNameGBC = null;
	private JLabel jlbPassWord = null;
	private LoginJLBPassWordGBC JLBPwdGBC = null;
	private JLabel jlb_blank = null;
	
	private JTextField jtfUserName = null;
	public JTextField getJtfUserName() {
		return jtfUserName;
	}

	public void setJtfUserName(JTextField jtfUserName) {
		this.jtfUserName = jtfUserName;
	}

	public JTextField getJtfPassWord() {
		return jtfPassWord;
	}

	public void setJtfPassWord(JTextField jtfPassWord) {
		this.jtfPassWord = jtfPassWord;
	}

	private JTextField jtfPassWord = null;
	
	private JButton jbtnLogin = null;

	private GridBagLayout gbLayout = null;

	private LoginJTFUserNameGBC JTFUserNameGBC;

	private LoginJTFPwdGBC JTFPwdGBC;

	private LoginJBTNLoginGBC JBTNLoginGBC;

	private LoginBtnListener loginListener = null;
	
	public LoginFrame() throws HeadlessException {
		super();
	}

	public LoginFrame(String title) throws HeadlessException {
		super(title);
		jlbUserName = new JLabel("用户名:");
		jlbPassWord = new JLabel("密码:");
		jtfUserName = new JTextField(10);
		jtfPassWord = new JTextField(10);
		jbtnLogin = new JButton("登录");
		
		jtfUserName.setText("admin");
		jtfPassWord.setText("admin");
		
		jlb_blank = new JLabel();
		JLBUserNameGBC = new LoginJLBUserNameGBC();
		JLBPwdGBC = new LoginJLBPassWordGBC();
		JTFUserNameGBC = new LoginJTFUserNameGBC();
		JTFPwdGBC = new LoginJTFPwdGBC();
		JBTNLoginGBC = new LoginJBTNLoginGBC();
		
		loginListener = new LoginBtnListener(this);
		
		jbtnLogin.addActionListener(loginListener);
		jbtnLogin.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
		gbLayout = new GridBagLayout();

		this.setLayout(new GridLayout(0, 2));
		this.getContentPane().setBackground(new Color(0,204,255));
		this.add(jlbUserName);
		this.add(jtfUserName);
		this.add(jlbPassWord);
		this.add(jtfPassWord);
		this.add(jlb_blank);
		this.add(jbtnLogin);
		this.setBounds(200, 200, 500, 300);
	}
	
	
	
}
