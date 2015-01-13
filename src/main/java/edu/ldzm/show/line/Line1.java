package edu.ldzm.show.line;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.abel533.echarts.Legend;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.Title;
import com.github.abel533.echarts.Toolbox;
import com.github.abel533.echarts.Tooltip;
import com.github.abel533.echarts.axis.Axis;
import com.github.abel533.echarts.axis.AxisLabel;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.AxisType;
import com.github.abel533.echarts.code.Magic;
import com.github.abel533.echarts.code.SeriesType;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.feature.DataView;
import com.github.abel533.echarts.feature.Feature;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.feature.Mark;
import com.github.abel533.echarts.feature.Restore;
import com.github.abel533.echarts.feature.SaveAsImage;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.MarkLine;
import com.github.abel533.echarts.series.MarkPoint;
import com.github.abel533.echarts.series.Series;
import com.google.common.collect.Lists;
import com.google.gson.Gson;

public class Line1 {

	public static void main(String[] args) {
		Option option = new Option();
		
		Title title = new Title();
		title.setText("未来一周气温变化");
		title.setSubtext("纯属虚构");
		option.setTitle(title);
		
		Tooltip tooltip = new Tooltip();
		tooltip.setTrigger(Trigger.axis);
		option.setTooltip(tooltip);
		
		Legend legend = new Legend();
		List<Object> list = Lists.newArrayList("最高气温", "最低气温");
		legend.setData(list);
		option.setLegend(legend);
		
		Toolbox toolbox = new Toolbox();
		toolbox.setShow(true);
		Map<String, Feature> map = new HashMap<String, Feature>();
		map.put("mark", new Mark());
		map.put("dataView", new DataView());
		map.put("magicType", new MagicType(Magic.line, Magic.bar));
		map.put("restore", new Restore());
		map.put("saveAsImage", new SaveAsImage());
		toolbox.setFeature(map);
		option.setToolbox(toolbox);
		
		option.setCalculable(true);
		
		Axis<CategoryAxis> xAxis = new CategoryAxis();
		xAxis.setType(AxisType.category);
		xAxis.setBoundaryGap(false);
		list = Lists.newArrayList("周一","周二","周三","周四","周五","周六","周日");
		xAxis.setData(list);
		option.setxAxis(Lists.newArrayList(xAxis));
		
		Axis<ValueAxis> yAxis = new ValueAxis();
		yAxis.setType(AxisType.value);
		AxisLabel axisLabel = new AxisLabel();
		axisLabel.setFormatter("{value} °C");
		yAxis.setAxisLabel(axisLabel);
		option.setyAxis(Lists.newArrayList(yAxis));
		
		Series<Line> series = new Line();
		series.setName("最高气温");
		series.setType(SeriesType.line);
		series.setData(Lists.newArrayList(11, 11, 15, 13, 12, 13, 10));
		MarkPoint markPoint = new MarkPoint();
		markPoint.setData(Lists.newArrayList("type : 'max', name: '最大值'", "type : 'min', name: '最小值'"));
		series.setMarkPoint(markPoint);
		MarkLine markLine = new MarkLine();
		markLine.setData(Lists.newArrayList("type : 'average', name: '平均值'"));
		series.setMarkLine(markLine);
		
		Series<Line> series2 = new Line();
		series2.setName("最低气温");
		series2.setType(SeriesType.line);
		series2.setData(Lists.newArrayList(1, -2, 2, 5, 3, 2, 0));
		MarkPoint markPoint2 = new MarkPoint();
		markPoint2.setData(Lists.newArrayList("name : '周最低', value : -2, xAxis: 1, yAxis: -1.5"));
		series2.setMarkPoint(markPoint2);
		MarkLine markLine2 = new MarkLine();
		markLine2.setData(Lists.newArrayList("type : 'average', name: '平均值'"));
		series2.setMarkLine(markLine2);
		option.setSeries(Lists.newArrayList(series, series2));
		
		System.out.println(new Gson().toJson(option));
	}
}
