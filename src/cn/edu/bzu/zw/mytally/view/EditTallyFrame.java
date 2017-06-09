package cn.edu.bzu.zw.mytally.view;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
	public EditTallyFrame() throws HeadlessException {
		super();
	}
	public EditTallyFrame(String title,int tallyID) throws HeadlessException {
		super(title);
		tallyService = new TallyService();
		//根据id查到tally，把数据填入frame
		Tally tally = tallyService.getTallyById(tallyID);
		//点击保存关闭当前窗口，刷新上一个窗口
		amount = new JTextField(10);
		note = new JTextField(10);
		jlb_amount = new JLabel("金额：");
		jlb_note = new JLabel("备注：");
		jlb_shouzhi = new JLabel("收支：");
		jlb_time = new JLabel("时间：");
		jbtn_update = new JButton("保存");
		jbtn_del = new JButton("删除");
		amount.setText(tally.getAmount()+"");
		note.setText(tally.getNote());
		this.setLayout(new GridLayout(4, 2));
		this.add(jlb_amount);
		this.add(amount);
		this.add(jlb_note);
		this.add(note);
		this.add(jlb_shouzhi);
		this.add(jlb_shouzhi);
		this.add(jlb_time);
		this.add(jlb_time);
		this.add(jbtn_update);
		this.add(jbtn_del);
		this.setSize(300,300);
		jbtn_update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tally.setAmount(Integer.parseInt(amount.getText()));
				tally.setNote(note.getText());
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
	}

	
	
	
}
