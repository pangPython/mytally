package cn.edu.bzu.zw.mytally.view;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private JLabel jlb_amount = null;
	private JButton jbtn_update = null;
	
	public EditTallyFrame() throws HeadlessException {
		super();
	}

	public EditTallyFrame(String title,int tallyID) throws HeadlessException {
		super(title);
		tallyService = new TallyService();
		//根据id查到tally，把数据填入frame
		Tally tally = tallyService.getTallyById(tallyID);
		//点击保存关闭当前窗口，刷新上一个窗口
		amount = new JTextField(5);
		jlb_amount = new JLabel("金额：");
		jbtn_update = new JButton("保存");
		amount.setText(tally.getAmount()+"");
		this.setLayout(new FlowLayout());
		this.add(jlb_amount);
		this.add(amount);
		this.add(jbtn_update);
		this.setSize(300,300);
		jbtn_update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tally.setAmount(Integer.parseInt(amount.getText()));
				
			}
		});
	}

	
	
	
}
