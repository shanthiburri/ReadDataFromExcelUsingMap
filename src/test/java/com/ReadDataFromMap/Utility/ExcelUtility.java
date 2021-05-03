package com.ReadDataFromMap.Utility;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class ExcelUtility {
    public HashMap<String, String> dataFromExcel() throws Exception {
        HSSFWorkbook book;
        HSSFSheet sheet;
        HSSFRow row;
        HSSFCell cell;
        HashMap<String,String> data= new HashMap<>();

        FileInputStream input= new FileInputStream(new File("src/test/java/com/ReadDataFromMap/TestData/TestData.xls"));
        book = new HSSFWorkbook(input);
        sheet = book.getSheetAt(0);

        int rowCount = sheet.getLastRowNum();

        //Storing data from excel to map
        for (int r = 0; r <= rowCount; r++) {
            String key=sheet.getRow(r).getCell(0).getStringCellValue();
            String value=sheet.getRow(r).getCell(1).getStringCellValue();
            data.put(key,value);
        }
        //HashMap<Integer,String> sortMap=sortValues(data);
        //Read data from hash map

           /* for(Map.Entry entry:data.entrySet())
            {
                System.out.println(entry.getKey()+"     "+entry.getValue());
            }*/

        return data;
    }
    private static HashMap sortValues(HashMap map)
    {
        List list = new LinkedList(map.entrySet());
//Custom Comparator
        Collections.sort(list, new Comparator()
        {
            public int compare(Object o1, Object o2)
            {
                return ((Comparable) ((Map.Entry) (o1)).getKey()).compareTo(((Map.Entry) (o2)).getKey());
            }
        });
//copying the sorted list in HashMap to preserve the iteration order
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();)
        {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
}
