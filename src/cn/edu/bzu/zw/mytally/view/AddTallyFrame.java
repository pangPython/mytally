package cn.edu.bzu.zw.mytally.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.edu.bzu.zw.mytally.listener.JbtnAddListener;


/**
 *  @package cn.edu.bzu.zw.mytally.view
 *  @project MyTally
 *	@author zhangwei
 * 	@time 2017年6月8日 下午3:55:12
 * 添加账目窗口页面
 * 
 */
public class AddTallyFrame extends JFrame {

	private JPanel addTallyPanel = null;
	
	private JLabel jlbAmount = null;//金额
	private JTextField jtfAmount = null;
	private JLabel jlbDirection = null;//方向
	private JTextField jtfDirection = null;
	private JLabel jlbNote = null;//备注
	private JTextField jtfNote = null;
	private JButton jbtnAdd = null;//添加账目按钮
	private JComboBox jcbDirection = null;
	private GridLayout gridLayout = null;
	private JLabel jlb_time = null; 
	private JLabel jlb_blank = null;
	
	private DateChooseJButton dateChooseJButton = null;
	public DateChooseJButton getDateChooseJButton() {
		return dateChooseJButton;
	}

	public void setDateChooseJButton(DateChooseJButton dateChooseJButton) {
		this.dateChooseJButton = dateChooseJButton;
	}


	private JbtnAddListener jbtnAddListener;
	private static final long serialVersionUID = -4036644840318014383L;

	
	
	
	public JTextField getJtfAmount() {
		return jtfAmount;
	}

	public void setJtfAmount(JTextField jtfAmount) {
		this.jtfAmount = jtfAmount;
	}

	public JTextField getJtfNote() {
		return jtfNote;
	}

	public void setJtfNote(JTextField jtfNote) {
		this.jtfNote = jtfNote;
	}

	public JComboBox getJcbDirection() {
		return jcbDirection;
	}

	public void setJcbDirection(JComboBox jcbDirection) {
		this.jcbDirection = jcbDirection;
	}

	public AddTallyFrame() throws HeadlessException {
		super();
	}

	public AddTallyFrame(String title) throws HeadlessException {
		super(title);
		
		jlbAmount = new JLabel("金额：");
		jlbAmount.setBackground(new Color(0,204,255));
		jlbAmount.setOpaque(true);
		jtfAmount = new JTextField(5);
		jlbDirection = new JLabel("出/入：");
		jlbDirection.setBackground(new Color(0,204,255));
		jlbDirection.setOpaque(true);
		jtfDirection = new JTextField(5);
		jlbNote = new JLabel("备注：");
		jlbNote.setBackground(new Color(0,204,255));
		jlbNote.setOpaque(true);
		jtfNote = new JTextField(8);
		jbtnAdd = new JButton("添加");
		
		jlb_time = new JLabel("时间：");
		jlb_time.setBackground(new Color(0,204,255));
		jlb_time.setOpaque(true);
		jlb_blank = new JLabel();
		jlb_blank.setBackground(new Color(0,204,255));
		jlb_blank.setOpaque(true);
		
		dateChooseJButton = new DateChooseJButton();
		jcbDirection = new JComboBox();
		jcbDirection.addItem("收入");
		jcbDirection.addItem("支出");
		
		gridLayout = new GridLayout(0, 2);
		
		addTallyPanel = new JPanel(gridLayout);
		addTallyPanel.setBorder(BorderFactory.createLineBorder(Color.gray,2));
		
		jbtnAddListener = new JbtnAddListener(this);
		jbtnAdd.addActionListener(jbtnAddListener);
		
		this.setBounds(500,500,500,500);
		addTallyPanel.add(jlbAmount);
		addTallyPanel.add(jtfAmount);
		addTallyPanel.add(jlbDirection);
		addTallyPanel.add(jcbDirection);
		addTallyPanel.add(jlbNote);
		addTallyPanel.add(jtfNote);
		addTallyPanel.add(jlb_time);
		addTallyPanel.add(dateChooseJButton);
		addTallyPanel.add(jlb_blank);
		addTallyPanel.add(jbtnAdd);
		this.add(addTallyPanel);
//		this.pack();
	}
	
	
	public static void main(String[] args) {
		AddTallyFrame addTallyFrame = new AddTallyFrame("添加账目");
		addTallyFrame.setVisible(true);
	}
}
