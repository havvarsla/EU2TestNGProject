package com.cybertek.tests.day7_testNg;

import org.testng.annotations.*;

public class BeforeAfterTests {
    @Test
    public void test1(){
        System.out.println("This is my test 1");
        //close browser , quit
    }

    @Ignore
    @Test
    public void test2(){
        System.out.println("This is my test 2");
    }

    @Test
    public void test3(){
        System.out.println("This is my test 3");
    }

    @BeforeMethod
    public void setUp(){
        //Web driver part
        System.out.println("BEFORE method here ");
        System.out.println("Webdriver part");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("AFTER method here");
        System.out.println("Driver quit");
    }

    @BeforeClass
    public void setUpClass(){
        System.out.println("--BEFORE CLASS---");
        System.out.println("Runs only once in a class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("---AFTER CLASS---");
    }
}
