package com.works.framework.core;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.IOException;


public class ExcelOperations {
    FileInputStream inputStream;
    Workbook workbook;
    Sheet sheet;


    /**
     * This method takes Sheet and index number (row, column)
     *
     * @param filePath
     * @param Sheet
     * @param Row
     * @param Col
     * @return "Value" the cell contents
     */
    public String getData(String filePath, int Sheet, int Row, int Col) {
        getConnection(filePath, Sheet);
        String Value = " ";
        org.apache.poi.ss.usermodel.Row row = sheet.getRow(Row - 1);
        Value += row.getCell(Col - 1);
        Value = Value.trim();
        if (Value.length() <= 0) {
            Value = "EMPTY";
            Assert.fail("No value found in the provided index");
        }
        closeSession();
        return Value;
    }

    public String getDataSpecific(String filePath, int Sheet, int Row, int Col) {
        getConnection(filePath, Sheet);
        String Value = " ";
        org.apache.poi.ss.usermodel.Row row = sheet.getRow(Row - 1);
        Value += row.getCell(Col - 1);
        Value = Value.trim();
        closeSession();
        return Value;
    }

    void getConnection(String filePath, int Sheet) {
        String userprofile = System.getenv("USERPROFILE");
        filePath = filePath.replace("%USERPROFILE%", userprofile);

        if (Sheet < 1) {
            Sheet = 1;
        }
        workbook = null;
        inputStream = null;
        try {
            inputStream = new FileInputStream(filePath);
            workbook = WorkbookFactory.create(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert workbook != null;
        sheet = workbook.getSheetAt(Sheet - 1);

    }

    void closeSession() {
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
