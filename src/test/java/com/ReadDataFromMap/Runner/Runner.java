package com.ReadDataFromMap.Runner;

import com.ReadDataFromMap.TestCase.TestCase_1;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

//to run from command prompt we need to write seperate class like runner class
public class Runner {
    public static void main(String[] args)
    {
        Result result= JUnitCore.runClasses(TestCase_1.class);
        for(Failure failure: result.getFailures())
        {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
