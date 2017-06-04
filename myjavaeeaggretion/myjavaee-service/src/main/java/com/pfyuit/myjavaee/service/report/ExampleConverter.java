package com.pfyuit.myjavaee.service.report;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.pfyuit.myjavaee.model.report.excel.ExampleExcelModel;
import com.pfyuit.myjavaee.model.report.pdf.ExamplePdfModel;

/**
 * @author yupengfei
 */
public class ExampleConverter implements Converter<ExampleHtmlTemplate, ExampleExcelModel, ExamplePdfModel> {

	private Pattern pattern = Pattern.compile("(\\$\\{([a-z.]+)\\})");

	public ExamplePdfModel convert(ExampleHtmlTemplate template, ExampleExcelModel input) {
		String templateStr = template.getDocument();
		Matcher matcher = pattern.matcher(templateStr);
		while (matcher.find()) {
			String expression = matcher.group();
			templateStr = replace(expression, input, templateStr);
			matcher = pattern.matcher(templateStr);
		}

		ExamplePdfModel output = new ExamplePdfModel();
		output.setDocument(templateStr);
		return output;
	}

	private String replace(String expression, ExampleExcelModel input, String templateStr) {
		String[] array = expression.split("\\.");
		String fieldName = array[1].substring(0, array[1].length() - 1);
		String result = null;
		try {
			Field field = input.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			String value = (String) field.get(input);
			result = templateStr.replace(expression, value);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return result;
	}

}
