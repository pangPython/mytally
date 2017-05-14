package cn.edu.bzu.zw.mytally.view;

import java.awt.GridBagLayout;
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

public class LoginFrame extends JFrame{

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 260523489127732335L;
	
	private JLabel jlbUserName = null;
	private LoginJLBUserNameGBC JLBUserNameGBC = null;
	private JLabel jlbPassWord = null;
	private LoginJLBPassWordGBC JLBPwdGBC = null;
	
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
		jtfUserName = new JTextField(8);
		jtfPassWord = new JTextField(8);
		jbtnLogin = new JButton("登录");
		
		jtfUserName.setText("admin");
		jtfPassWord.setText("admin");
		
		
		JLBUserNameGBC = new LoginJLBUserNameGBC();
		JLBPwdGBC = new LoginJLBPassWordGBC();
		JTFUserNameGBC = new LoginJTFUserNameGBC();
		JTFPwdGBC = new LoginJTFPwdGBC();
		JBTNLoginGBC = new LoginJBTNLoginGBC();
		
		loginListener = new LoginBtnListener(this);
		
		
		jbtnLogin.addActionListener(loginListener);
		jbtnLogin.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
		gbLayout = new GridBagLayout();
		
		this.setLayout(gbLayout);
		
		this.add(jlbUserName,JLBUserNameGBC);
		this.add(jtfUserName,JTFUserNameGBC);
		this.add(jlbPassWord,JLBPwdGBC);
		this.add(jtfPassWord,JTFPwdGBC);
		this.add(jbtnLogin,JBTNLoginGBC);
		
		this.setBounds(200, 200, 400, 400);
		
	}
	
	
	
}
