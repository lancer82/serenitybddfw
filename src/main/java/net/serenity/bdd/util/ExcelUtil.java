package net.serenity.bdd.util;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author Thinlk
 * @create 2020-12-01 8:45 PM
 **/
public class ExcelUtil {

    /*
     * 处理excel数据，返回参数流格式
     * 使用POI进行excel数据解析
     */
    public static List<Map<String,Object>> getExcelDataFromFile(String ExcelFilePath, String SheetName){
        List<Map<String,Object>> returnList = new ArrayList<>();
        try(Workbook workbook = WorkbookFactory.create(new File(ExcelFilePath))) {
            Sheet dataSheet = workbook.getSheet(SheetName);
            //excel数据格式处理对象
            DataFormatter dfm = new DataFormatter();
            List<String> keyList = new ArrayList<>();
            for(Row row: dataSheet) {
                int cellNum = 0;
                Map<String,Object> map = new HashMap<>();
                if (row.getRowNum() == 0) {
                    for(Cell cell : row) {
                        keyList.add(dfm.formatCellValue(cell));
                    }
                    continue;
                }

                for(Cell cell: row) {
                    map.put(keyList.get(cellNum),dfm.formatCellValue(cell));
                    cellNum++;
                }
                //组装为Stream数据流
                returnList.add(map);
            }
            return returnList;
        } catch (EncryptedDocumentException | IOException e) {
            e.printStackTrace();
        }
        return returnList;

    }

    public static void main(String[] args) throws NoSuchFieldException {
        List<Map<String,Object>> excelData = getExcelDataFromFile("D:\\Project\\serenitybddfw\\src\\test\\resources\\envData.xlsx","Sheet1");
        Object obj = excelData.stream()
                .filter(x->x.containsValue("Rightname"))
                .findFirst()
                .orElseThrow(NoSuchFieldException::new)
                .get("User name");
        System.out.println(obj);
    }
}
