package com.rough;

import java.util.Hashtable;

import com.util.Reader;

public class readfrommultiplesheet {
	static Reader xls = new Reader();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		readData("sucessfullLoginTest",xls);

	}
	
	public static Object[][] readData(String testName, Reader xls) {
		// find the row num from which test starts
		// number of columns
		// number of rows
		// put the data in hashtable and put hashtable in array
		int testStartRowNum = 0;
		// find the row num from which test start
		for (int rNum = 1; rNum <= xls.getRowCount("Test Data"); rNum++) {
			if (xls.getCellData("Test Data", 0, rNum).equals(testName)) {
				testStartRowNum = rNum;
				break;
			}
		}
		
		System.out.println("Test" + testName + " starts from "
				+ testStartRowNum);

		// cols
		int colStartRowNum = testStartRowNum + 1;
		int totalCols = 0;
		while (!xls.getCellData("Test Data", totalCols, colStartRowNum).equals("")) {
			totalCols++;
		}
		System.out.println("Total columns in test " + totalCols);

		// rows
		int dataStartRowNum = testStartRowNum + 2;
		int totalRows = 0;
		while (!xls.getCellData("Test Data", 0, dataStartRowNum + totalRows).equals("")) {
			totalRows++;
		}

		// extract data
		Object[][] data = new Object[totalRows][1];
		Hashtable<String, String> table = null;
		int index = 0;
		for (int rNum = dataStartRowNum; rNum < (dataStartRowNum + totalRows); rNum++) {
			table = new Hashtable<String, String>();
			for (int cNum = 0; cNum < totalCols; cNum++) {
				table.put(xls.getCellData("Test Data", cNum, colStartRowNum),
						xls.getCellData("Test Data", cNum, rNum));
				System.out.print(xls.getCellData("Test Data", cNum, rNum)
						+ " -- ");
			}
			data[index][0] = table;
			index++;
			System.out.println();
		}
		System.out.println("Done");
		return data;
	}

}
