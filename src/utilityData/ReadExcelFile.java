package utilityData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	FileInputStream fis;

	public ReadExcelFile(String excelPath) {

		try {
			fis = new FileInputStream(excelPath);
			try {
				wb = new XSSFWorkbook(fis);
			} catch (IOException e) {
			System.out.println(e.getMessage());
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	public String getData(int sheetnumber, int row, int column) {
		sheet = wb.getSheetAt(sheetnumber);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}

	public int getColoumnCount(int sheetIndex) {
		int coloumn = wb.getSheetAt(sheetIndex).getRow(0).getLastCellNum();
		return coloumn;
	}

	public int getRowCount(int sheetIndex) {
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		row = row + 1;
		return row;
	}
}