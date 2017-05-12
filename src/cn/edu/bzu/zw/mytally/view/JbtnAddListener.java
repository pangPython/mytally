package cn.edu.bzu.zw.mytally.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import cn.edu.bzu.zw.mytally.bean.Tally;
import cn.edu.bzu.zw.mytally.service.TallyService;

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
		Tally tally = new Tally();
		TallyService service = new TallyService();
		if(service.add(tally)){
			JOptionPane.showMessageDialog(null, "添加成功！");
			addTallyFrame.setVisible(false);
		}else{
			
			JOptionPane.showMessageDialog(null, "添加失败！");
		}
	}

}
