package cn.edu.bzu.zw.mytally.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.edu.bzu.zw.mytally.view.AnalysisFrame;

/**
 * @Project MyTally
 * @Package cn.edu.bzu.zw.mytally.listener
 * @Author ZhangWei
 * @Time 上午10:50:01
 */
public class StatisticalAnalysisListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		AnalysisFrame analysisFrame = new AnalysisFrame("统计分析");
		analysisFrame.setVisible(true);

	}

}
