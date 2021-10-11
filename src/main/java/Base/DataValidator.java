package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataValidator {
	public void DataValidationExcel(String path_for_data, String Sheet_Name, int Start_row,int end_row,int stat_Col, String field_2)throws IOException {

		FileInputStream exfl = new FileInputStream(path_for_data);
		XSSFWorkbook workbook = new XSSFWorkbook(exfl);
		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i <= sheets - 1; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase(Sheet_Name)) {

				XSSFSheet sheet = workbook.getSheetAt(i);
				
				Iterator<Row> rows = sheet.iterator();
				Row firstrow = rows.next();

				Iterator<Cell> ce = firstrow.cellIterator();
				int k = 0;
				int column = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();

					if (value.getStringCellValue().equalsIgnoreCase(field_1)) {
						System.out.println(value.getStringCellValue());
						column = k;
					}
					k++;
				}
				System.out.println(column);

				while (rows.hasNext()) {
					Row r = rows.next();

					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(field_2)) {
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							System.out.println(cv.next().getStringCellValue());
						}

					}
/*
				Iterator<Row> rows = sheet.iterator();
				Row firstrow = rows.next();
				

				Iterator<Cell> ce = firstrow.cellIterator();

				// System.out.println(getStringCellValue);
				int k = 0;
				int column = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();

					if (value.getStringCellValue().equalsIgnoreCase(field_1)) {
						System.out.println(value.getStringCellValue());
						column = k;
					}
					k++;
				}
				System.out.println(column);

				while (rows.hasNext()) {
					Row r = rows.next();

					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(field_2)) {
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							System.out.println(cv.next().getStringCellValue());
						}

					}
				}*/

			}
		}

		}
}
	}
	