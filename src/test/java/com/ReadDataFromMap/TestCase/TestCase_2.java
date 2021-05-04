package com.ReadDataFromMap.TestCase;

import com.ReadDataFromMap.Utility.ExcelReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

@RunWith(Parameterized.class)
public class TestCase_2 {
    String key;
    String expected;
    ExcelReader reader;
    @Parameterized.Parameters
    public static Collection excelData() throws Exception {
        return Arrays.asList(new String[][]{
                {"baseURL", "http://demo.nopcom.com"},
                {"Username", "User1234"},
                {"PassWord", "pass1234"},
                {"FirstName", "Bob"},
                {"LastName", "Johns"},
                {"Address", "Beeramguda,abcd avenue,NY"}});
    }

    public TestCase_2(String key, String expected) {
        super();
        this.key = key;
        this.expected =expected;
    }
    @Before
    public void setUp()
    {
        reader=new ExcelReader();
    }

    @Test
    public void test() throws Exception {
        System.out.println("Expected "+expected);
        System.out.println("Actual "+reader.getValue(key));

        Assert.assertEquals(expected,reader.getValue(key));
        //System.out.println(key);

           }
        }


