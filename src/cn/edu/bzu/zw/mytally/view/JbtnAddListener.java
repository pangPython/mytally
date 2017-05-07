package cn.edu.bzu.zw.mytally.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class JbtnAddListener implements ActionListener {

	private AddTallyFrame addTallyFrame = null;
	
	
	public JbtnAddListener(AddTallyFrame addTallyFrame) {
		this.addTallyFrame = addTallyFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String amount = addTallyFrame.getJtfAmount().getText();
		String note = addTallyFrame.getJtfNote().getText();
		//写入数据库
		/*Tally t = new Tally();
		t.set("userid", 1).set("amount", 100).set("direction", 1).set("note", "买菜").save();
		*/
			JOptionPane.showMessageDialog(null, "添加成功！");
	}

}
