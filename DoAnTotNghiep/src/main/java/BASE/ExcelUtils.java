package BASE;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

	public static Object[][] getTestData(String filePath, String sheetName) throws IOException {
//		String filePath = ".\\resourses\\data\\"+filename;
		FileInputStream fileInputStream = new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);

		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] data = new Object[rowCount - 1][colCount];

		for (int rowIdx = 1; rowIdx < rowCount; rowIdx++) {
			Row row = sheet.getRow(rowIdx);
			for (int colIdx = 0; colIdx < colCount; colIdx++) {
				Cell cell = row.getCell(colIdx);
				DataFormatter formatter = new DataFormatter();
				data[rowIdx - 1][colIdx] = formatter.formatCellValue(cell);
			}
		}

		workbook.close();
		fileInputStream.close();

		return data;
	}
}