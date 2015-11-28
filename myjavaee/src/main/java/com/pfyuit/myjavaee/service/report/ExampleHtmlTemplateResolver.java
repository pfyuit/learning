package com.pfyuit.myjavaee.service.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author yupengfei
 */
public class ExampleHtmlTemplateResolver implements Resolver<ExampleHtmlTemplate> {

	public ExampleHtmlTemplate resolve(File file) {
		StringBuilder sb = new StringBuilder();
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String row = scanner.nextLine();
				sb.append(row).append("\r\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

		ExampleHtmlTemplate template = new ExampleHtmlTemplate();
		template.setDocument(sb.toString());
		return template;
	}

}
