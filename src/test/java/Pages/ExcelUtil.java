package Pages;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static String excelpath;
	static String sheetName;
	static int rowCount = 0;
	static int colCount = 0;

	public ExcelUtil(String uExcelPath, String uSheetName) {
		excelpath = uExcelPath;
		sheetName = uSheetName;
	}

	public static int getRowCount(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Row count entered :" + rowCount);
		}

		catch (IOException e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	public static int getColCount(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Row count entered :" + colCount);
		}

		catch (IOException e) {
			e.printStackTrace();
		}
		return colCount;
	}
	
	public static String getStringCellData(String excelPath, String sheetName, int rowNum, int colCount) {
		String cellData= null;
		try {
			workbook= new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
			cellData = sheet.getRow(rowNum).getCell(colCount).getStringCellValue();
			System.out.println("cell data" + cellData);
		}
		catch(IOException e){
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}
		return cellData;
		}
	}
