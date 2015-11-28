package com.pfyuit.myjavaee.service.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringBufferInputStream;
import java.nio.charset.Charset;
import java.util.List;

import org.junit.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.pfyuit.myjavaee.model.report.excel.ExampleExcelModel;
import com.pfyuit.myjavaee.model.report.pdf.ExamplePdfModel;

/**
 * @author yupengfei
 */
public class ReportConverterTest {

	public static final String INPUT = "src/test/resources/report/data/input/input.xlsx";
	public static final String OUTPUT = "src/test/resources/report/data/output/output_%s.pdf";
	public static final String TEMPLATE = "src/test/resources/report/data/template/template.html";
	private static final String CSS = "src/test/resources/report/data/template/template.css";

	@Test
	public void testReportConverter() throws IOException, DocumentException {
		Resolver<ExampleHtmlTemplate> resolver = new ExampleHtmlTemplateResolver();
		ExampleHtmlTemplate template = resolver.resolve(new File(TEMPLATE));
		System.out.println(template.getDocument());

		Reader<ExampleExcelModel> reader = new ExampleExcelReader();
		List<ExampleExcelModel> inputs = reader.read(new File(INPUT));

		for (int i = 0; i < inputs.size(); i++) {
			ExampleExcelModel input = inputs.get(i);
			Converter<ExampleHtmlTemplate, ExampleExcelModel, ExamplePdfModel> converter = new ExampleConverter();
			ExamplePdfModel output = converter.convert(template, input);
			writeFile(output, String.format(OUTPUT, i));
		}
	}

	private static void writeFile(ExamplePdfModel output, String fileName) throws DocumentException, FileNotFoundException, IOException {
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
		document.open();
		XMLWorkerHelper.getInstance().parseXHtml(writer, document, new StringBufferInputStream(output.getDocument()),
				new FileInputStream(new File(CSS)), Charset.forName("UTF-8"));
		document.close();
	}

}
