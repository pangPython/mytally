package cn.edu.bzu.zw.mytally.view;

import java.awt.HeadlessException;
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
  * 显示所有账单列表  页面窗口
  * 
  */
public class AllTallyFrame extends JFrame {

	private List<Tally> list = null;
	private TallyService tallyService;
	private JPanel jpanel;
	private JScrollPane jScrollPane;
	private JTable jtable;
	/**
	 * 
	 */
	private static final long serialVersionUID = 4029907156241608703L;



	public AllTallyFrame(String title) throws HeadlessException {
		super(title);
		tallyService = new TallyService();
		list = tallyService.getTallys();
		jpanel = new JPanel();
		TableModel dataModel = new AbstractTableModel() {
	       /**
			 * 
			
			 */
			
			private static final long serialVersionUID = 1L;
			//设置表头
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
			//列数
			public int getColumnCount() { return 5; }
			//行数
	          public int getRowCount() { return list.size();}
	          //按二维数组格式取值
	          public Object getValueAt(int row, int col) {
	        	  Object obj = null;
	        	  switch (col) {
				case 0:
					System.out.println("row:"+row+" col:"+col);
					obj = list.get(row).getId();
					break;

				case 1:
					obj = list.get(row).getUseruuid();
					break;
				case 2:
					obj = list.get(row).getDirection();
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
	      jtable = new JTable(dataModel);
		jtable.setFillsViewportHeight(true);
		jScrollPane = new JScrollPane(jtable);
		jpanel.add(jScrollPane);
		this.setSize(600,600);
		this.add(jpanel);
	}
	
	
	

}
