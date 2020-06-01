package com.cybertek.tests.day19_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {
    @Test
    public void readExcelFile(){
        //create an object from ExcelUtil
        //it accepts two argument
        //Argument 1: location of the file(path)
        //Argument 2: sheet that we want to open(sheetName)
       ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        //How many rows in a sheet
        System.out.println("Row count = "+qa3short.rowCount());

        //how many columns in the sheet
        System.out.println("Colun count = "+ qa3short.columnCount());

        //get all column names
        System.out.println("Column names = "+ qa3short.getColumnsNames());

        //get all data in list of maps
        List<Map<String, String>> dataList = qa3short.getDataList();
//
//        for (Map<String, String> onerow : dataList){
//            System.out.println(onerow);
//    }

        System.out.println(dataList.get(8).get("lastname"));
        qa3short.getCellData(2,2);

        //get all data in 2D array
        String [][] dataArray = qa3short.getDataArray();
        //print 2d array
        System.out.println(Arrays.deepToString(dataArray));



    }

}
