package utilityData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XssfReading {
	public FileInputStream file = null;
	public FileOutputStream fileo = null;
	XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	XSSFRow row = null;
	XSSFCell cell = null;
	public String path;

	public XssfReading(String path , String SheetNameOrIndex) throws IOException {
		this.path = path;
		file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
		if (isNumeric(SheetNameOrIndex)) {
			sheet = workbook.getSheetAt(Integer.parseInt(SheetNameOrIndex));
		}
		else {
			sheet = workbook.getSheet(SheetNameOrIndex);
		}
	}

	private boolean isNumeric(String s) {
		if (s.isEmpty() || s.isBlank()) {
			return false;
		}
		char[] a = s.toCharArray();
		for (char c : a) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

	public void selectSheet(String sheetNameOrIndex) {
		if (isNumeric(sheetNameOrIndex)) {
			this.sheet = workbook.getSheetAt(Integer.parseInt(sheetNameOrIndex));
		} else { }
	}

	public int rowCount() {
		return sheet.getLastRowNum() + 1;
	}

	public int coloumnCount() {
		return sheet.getRow(0).getLastCellNum();
	}
     
	public Object [][] fetchCellvalue(){
		Object [][] a = new Object[rowCount()][coloumnCount()];
		for (int i = 0; i < rowCount(); i++) {
			XSSFRow currentrow = sheet.getRow(i);
			for (int j = 0; j < coloumnCount() ; j++) {
				a[i][j] = currentrow.getCell(j).toString();
			}
		}
		
		return a;
	}
	public String getSheetDAta(int sheetNumber , int row , int coloumn) {
			String data = workbook.getSheetAt(sheetNumber).getRow(row).getCell(coloumn).getStringCellValue(); // focused on current row
			
		return data;

	}

}
