package cn.edu.bzu.zw.mytally.view;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
  * @Project MyTally
  * @Package cn.edu.bzu.zw.mytally.view
  * @Author zw
  * @Time 下午11:18:45
  */
public class AllTallyFrame extends JFrame {

	
	private JPanel jpanel;
	private JScrollPane jScrollPane;
	private JTable jtable;
	/**
	 * 
	 */
	private static final long serialVersionUID = 4029907156241608703L;



	public AllTallyFrame(String title) throws HeadlessException {
		super(title);
		jpanel = new JPanel();
		jtable = new JTable();
		jtable.setFillsViewportHeight(true);
		jScrollPane = new JScrollPane(jtable);
		jpanel.add(jScrollPane);
		this.add(jpanel);
	}
	
	
	

}
