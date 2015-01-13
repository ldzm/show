package edu.ldzm.show;

import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Symbol;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.data.LineData;
import com.github.abel533.echarts.series.Line;

/**
 * Hello world!
 *
 */
public class AverageRequestTime 
{
	
    public static void main( String[] args )
    {
    	//例子：http://echarts.baidu.com/doc/example/line.html
        EnhancedOption option = new EnhancedOption();
        option.tooltip().trigger(Trigger.axis);
        option.legend("Http Request", "Java Request");
        option.toolbox().show(true);
        option.calculable(true);
        option.xAxis(new CategoryAxis().boundaryGap(false).data("周一", "周二", "周三", "周四", "周五", "周六", "周日"));
        option.yAxis(new ValueAxis());
        option.series(new Line().smooth(true).name("Http Request").stack("总量").symbol(Symbol.none).data(120, 132, 301, 134, new LineData(90, Symbol.droplet, 5), 230, 210));


        //实现不了js的这个效果
        //line.itemStyle.normal.areaStyle = new AreaStyle();
        LineData lineData = new LineData(201, Symbol.star, 15);
        lineData.itemStyle().normal().label().show(true).textStyle().fontSize(20).fontFamily("微软雅黑").fontWeight("bold");
        option.series(new Line().smooth(true).name("Java Request").stack("总量").symbol("image://http://echarts.baidu.com/doc/asset/ico/favicon.png").symbolSize(8).data(120, 82, lineData, new LineData(134, Symbol.none), 190, new LineData(230, Symbol.emptypin, 8), 110));

        option.exportToHtml("line.html");
        option.view();
    }
}
