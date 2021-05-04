package com.ReadDataFromMap.TestCase;

import com.ReadDataFromMap.Utility.ExcelUtility;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

@RunWith(Parameterized.class)
public class TestCase_1 {
    String id;
    String res;

    @Parameterized.Parameters
    public static Collection excelData() throws Exception {
        return Arrays.asList(new String[][]{
                {"TC_001", "Pass"},
                {"TC_002", "Fail"},
                {"TC_003", "Fail"},
                {"TC_004", "Pass"},
                {"TC_005", "Pass"},
                {"TC_006", "Pass"}});
    }

    public TestCase_1(String id, String res) {
        super();
        this.id = id;
        this.res = res;
    }

    @Test
    public void test() throws Exception {
        ExcelUtility excel = new ExcelUtility();
        HashMap<String, String> values = excel.dataFromExcel();
        ArrayList<String> key = new ArrayList<>(values.keySet());
        ArrayList<String> value = new ArrayList<>(values.values());
        for (int i = 0; i < key.size(); i++) {
            //System.out.println(key.get(i));
            if (id.equals(key.get(i))) {

                Assert.assertEquals(id, key.get(i));
               //System.out.println(id + "  " + key.get(i));

                break;
            }
        }

    }
}
