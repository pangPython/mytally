package cn.edu.bzu.zw.mytally.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.edu.bzu.zw.mytally.view.AddTallyFrame;

public class AddTallyListener implements ActionListener {
	AddTallyFrame addTallyFrame = null;

	@Override
	public void actionPerformed(ActionEvent arg0) {
//		JOptionPane.showMessageDialog(null, "添加账目");
		addTallyFrame = new AddTallyFrame("添加账目");
		addTallyFrame.setVisible(true);
	}

}
