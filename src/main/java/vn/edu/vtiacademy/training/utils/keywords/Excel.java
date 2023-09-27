package vn.edu.vtiacademy.training.utils.keywords;

import java.io.*;
import java.text.MessageFormat;
import java.util.*;

import org.apache.commons.math3.analysis.function.Constant;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import vn.edu.vtiacademy.training.utils.helper.LogHelper;

import javax.xml.transform.Result;

public class Excel {
    private static final Logger logger = LogHelper.getLogger();
    private static XSSFSheet sheet;
    private static XSSFWorkbook exampleWorkBook;
    private static XSSFCell cell;
    private static XSSFRow row;

    public static void getSheet(String filePath, String sheetName) throws IOException {
        File file = new File(filePath);
        try {
            FileInputStream inputStream = new FileInputStream(file);
            XSSFWorkbook exampleWorkBook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = exampleWorkBook.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getCellData(int rowNum, int cellNum) throws Exception {
        try {
            XSSFCell cell = sheet.getRow(rowNum).getCell(cellNum);
            String cellData = cell.getStringCellValue();
            return cellData;
        } catch (Exception e) {
            return "";
        }

    }

    public static void setCellData(String filePath, String result, int rowNum, int colNum) throws Exception {
        try {
            XSSFRow row = sheet.getRow(rowNum);
            cell = row.getCell(colNum);
            if (cell == null) {
                cell = row.createCell(colNum);
                cell.setCellValue(result);
            } else {
                cell.setCellValue(result);
            }

            FileOutputStream fileOut = new FileOutputStream(filePath);
            exampleWorkBook.write(fileOut);
            fileOut.flush();
            fileOut.close();

        } catch (Exception e) {
            throw e;
        }
    }

    public static Map<String, Map<String, String>> readDataFileExcel(String fileExcelPath, String sheetName) {
        File file = new File(fileExcelPath);

        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(file);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFWorkbook exampleWorkbook = null;
        try {
            exampleWorkbook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet newAccountSheet = exampleWorkbook.getSheet(sheetName);

        Map<String, Map<String, String>> superMap = new HashMap<String, Map<String, String>>();
        List<String> columnHeader = new ArrayList<String>();
        DataFormatter formatter = new DataFormatter();
        XSSFRow row = newAccountSheet.getRow(0);
        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()) {
            columnHeader.add(cellIterator.next().getStringCellValue());
        }
        int rowCount = newAccountSheet.getLastRowNum() - newAccountSheet.getFirstRowNum();
        int cellCount = row.getLastCellNum();

        for (int i = 1; i <= rowCount; i++) {
            Map<String, String> singleRowData = new HashMap<String, String>();
            XSSFRow rowFirst = newAccountSheet.getRow(i);
            XSSFCell cellTestCaseID = rowFirst.getCell(0);
            for (int j = 1; j < cellCount; j++) {
                XSSFCell cell = rowFirst.getCell(j);
                singleRowData.put(columnHeader.get(j), formatter.formatCellValue(cell));
            }
            superMap.put(formatter.formatCellValue(cellTestCaseID), singleRowData);
        }
        for (String key : superMap.keySet()) ;
        logger.info("Super map" + superMap);

        return superMap;


    }

    public static HashMap<String, String> readExcelSheetByTestCaseID(String fileExcelPath, String sheetName, String testCaseID) {
        File file = new File(fileExcelPath);
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(file);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFWorkbook exampleWorkbook = null;
        try {
            exampleWorkbook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet editAccountSheet = exampleWorkbook.getSheet(sheetName);
        List<Integer> testcaseBorder = new ArrayList<Integer>();
        DataFormatter formatter = new DataFormatter();
        for (int rowIndex = 0; rowIndex < editAccountSheet.getLastRowNum(); rowIndex++) {
            XSSFRow row = editAccountSheet.getRow(rowIndex);
            if (row != null) {
                for (int cellIndex = 0; cellIndex < row.getPhysicalNumberOfCells(); cellIndex++) {
                    XSSFCell cell = row.getCell(cellIndex);
                    if (cell != null && cell.getStringCellValue().equals(testCaseID)) {
                        int columnNumber = cell.getColumnIndex();
                        int rowNumber = cell.getRowIndex();
                        testcaseBorder.add(columnNumber);
                        testcaseBorder.add(rowNumber);
                    }
                }
            }
        }
        HashMap<String, String> superMap = new HashMap<>();
        List<String> columnHeader = new ArrayList<String>();
        List<String> columnValue = new ArrayList<String>();
        int columnCount = 0;
        for (int i = testcaseBorder.get(0) + 1; i <= testcaseBorder.get(2) - 1; i++) {
            columnCount++;
            XSSFRow firstRow = editAccountSheet.getRow(testcaseBorder.get(1));
            XSSFCell firstCell = firstRow.getCell(i);
            columnHeader.add(formatter.formatCellValue(firstCell));
            XSSFRow secondRow = editAccountSheet.getRow(testcaseBorder.get(1) + 1);
            XSSFCell secondCell = secondRow.getCell(i);
            columnValue.add(formatter.formatCellValue(secondCell));
        }
        for (int j = 0; j < columnCount; j++) {
            superMap.put(columnHeader.get(j), columnValue.get(j));
        }
        for (String key : superMap.keySet()) ;
        logger.info("Super map" + superMap);

        return superMap;


    }

    public void openFile(String filePath) {
        File file = new File(filePath);
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(file);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
