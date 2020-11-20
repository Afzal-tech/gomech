package com.gomechanic.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandler {

	private XSSFWorkbook wb;
	private XSSFSheet sheet;
	private XSSFRow row;
	private FileInputStream fis;
	private String[][] data;
	private DataFormatter dataFormatter;

	public ExcelHandler(String fileLocation) {
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + fileLocation);
			wb = new XSSFWorkbook(fis);
			dataFormatter = new DataFormatter();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reads and returns total table data from excel as two dimensional object
	 * 
	 * @param sheetName
	 * @return Two dimensional 'object'
	 */
	public String[][] readData(String sheetName) {
		sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		int colNum = sheet.getRow(0).getLastCellNum();
		data = new String[rowCount][colNum];
		for (int i = 1; i <= rowCount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				data[i - 1][j] = dataFormatter.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * Reads and returns single cell data value as string type only from excel
	 * 
	 * @param sheetName
	 * @param rowNumber
	 * @param columnNumber
	 * @return single 'cell value'
	 */
	public String readOneCellData(String sheetName, int rowNumber, int columnNumber) {
		sheet = wb.getSheet(sheetName);
		String cellData = dataFormatter.formatCellValue(sheet.getRow(rowNumber).getCell(columnNumber));
		System.out.println(cellData);
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cellData;
	}

	/**
	 * Generates and returns a random string
	 * 
	 * @return 'Random string value'
	 */
	public String getRandomString() {
		return RandomStringUtils.randomAlphabetic(8);
	}

	/**
	 * Generates and returns a random mailId
	 * 
	 * @return 'Random Mail Id'
	 */
	public String getRandomMailId() {
		return RandomStringUtils.randomAlphabetic(8) + "@gmail.com";
	}

	/**
	 * Generates and returns random number
	 * 
	 * @return Random Number
	 */
	public String getRandomNumber() {
		return RandomStringUtils.randomNumeric(10);
	}
}
