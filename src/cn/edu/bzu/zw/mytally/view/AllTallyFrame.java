package cn.edu.bzu.zw.mytally.view;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import cn.edu.bzu.zw.mytally.bean.Tally;
import cn.edu.bzu.zw.mytally.service.TallyService;

/**
 * @Project MyTally
 * @Package cn.edu.bzu.zw.mytally.view
 * @Author zw
 * @Time 下午11:18:45
 * 
 *   显示所有账单列表 页面窗口
 * 
 */
public class AllTallyFrame extends JFrame {

	private List<Tally> list = null;
	private TallyService tallyService;
	private JPanel jpanel;
	private JScrollPane jScrollPane;
	private JTable jtable;
	private static final long serialVersionUID = 4029907156241608703L;

	public AllTallyFrame(String title) throws HeadlessException {
		super(title);
		tallyService = new TallyService();
		list = tallyService.getTallys();
		jpanel = new JPanel();
		//给jtable绑定数据模型
		TableModel dataModel = new AbstractTableModel() {
		private static final long serialVersionUID = 1L;

			// 设置表头
			@Override
			public String getColumnName(int i) {
				String name = "";
				switch (i) {
				case 0:
					name = "ID";
					break;
				case 1:
					name = "用户ID";
					break;
				case 2:
					name = "支出/收入";
					break;
				case 3:
					name = "数目";
					break;
				case 4:
					name = "备注";
					break;
				case 5:
					name = "时间";
					break;
				}
				return name;
			}
			// 列数
			public int getColumnCount() {
				return 6;
			}
			// 行数
			public int getRowCount() {
				return list.size();
			}
			// 按二维数组格式取值
			public Object getValueAt(int row, int col) {
				Object obj = null;
				switch (col) {
				case 0:
					obj = list.get(row).getId();
					break;
				case 1:
					obj = list.get(row).getUseruuid();
					break;
				case 2:
					if(list.get(row).getDirection() == 0){
						obj = "支出";
					}
					if(list.get(row).getDirection() == 1){
						obj = "收入";
					}
					break;
				case 3:
					obj = list.get(row).getAmount();
					break;
				case 4:
					obj = list.get(row).getNote();
					break;
				case 5:
					obj = list.get(row).getTallytime();
					break;
				}
				return obj;

			}
		};
		//把数据源与jtable绑定
		jtable = new JTable(dataModel);
		jtable.setFillsViewportHeight(true);
		jtable.setPreferredScrollableViewportSize(new Dimension(800,800));
		
		jtable.addMouseListener(new MouseListener() {
			
			private EditTallyFrame editTallyFrame;

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("======"+jtable.getValueAt(jtable.getSelectedRow(), 0));
				int tallyID = (int) jtable.getValueAt(jtable.getSelectedRow(), 0);
				editTallyFrame = new EditTallyFrame("修改收支",tallyID);
				editTallyFrame.setVisible(true);
			}
		});
		
		//设置可滚动
		jScrollPane = new JScrollPane(jtable);
		jpanel.add(jScrollPane);
		this.setSize(900, 900);
		this.add(jpanel);
	}

}
