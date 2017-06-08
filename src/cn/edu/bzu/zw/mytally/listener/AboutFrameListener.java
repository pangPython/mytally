package cn.edu.bzu.zw.mytally.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.edu.bzu.zw.mytally.view.AboutFrame;

/**
 * @Project MyTally
 * @Package cn.edu.bzu.zw.mytally.listener
 * @Author ZhangWei
 * @Time 上午9:59:31
 * 关于按钮监听器
 * 
 */
public class AboutFrameListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		AboutFrame aboutFrame = new AboutFrame("关于");
		aboutFrame.setVisible(true);
	}

}
