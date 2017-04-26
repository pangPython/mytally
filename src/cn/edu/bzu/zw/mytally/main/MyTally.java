package cn.edu.bzu.zw.mytally.main;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import cn.edu.bzu.zw.mytally.view.LoginFrame;
import cn.edu.bzu.zw.mytally.view.MainFrame;

public class MyTally {
	private static LoginFrame loginFrame = null;
	private MainFrame mainFrame = null;
	
	public static void main(String[] args) {
		
		try {
			
			//设置本属性将改变窗口边框样式定义
	        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginFrame = new LoginFrame("个人记账系统—登录");
		loginFrame.setVisible(true);
	}
}
