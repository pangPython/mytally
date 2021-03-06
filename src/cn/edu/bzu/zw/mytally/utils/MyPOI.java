package cn.edu.bzu.zw.mytally.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import cn.edu.bzu.zw.mytally.bean.Tally;

/**
 * @Project MyTally
 * @Package cn.edu.bzu.zw.mytally.utils
 * @Author ZhangWei
 * @Time 上午7:34:50
 * 使用apache poi jar包 把数据库中的列表导出为excel
 */
public class MyPOI {

	/**
	 * 使用apache poi jar包 把列表导出为excel
	 * @param list
	 * @return
	 */
	//使用apache poi jar包 把列表导出为excel
	public static String exportList2Excel(List<Tally> list){
			Workbook wb = new HSSFWorkbook();
			CreationHelper createHelper = wb.getCreationHelper();
			Sheet sheet = wb.createSheet("new sheet");
			// 创建一个row  Rows 是从0开始的
			Row row = sheet.createRow((short) 0);
			// 创建一个 cell 并赋值
			Cell cell = row.createCell(0);
			//设置Excel表头
			cell.setCellValue(createHelper.createRichTextString("ID"));
			row.createCell(1).setCellValue(createHelper.createRichTextString("用户UUID"));
			row.createCell(2).setCellValue(createHelper.createRichTextString("收入/支出"));
			row.createCell(3).setCellValue(createHelper.createRichTextString("金额"));
			row.createCell(4).setCellValue(createHelper.createRichTextString("描述"));
			row.createCell(5).setCellValue(createHelper.createRichTextString("时间"));
			//把数据库所有数据输出到Excel中
			for (int i = 0; i < list.size(); i++) {
				Row data = sheet.createRow((short) i + 1);
				Tally tally = list.get(i);
				int id = tally.getId();
				String note = tally.getNote();
				String userUUID = tally.getUseruuid();
				Timestamp date = tally.getTallytime();
				int amount = tally.getAmount();
				int direction = tally.getDirection();
				data.createCell(0).setCellValue(id);
				data.createCell(1).setCellValue(userUUID);
				if(direction==0){
					data.createCell(2).setCellValue("支出");
				}else if (direction == 1) {
					data.createCell(2).setCellValue("收入");
				}
				data.createCell(3).setCellValue(amount);
				data.createCell(4).setCellValue(note);
				String timestamp = (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).format(date);
				data.createCell(5).setCellValue(timestamp);
			}
			//文件名 100000以内随机数
			String filename = new Random().nextInt(100000)+ ".xls";
			String path =  filename;
			File file = new File(path);
			FileOutputStream fileOut = null;
			try {
				//输出文件流
				fileOut = new FileOutputStream(path);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			try {
				//将数据写入
				wb.write(fileOut);
				fileOut.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return path;
		}
	}
