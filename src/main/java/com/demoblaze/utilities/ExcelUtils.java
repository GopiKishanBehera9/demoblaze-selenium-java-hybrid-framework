package com.demoblaze.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.demoblaze.constants.FrameworkConstants;
import com.demoblaze.exceptions.ExcelFileException;

/**
 * ExcelUtils
 *
 * Utility class for reading Excel (.xlsx) files.
 *
 * @author Gopi Kishan Behera
 */
public final class ExcelUtils {

    private ExcelUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Returns Workbook instance.
     *
     * @param fileName Excel file name
     * @return XSSFWorkbook
     */
    private static XSSFWorkbook getWorkbook(String fileName) {

        try {

            return new XSSFWorkbook(
                    new FileInputStream(
                            FrameworkConstants.EXCEL_PATH + fileName));

        } catch (IOException e) {

        	throw new ExcelFileException(
        	        "Unable to open Excel file : "
        	        + fileName,
        	        e);

        }

    }

    /**
     * Returns cell value.
     *
     * @param fileName Excel file
     * @param sheetName Sheet name
     * @param rowNumber Row number
     * @param columnNumber Column number
     * @return Cell value
     */
    public static String getCellData(String fileName,
                                     String sheetName,
                                     int rowNumber,
                                     int columnNumber) {

        try (XSSFWorkbook workbook = getWorkbook(fileName)) {

            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
            	throw new ExcelFileException(
            	        "Sheet not found : "
            	        + sheetName);
            }

            Row row = sheet.getRow(rowNumber);

            if (row == null) {
                return "";
            }

            Cell cell = row.getCell(columnNumber);

            if (cell == null) {
                return "";
            }

            DataFormatter formatter = new DataFormatter();

            return formatter.formatCellValue(cell);

        } catch (Exception e) {

        	throw new ExcelFileException(
        	        "Unable to read cell data.",
        	        e);

        }

    }

    /**
     * Returns total number of data rows.
     *
     * @param fileName Excel file
     * @param sheetName Sheet name
     * @return Row count
     */
    public static int getRowCount(String fileName,
                                  String sheetName) {

        try (XSSFWorkbook workbook = getWorkbook(fileName)) {

            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException(
                        "Sheet not found : " + sheetName);
            }

            return sheet.getLastRowNum();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Unable to get row count.", e);

        }

    }

    /**
     * Returns total number of columns.
     *
     * @param fileName Excel file
     * @param sheetName Sheet name
     * @return Column count
     */
    public static int getColumnCount(String fileName,
                                     String sheetName) {

        try (XSSFWorkbook workbook = getWorkbook(fileName)) {

            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException(
                        "Sheet not found : " + sheetName);
            }

            Row headerRow = sheet.getRow(0);

            if (headerRow == null) {
                return 0;
            }

            return headerRow.getLastCellNum();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Unable to get column count.", e);

        }

    }

    /**
     * Checks whether a sheet exists.
     *
     * @param fileName Excel file
     * @param sheetName Sheet name
     * @return true if sheet exists
     */
    public static boolean isSheetExists(String fileName,
                                        String sheetName) {

        try (XSSFWorkbook workbook = getWorkbook(fileName)) {

            return workbook.getSheet(sheetName) != null;

        } catch (Exception e) {

            throw new RuntimeException(
                    "Unable to verify sheet existence.", e);

        }

    }

}