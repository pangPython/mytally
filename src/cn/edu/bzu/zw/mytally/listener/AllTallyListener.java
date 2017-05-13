package cn.edu.bzu.zw.mytally.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.edu.bzu.zw.mytally.view.AllTallyFrame;

public class AllTallyListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		AllTallyFrame allTallyFrame = new AllTallyFrame("全部账单");
		allTallyFrame.setVisible(true);
	}

}
