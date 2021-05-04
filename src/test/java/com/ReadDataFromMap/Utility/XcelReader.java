package com.ReadDataFromMap.Utility;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellUtil;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XcelReader {
    public static final String EXCELFILELOCATION="src\\test\\java\\com\\ReadDataFromMap\\TestData\\CustInfo.xls";
    private static FileInputStream inputStream;
    private static HSSFWorkbook book;
    private static HSSFSheet sheet;
    private static HSSFRow row;
    private static HSSFCell cell;

    public static void loadExcel() throws Exception
    {
        //System.out.println("Loading excel Data...");
        File file=new File (EXCELFILELOCATION);
        inputStream=new FileInputStream(file);
        book=new HSSFWorkbook(inputStream);
        sheet=book.getSheet("Sheet1");
        inputStream.close();
    }
    public static List<Map<String,String>> readAllData() throws Exception {
        if(sheet==null)
        {
            loadExcel();
        }
        List<Map<String,String>> mapList= new ArrayList<Map<String, String>>();
        int rows=sheet.getLastRowNum();
        int cells=sheet.getRow(0).getLastCellNum();

        for(int c=1;c<=cells;c++) {
            Map<String,String> myMap=new HashMap<String,String>();
           for(int r=0;r<=rows;r++)
           {
               Row row= CellUtil.getRow(r,sheet);
               String key=CellUtil.getCell(row,0).getStringCellValue();
               String value=CellUtil.getCell(row,c).getStringCellValue();
               myMap.put(key,value);
           }
           mapList.add(myMap);
        }
        return mapList;
    }
    public static void retrieveData(List<Map<String,String>> readAllData,String key) throws Exception {
        for(Map<String,String> m:readAllData)
        {
            m.get(key);
        }
    }
    public static void main(String[] args) throws Exception {
       XcelReader read=new XcelReader();
       List<Map<String,String>> li=read.readAllData();
       for(Map<String,String> m:li)
       {
          System.out.println(m.get("001"));
       }
          }


}
