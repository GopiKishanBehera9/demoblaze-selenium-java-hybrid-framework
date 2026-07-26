package com.demoblaze.utilities;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.demoblaze.exceptions.ExcelFileException;

/**
 * DataProviderUtils
 *
 * Provides reusable Excel DataProviders for TestNG.
 *
 * @author Gopi Kishan Behera
 */
public final class DataProviderUtils {

    private DataProviderUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * DataProvider for Login Test Data.
     *
     * Excel Format:
     *
     * ---------------------------------------------------------------
     * TestCaseID | Username | Password | Expected | Description | Execute
     * ---------------------------------------------------------------
     *
     * Execute = YES -> Test will run
     * Execute = NO  -> Test will skip
     *
     * @return Object[][]
     */
    @DataProvider(name = "loginData")
    public static Object[][] getLoginData() {

        return getTestData(
                "LoginData.xlsx",
                "LoginData");

    }

    /**
     * Generic Excel Reader.
     *
     * Can be reused for any Excel file.
     *
     * @param fileName Excel file name
     * @param sheetName Sheet name
     * @return Object[][]
     */
    private static Object[][] getTestData(String fileName,
                                          String sheetName) {

        if (!ExcelUtils.isSheetExists(fileName, sheetName)) {

        	throw new ExcelFileException(
        	        "Sheet '" + sheetName +
        	        "' does not exist in " +
        	        fileName);
        }
        int totalRows =
                ExcelUtils.getRowCount(fileName, sheetName);

        int totalColumns =
                ExcelUtils.getColumnCount(fileName, sheetName);

        List<Object[]> testData = new ArrayList<>();

        // Skip Header Row

        for (int row = 1; row <= totalRows; row++) {

            String executeFlag =
                    ExcelUtils.getCellData(
                            fileName,
                            sheetName,
                            row,
                            totalColumns - 1);

            if (!"YES".equalsIgnoreCase(executeFlag.trim())) {

                continue;

            }

            Object[] rowData =
                    new Object[totalColumns];

            for (int col = 0; col < totalColumns; col++) {

                rowData[col] =
                        ExcelUtils.getCellData(
                                fileName,
                                sheetName,
                                row,
                                col);

            }

            testData.add(rowData);

        }

        return testData.toArray(new Object[0][]);
        
    }

}