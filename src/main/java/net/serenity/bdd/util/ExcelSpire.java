package net.serenity.bdd.util;

import com.spire.xls.CellRange;
import com.spire.xls.ExcelVersion;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;

import java.awt.*;


public class ExcelSpire {

    public static void main(String[] args) {
        //加载示例Excel文档
        Workbook workbook = new Workbook();
        workbook.loadFromFile("C:\\Test1DesktopSample.xlsx");
        // 获取第一个工作表
        Worksheet sheet = workbook.getWorksheets().get(0);
        // 查找工作表中的指定文字
        CellRange[] ranges = sheet.findAllString("人资部", true, true);
        for (CellRange range : ranges)        {
            // 用新文本替换指定文字
            range.setText("研发部");
            // 设置高亮颜色
            range.getStyle().setColor(Color.yellow);
        }
        //保存结果文档
        workbook.saveToFile("output/replaceAndHighlight_result.xlsx", ExcelVersion.Version2010);

    }
}
