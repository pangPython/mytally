package cn.edu.bzu.zw.mytally.view;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import cn.edu.bzu.zw.mytally.listener.AddTallyListener;



/**
 * @author zhangwei
 *
 */
public class MainFrame extends JFrame{
	private JButton addTally = null;
	private JButton allTally = null;
	private JButton statisticalAnalysis = null;//统计分析
	private JButton exportExcel = null;//导出excel
	private JButton about;
	private AddTallyListener addTallyListener;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5076904787858673080L;

	public MainFrame() throws HeadlessException {
		super();
	}

	public MainFrame(String title) throws HeadlessException {
		super(title);
		this.setBounds(300,300,800,700);
		this.setLayout(new GridLayout(0, 3));
		addTally = new JButton("添加账目");
		addTallyListener  = new AddTallyListener(); 
		addTally.addActionListener(addTallyListener);
		allTally = new JButton("账目清单");
		statisticalAnalysis = new JButton("统计分析");
		exportExcel = new JButton("导出表格");
		about = new JButton("关于");
		this.getContentPane().add(addTally);
		this.getContentPane().add(allTally);
		this.getContentPane().add(statisticalAnalysis);
		this.getContentPane().add(exportExcel);
		this.getContentPane().add(about);
		
	}
	
	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame("个人账目管理");
		mainFrame.setVisible(true);
	}
	
}
