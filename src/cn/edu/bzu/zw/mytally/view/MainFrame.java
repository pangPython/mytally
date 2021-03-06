package cn.edu.bzu.zw.mytally.view;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import cn.edu.bzu.zw.mytally.listener.AboutFrameListener;
import cn.edu.bzu.zw.mytally.listener.AddTallyListener;
import cn.edu.bzu.zw.mytally.listener.AllTallyListener;
import cn.edu.bzu.zw.mytally.listener.ExportExcelListener;
import cn.edu.bzu.zw.mytally.listener.StatisticalAnalysisListener;

/**
 *  @package cn.edu.bzu.zw.mytally.view
 *  @project MyTally
 *	@author zhangwei
 * 	@time 2017年6月8日 下午3:58:43
 * 	主界面
 * 
 */
public class MainFrame extends JFrame{
	private JButton addTally = null;
	private JButton allTally = null;
	private JButton statisticalAnalysis = null;//统计分析
	private JButton exportExcel = null;//导出excel
	private JButton about;
	private JButton blank;
	
	
	private AddTallyListener addTallyListener;
	private AllTallyListener allTallyListener;
	private AboutFrameListener aboutFrameListener;
	private StatisticalAnalysisListener statisticalAnalysisListener;
	private ExportExcelListener excelListener;
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
		allTallyListener = new AllTallyListener();
		addTally.addActionListener(addTallyListener);
		addTally.setIcon(new ImageIcon("res/dog1.jpg"));
		allTally = new JButton("账目清单");
		allTally.setIcon(new ImageIcon("res/dog2.jpg"));
		allTally.addActionListener(allTallyListener);
		
		statisticalAnalysis = new JButton("统计分析");
		statisticalAnalysis.setIcon(new ImageIcon("res/dog3.jpg"));
		statisticalAnalysisListener = new StatisticalAnalysisListener();
		statisticalAnalysis.addActionListener(statisticalAnalysisListener);
		
		exportExcel = new JButton("导出表格");
		exportExcel.setIcon(new ImageIcon("res/dog4.jpg"));
		excelListener = new ExportExcelListener();
		exportExcel.addActionListener(excelListener);
		
		about = new JButton("关于");
		about.setIcon(new ImageIcon("res/dog5.jpg"));
		
		blank = new JButton();
		blank.setIcon(new ImageIcon("res/dog6.jpg"));
		
		aboutFrameListener = new AboutFrameListener();
		about.addActionListener(aboutFrameListener);
		this.getContentPane().add(addTally);
		this.getContentPane().add(allTally);
		this.getContentPane().add(statisticalAnalysis);
		this.getContentPane().add(exportExcel);
		this.getContentPane().add(about);
		this.getContentPane().add(blank);
		
	}
	
	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame("个人账目管理");
		mainFrame.setVisible(true);
	}
	
}
