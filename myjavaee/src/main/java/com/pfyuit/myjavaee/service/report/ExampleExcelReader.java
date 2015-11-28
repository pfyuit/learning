package com.pfyuit.myjavaee.service.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.pfyuit.myjavaee.model.report.excel.ExampleExcelModel;

/**
 * @author yupengfei
 */
public class ExampleExcelReader implements Reader<ExampleExcelModel> {

	public List<ExampleExcelModel> read(File file) {
		List<ExampleExcelModel> list = new ArrayList<ExampleExcelModel>();
		try {
			FileInputStream fis = new FileInputStream(file);
			Workbook workbook = createWorkbook(file, fis);
			int sheetNumbers = workbook.getNumberOfSheets();
			for (int i = 0; i < sheetNumbers; i++) {
				Sheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rowIterator = sheet.iterator();
				while (rowIterator.hasNext()) {
					ExampleExcelModel model = new ExampleExcelModel();
					Row row = rowIterator.next();
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						String cellValue = "";
						if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
							cellValue = cell.getStringCellValue().trim();
						} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
							cellValue = String.valueOf(cell.getNumericCellValue()).trim();
						}
						if (model.getName() == null || model.getName().equalsIgnoreCase("")) {
							model.setName(cellValue);
						} else if (model.getAge() == null || model.getAge().equalsIgnoreCase("")) {
							model.setAge(cellValue);
						} else if (model.getSex() == null || model.getSex().equalsIgnoreCase("")) {
							model.setSex(cellValue);
						} else if (model.getPhone() == null || model.getPhone().equalsIgnoreCase("")) {
							model.setPhone(cellValue);
						} else if (model.getAddress() == null || model.getAddress().equalsIgnoreCase("")) {
							model.setAddress(cellValue);
						} else if (model.getDescription() == null || model.getDescription().equalsIgnoreCase("")) {
							model.setDescription(cellValue);
						}
					}
					list.add(model);
				}

			}
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}

	private Workbook createWorkbook(File file, FileInputStream fis) throws IOException {
		Workbook workbook = null;
		if (file.getName().toLowerCase().endsWith("xlsx")) {
			workbook = new XSSFWorkbook(fis);
		} else if (file.getName().toLowerCase().endsWith("xls")) {
			workbook = new HSSFWorkbook(fis);
		}
		return workbook;
	}

}
