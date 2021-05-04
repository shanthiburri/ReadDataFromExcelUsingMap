package com.ReadDataFromMap.Utility;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {
    public static final String EXCELFILELOCATION="src\\test\\java\\com\\ReadDataFromMap\\TestData\\Data.xls";
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
    public static Map<String, Map<String,String>> getDataMap() throws Exception {
        if(sheet==null)
        {
            loadExcel();
        }
        Map<String,Map<String,String>> superMap= new HashMap<String, Map<String, String>>();
        Map<String,String> myMap=new HashMap<String,String>();
        for(int i=1;i<sheet.getLastRowNum()+1;i++) {
            row = sheet.getRow(i);
            String keyCell = row.getCell(0).getStringCellValue();
            //int cellNum = row.getLastCellNum();
           // for (int j = 1; j < cellNum; j++) {
                String value = row.getCell(1).getStringCellValue();
                myMap.put(keyCell, value);
            //}
            superMap.put("MASTERDATA",myMap);
        }
        return superMap;
    }
    public static String getValue(String key) throws Exception {
        Map<String,String> val=getDataMap().get("MASTERDATA");
        String retVal=val.get(key);
       // System.out.println("retVal "+retVal);
        return retVal;
    }
   /* public static  void main(String[] args) throws Exception {
        System.out.println(getValue("baseURL"));
        System.out.println(getValue("Username"));
        System.out.println(getValue("PassWord"));
        System.out.println(getValue("FirstName"));
        System.out.println(getValue("LastName"));
        System.out.println(getValue("Address"));
    }*/
}
