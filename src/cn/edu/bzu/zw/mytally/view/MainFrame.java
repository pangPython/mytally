package cn.edu.bzu.zw.mytally.view;

import java.awt.HeadlessException;

import javax.swing.JFrame;



/**
 * @author zhangwei
 *
 */
public class MainFrame extends JFrame{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5076904787858673080L;

	public MainFrame() throws HeadlessException {
		super();
	}

	public MainFrame(String title) throws HeadlessException {
		this.setBounds(300,300,800,700);
	}
	
}
