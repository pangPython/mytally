package cn.edu.bzu.zw.mytally.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cn.edu.bzu.zw.mytally.bean.Tally;
import cn.edu.bzu.zw.mytally.service.TallyService;

/**
 * @Project MyTally
 * @Package cn.edu.bzu.zw.mytally.view
 * @Author pangPython
 * @Time 下午7:16:42
 * 
 * 修改账单窗体
 * 
 */
public class EditTallyFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TallyService tallyService = null;
	
	private JTextField amount = null;
	private JTextField note = null;
	private JLabel jlb_amount = null;
	private JLabel jlb_note = null;
	private JLabel jlb_shouzhi = null;
	private JLabel jlb_time = null;
	private JButton jbtn_update = null;
	private JButton jbtn_del = null;
	private JComboBox jcbDirection = null;
	
	private DateChooseJButton dateChooseJButton = null;
	
	public EditTallyFrame() throws HeadlessException {
		super();
	}
	public EditTallyFrame(String title,int tallyID) throws HeadlessException {
		super(title);
		tallyService = new TallyService();
		//根据id查到tally，把数据填入frame
		Tally tally = tallyService.getTallyById(tallyID);
		//点击保存关闭当前窗口，刷新上一个窗口
		amount = new JTextField(8);
		note = new JTextField(8);
		jlb_amount = new JLabel("金额：");
		jlb_amount.setBackground(new Color(0,204,255));
		jlb_amount.setOpaque(true);
		jlb_note = new JLabel("备注：");
		jlb_note.setBackground(new Color(0,204,255));
		jlb_note.setOpaque(true);
		jlb_shouzhi = new JLabel("收支：");
		jlb_shouzhi.setBackground(new Color(0,204,255));
		jlb_shouzhi.setOpaque(true);
		jlb_time = new JLabel("时间：");
		jlb_time.setBackground(new Color(0,204,255));
		jlb_time.setOpaque(true);
		jbtn_update = new JButton("保存");
		jbtn_del = new JButton("删除");
		dateChooseJButton = new DateChooseJButton();
		
		amount.setText(tally.getAmount()+"");
		note.setText(tally.getNote());
		
		jcbDirection = new JComboBox();
		jcbDirection.addItem("收入");
		jcbDirection.addItem("支出");
		
		if(tally.getDirection()==0){
			jcbDirection.setSelectedIndex(1);
		}
		
		this.setLayout(new GridLayout(0, 2));
		this.add(jlb_amount);
		this.add(amount);
		this.add(jlb_note);
		this.add(note);
		this.add(jlb_shouzhi);
		this.add(jcbDirection);
		this.add(jlb_time);
		this.add(dateChooseJButton);
		this.add(jbtn_update);
		this.add(jbtn_del);
		this.setSize(300,300);
		jbtn_update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tally.setAmount(Integer.parseInt(amount.getText()));
				tally.setNote(note.getText());
				if(jcbDirection.getSelectedItem().equals("收入")){
					tally.setDirection(1);
				}
				if(jcbDirection.getSelectedItem().equals("支出")){
					tally.setDirection(0);
				}
				tally.setTallytime(new Timestamp(dateChooseJButton.getDate().getTime()));
				
				if(tallyService.update(tally)>0){
					JOptionPane.showMessageDialog(null, "更新成功！!");
				}else{
					JOptionPane.showMessageDialog(null, "更新失败!");
				}
			}
		});
		jbtn_del.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tallyService.del(tally.getId())>0){
					JOptionPane.showMessageDialog(null, "删除成功！!");
				}else{
					JOptionPane.showMessageDialog(null, "删除失败!");
				}
			}
		});
//		this.pack();
	}

	
	
	
}
