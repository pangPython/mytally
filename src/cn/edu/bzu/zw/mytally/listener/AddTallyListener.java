package cn.edu.bzu.zw.mytally.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.edu.bzu.zw.mytally.view.AddTallyFrame;


/**
 *  @package cn.edu.bzu.zw.mytally.listener
 *  @project MyTally
 *	@author zhangwei
 * 	@time 2017年6月8日 下午3:47:26
 * 	添加账目按钮监听器
 * 
 */
public class AddTallyListener implements ActionListener {
	private AddTallyFrame addTallyFrame = null;
	public AddTallyListener() {
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		addTallyFrame = new AddTallyFrame("添加账目");
		addTallyFrame.setVisible(true);
	}

}
