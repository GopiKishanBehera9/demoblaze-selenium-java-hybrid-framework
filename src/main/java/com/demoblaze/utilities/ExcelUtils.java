package com.demoblaze.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.demoblaze.constants.FrameworkConstants;

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
     * Returns workbook.
     */
    private static XSSFWorkbook getWorkbook(String fileName) {

        try {

            return new XSSFWorkbook(
                    new FileInputStream(
                            FrameworkConstants.EXCEL_PATH + fileName));

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to open Excel file : " + fileName, e);

        }

    }

    /**
     * Read cell data.
     */
    public static String getCellData(String fileName,
                                     String sheetName,
                                     int rowNumber,
                                     int columnNumber) {

        try (XSSFWorkbook workbook = getWorkbook(fileName)) {

            Sheet sheet = workbook.getSheet(sheetName);

            Row row = sheet.getRow(rowNumber);

            Cell cell = row.getCell(columnNumber);

            DataFormatter formatter = new DataFormatter();

            return formatter.formatCellValue(cell);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Unable to read cell value.", e);

        }

    }

    /**
     * Get total rows.
     */
    public static int getRowCount(String fileName,
                                  String sheetName) {

        try (XSSFWorkbook workbook = getWorkbook(fileName)) {

            Sheet sheet = workbook.getSheet(sheetName);

            return sheet.getLastRowNum();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Unable to get row count.", e);

        }

    }

    /**
     * Get total columns.
     */
    public static int getColumnCount(String fileName,
                                     String sheetName) {

        try (XSSFWorkbook workbook = getWorkbook(fileName)) {

            Sheet sheet = workbook.getSheet(sheetName);

            return sheet.getRow(0).getLastCellNum();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Unable to get column count.", e);

        }

    }

}