package com.cybertek.tests.day11_FileUpload;

import org.testng.annotations.Test;

public class FilePathExample {

    @Test
    public void test(){

        String projectPath = System.getProperty("user.dir");
        String relativePath = "src/test/resources/testfile.txt";

        System.out.println("projectPath " + projectPath);

        String filePath = projectPath + "/"+relativePath;
        System.out.println("filePath "+  filePath);


    }
}
