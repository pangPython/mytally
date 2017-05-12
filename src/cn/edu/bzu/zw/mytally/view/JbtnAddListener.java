package cn.edu.bzu.zw.mytally.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;

import cn.edu.bzu.zw.mytally.bean.Tally;
import cn.edu.bzu.zw.mytally.service.TallyService;

public class JbtnAddListener implements ActionListener {

	private AddTallyFrame addTallyFrame = null;
	
	
	public JbtnAddListener(AddTallyFrame addTallyFrame) {
		this.addTallyFrame = addTallyFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//获取当前时间
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());	
		//获取当前用户的UUID
		String uuid = null;
		try {
			uuid = FileUtils.readFileToString(new File("temp/user.dat"), "utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		int amount = Integer.parseInt(addTallyFrame.getJtfAmount().getText());
		String note = addTallyFrame.getJtfNote().getText();
		//收入1还是支出0
		int direction = 0;
		if(addTallyFrame.getJcbDirection().getSelectedItem().equals("收入")){
			direction = 1;
		}
		//写入数据库
		Tally tally = new Tally();
		tally.setAmount(amount);
		tally.setDirection(direction);
		tally.setNote(note);
		tally.setTallytime(timestamp);
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
