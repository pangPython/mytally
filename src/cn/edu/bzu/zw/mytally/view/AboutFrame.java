package cn.edu.bzu.zw.mytally.view;

import java.awt.Container;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *  @package cn.edu.bzu.zw.mytally.view
 *  @project MyTally
 *	@author zhangwei
 * 	@time 2017年6月8日 下午3:53:44
 * 关于 页面
 */
public class AboutFrame extends JFrame {

	private static final long serialVersionUID = -4036644840318014383L;

	public AboutFrame() throws HeadlessException {
		super();
	}

	public AboutFrame(String title) throws HeadlessException {
		super(title);
		 ImageIcon img = new ImageIcon("res/about.jpg");//这是背景图片   
	     JLabel imgLabel = new JLabel(img);//将背景图放在标签里。   
	     this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));//注意这里是关键，将背景标签添加到jfram的     LayeredPane面板里。
	     imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());//设置背景标签的位置   
	     Container cp=this.getContentPane();   
	     cp.setLayout(null);      //这里选择绝对布局管理器，对于边界布局管理器，放入控件后，无法显示背景图片；因为将整个面板都填充满了；
	     ((JPanel)cp).setOpaque(false); //这样就能显示出背景图片出来了。
	     this.setSize(600,400);
	}
	
}
