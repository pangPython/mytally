package cn.edu.bzu.zw.mytally.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.JPanel;

import org.apache.commons.io.FileUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

import cn.edu.bzu.zw.mytally.bean.Tally;
import cn.edu.bzu.zw.mytally.service.TallyService;

public class AnalysisFrame extends ApplicationFrame {

	private static final long serialVersionUID = -4172191391806537567L;
	
	
	private TallyService tallyService = new TallyService();;

	public AnalysisFrame(String s) {
	        super(s);
	        XYDataset xydataset = createDataset();
	        JFreeChart jfreechart = createChart(xydataset);
	        ChartPanel chartpanel = new ChartPanel(jfreechart, false);
	        chartpanel.setPreferredSize(new Dimension(500, 270));
	        chartpanel.setMouseZoomable(true, false);
	        setContentPane(chartpanel);
	        this.setSize(600, 600);
	    }
	private JFreeChart createChart(XYDataset xydataset) {
		 //创建主题样式  
	       StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
	       //设置标题字体  
	       standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));  
	       //设置图例的字体  
	       standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));  
	       //设置轴向的字体  
	       standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));  
	       //应用主题样式  
	       ChartFactory.setChartTheme(standardChartTheme);  
	        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart(
	        		"收入支出流水统计", "日期", "金额",
	                xydataset, true, true, true);
	        jfreechart.setBackgroundPaint(Color.white);
	        XYPlot xyplot = (XYPlot) jfreechart.getPlot();
	        xyplot.setBackgroundPaint(Color.lightGray);
	        xyplot.setDomainGridlinePaint(Color.white);
	        xyplot.setRangeGridlinePaint(Color.white);
	        xyplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
	        xyplot.setDomainCrosshairVisible(true);
	        xyplot.setRangeCrosshairVisible(true);
	        org.jfree.chart.renderer.xy.XYItemRenderer xyitemrenderer = xyplot
	                .getRenderer();
	        if (xyitemrenderer instanceof XYLineAndShapeRenderer) {
	            XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) xyitemrenderer;
	            xylineandshaperenderer.setBaseShapesVisible(true);
	            xylineandshaperenderer.setBaseShapesFilled(true);
	        }
	        DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
	        dateaxis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
	        return jfreechart;
	    }
	private  XYDataset createDataset() {
		String uid = null;
		try {
			//获取用户uuid
			uid = FileUtils.readFileToString(new File("temp/user.dat"), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//支出列表
		List<Tally> outList = new ArrayList<>();
		outList = tallyService.getoutList(uid);
		//收入列表
		List<Tally> inList = new ArrayList<>();
		inList = tallyService.getinList(uid);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
		TimeSeries timeseries = new TimeSeries("支出","http://www.bzu.edu.cn","");
	        for (Tally tally : outList) {
	        	System.out.println(simpleDateFormat.format(tally.getTallytime()));
	        	System.out.println(tally.getTallytime());
	        	System.out.println(Integer.parseInt(simpleDateFormat.format(tally.getTallytime()).substring(4, 6)));
//	        	timeseries.add();
	        	timeseries.add(new Month(Integer.parseInt(simpleDateFormat.format(tally.getTallytime()).substring(4, 6)), Integer.parseInt(simpleDateFormat.format(tally.getTallytime()).substring(0, 3))), tally.getAmount());
			}
	        TimeSeries timeseries1 = new TimeSeries("收入","http://www.bzu.edu.cn","");
	        for (Tally tally : inList) {
	        	System.out.println(tally.getTallytime().getDay());
	        	timeseries1.add(new Month(Integer.parseInt(simpleDateFormat.format(tally.getTallytime()).substring(4, 6)), Integer.parseInt(simpleDateFormat.format(tally.getTallytime()).substring(0, 3))), tally.getAmount());
			}
	        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
	        timeseriescollection.addSeries(timeseries);
	        timeseriescollection.addSeries(timeseries1);
	        return timeseriescollection;
	    }
	public  JPanel createDemoPanel() {
	        JFreeChart jfreechart = createChart(createDataset());
	        return new ChartPanel(jfreechart);
	    }
	// 根据JFreeChart对象生成对应的图片
	    public  String generateLineChart(HttpSession session, PrintWriter pw) {
	        String filename = null;
	        JFreeChart chart = createChart(createDataset());
	        // chart.setBackgroundPaint(java.awt.Color.white);
	ChartRenderingInfo info = new ChartRenderingInfo(
	                new StandardEntityCollection());
	        try {
	            filename = ServletUtilities.saveChartAsPNG(chart, 500, 350, info,
	                    session);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        try {
	            ChartUtilities.writeImageMap(pw, filename, info, false);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        pw.flush();
	        return filename;
	    }
	public static void main(String args[]) {
	        AnalysisFrame timeseriesdemo1 = new AnalysisFrame(
	                "分析统计");
	        timeseriesdemo1.pack();
	        RefineryUtilities.centerFrameOnScreen(timeseriesdemo1);
	        timeseriesdemo1.setVisible(true);
	    }

	
}
