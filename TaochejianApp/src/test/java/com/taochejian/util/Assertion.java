package com.taochejian.util;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

public class Assertion {
    public static boolean flag = true;    
    public static List<Error> errors = new ArrayList<Error>();  
	
    public static void assertEquals(Object actual, Object expected, String message){
        try{
            Assert.assertEquals(actual, expected, message);
        } catch (Error e){
            errors.add(e);
            flag = false;
        }
    }
}
