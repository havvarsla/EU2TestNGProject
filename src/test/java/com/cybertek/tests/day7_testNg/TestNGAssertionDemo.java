package com.cybertek.tests.day7_testNg;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestNGAssertionDemo {

    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals("title","tiTle");

        System.out.println("Second Assertion");
        Assert.assertEquals(1,1);

    }

    @Test
    public void test2(){
        System.out.println("Second Test case");
        Assert.assertEquals("url", "url");
    }

    @Test
    public void test3(){
        //Verify the title start with cyb
        String expectedTitle = "Cby";
        String actualTitle = "Cybertek";

        Assert.assertTrue(actualTitle.startsWith(expectedTitle), "Verify title start with cyb");
        Assert.assertTrue(1>1, "I am checking 2 id greater than 1");
    }

    @Test
    public void test4(){
        //Verify that email contains
        String email = "mikesmith.com";
        Assert.assertTrue(email.contains("@"), "Verify email has @ sign");

        System.out.println("Test case 4");
    }

    @Test
    public void test5(){
        //Verify something is false
        Assert.assertFalse(0>1, "verify that 0 is not greater than 1");
    }


}
