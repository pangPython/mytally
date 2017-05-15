package cn.edu.bzu.zw.mytally.view;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.edu.bzu.zw.mytally.bean.Tally;
import cn.edu.bzu.zw.mytally.service.TallyService;
import cn.edu.bzu.zw.mytally.utils.MyPOI;

public class ExplortExcelFrame extends JFrame {

	private TallyService tallyService = null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4036644840318014383L;

	public ExplortExcelFrame() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExplortExcelFrame(String title) throws HeadlessException {
		super(title);
		tallyService = new TallyService();
		List<Tally> list = new ArrayList<>();
		list = tallyService.getTallys();
		String path = null;
		if((path = MyPOI.exportList2Excel(list))!=null){
			JOptionPane.showMessageDialog(null, path);
		}else{
			JOptionPane.showMessageDialog(null, "导出失败！");
			
		}
	}
	
}
