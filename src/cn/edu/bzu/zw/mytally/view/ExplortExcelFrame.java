package cn.edu.bzu.zw.mytally.view;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.edu.bzu.zw.mytally.bean.Tally;
import cn.edu.bzu.zw.mytally.service.TallyService;
import cn.edu.bzu.zw.mytally.utils.MyPOI;

/**
 *  @package cn.edu.bzu.zw.mytally.view
 *  @project MyTally
 *	@author zhangwei
 * 	@time 2017年6月8日 下午3:57:14
 * 	导出Excel 页面窗口 使用apache的poi项目jar包把数据库的账单列表导出到Excel中
 */
public class ExplortExcelFrame extends JFrame {

	private TallyService tallyService = null;
	private static final long serialVersionUID = -4036644840318014383L;

	public ExplortExcelFrame() throws HeadlessException {
		super();
	}

	public ExplortExcelFrame(String title) throws HeadlessException {
		super(title);
		tallyService = new TallyService();
		List<Tally> list = new ArrayList<>();
		list = tallyService.getTallys();
		String path = null;
		if((path = MyPOI.exportList2Excel(list))!=null){
			JOptionPane.showMessageDialog(null, "请查看项目根目录下："+path);
		}else{
			JOptionPane.showMessageDialog(null, "导出失败！");
			
		}
	}
	
}
