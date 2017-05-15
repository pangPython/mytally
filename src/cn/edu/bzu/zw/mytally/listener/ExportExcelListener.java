package cn.edu.bzu.zw.mytally.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cn.edu.bzu.zw.mytally.view.ExplortExcelFrame;

/**
 * @Project MyTally
 * @Package cn.edu.bzu.zw.mytally.listener
 * @Author ZhangWei
 * @Time 下午10:17:07
 */
public class ExportExcelListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ExplortExcelFrame excelFrame = new ExplortExcelFrame("导出账单");
		excelFrame.setVisible(true);
	}

}
