package cn.edu.bzu.zw.mytally.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.edu.bzu.zw.mytally.view.AllTallyFrame;

/**
 *  @package cn.edu.bzu.zw.mytally.listener
 *  @project MyTally
 *	@author zhangwei
 * 	@time 2017年6月8日 下午3:47:48
 * 全部账单按钮监听器
 */
public class AllTallyListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		AllTallyFrame allTallyFrame = new AllTallyFrame("全部账单");
		allTallyFrame.setVisible(true);
	}

}
