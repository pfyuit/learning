package com.pfyuit.myjavaee.service.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

/**
 * @author yupengfei
 */
public class ExcelProcessor {

	@Test
	public static void processExcel() {
		try {
			File file = new File("C:\\topsku_soldout.xls");
			FileInputStream fis = new FileInputStream(file);
			Workbook workbook = createWorkbook(file, fis);
			int sheetNumbers = workbook.getNumberOfSheets();
			Set<String> lsins = new HashSet<String>();

			for (int i = 0; i < sheetNumbers; i++) {
				Sheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rowIterator = sheet.iterator();
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					Cell cell = row.getCell(1);
					lsins.add(cell.getStringCellValue());
				}
			}

			System.out.println(lsins);
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Workbook createWorkbook(File file, FileInputStream fis) throws IOException {
		Workbook workbook = null;
		if (file.getName().toLowerCase().endsWith("xlsx")) {
			workbook = new XSSFWorkbook(fis);
		} else if (file.getName().toLowerCase().endsWith("xls")) {
			workbook = new HSSFWorkbook(fis);
		}
		return workbook;
	}

}
