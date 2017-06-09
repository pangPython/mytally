package cn.edu.bzu.zw.mytally.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;

import cn.edu.bzu.zw.mytally.bean.Tally;
import cn.edu.bzu.zw.mytally.service.TallyService;
import cn.edu.bzu.zw.mytally.view.AddTallyFrame;

/**
 *  @package cn.edu.bzu.zw.mytally.listener
 *  @project MyTally
 *	@author zhangwei
 * 	@time 2017年6月8日 下午3:48:20
 * 	添加账单页面-添加按钮 监听器
 * 
 */
public class JbtnAddListener implements ActionListener {

	private AddTallyFrame addTallyFrame = null;
	
	
	public JbtnAddListener(AddTallyFrame addTallyFrame) {
		this.addTallyFrame = addTallyFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//获取当前用户的UUID
		String uuid = null;
		try {
			//读取文件中记录的用户uuid
			uuid = FileUtils.readFileToString(new File("temp/user.dat"), "utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//获取用户添加的金额
		int amount = Integer.parseInt(addTallyFrame.getJtfAmount().getText());
		//获取用户添加的备注
		String note = addTallyFrame.getJtfNote().getText();
		//收入1 支出0
		int direction = 0;
		if(addTallyFrame.getJcbDirection().getSelectedItem().equals("收入")){
			direction = 1;
		}
		//封装成tally对象 写入数据库
		Tally tally = new Tally();
		tally.setAmount(amount);
		tally.setDirection(direction);
		tally.setNote(note);
		//账单添加时间 传入null，数据库自动写入当前时间戳
		tally.setTallytime(null);
		tally.setUseruuid(uuid);
		TallyService service = new TallyService();
		if(service.add(tally)){
			JOptionPane.showMessageDialog(null, "添加成功！");
			addTallyFrame.setVisible(false);
		}else{
			JOptionPane.showMessageDialog(null, "添加失败！");
		}
	}

}
