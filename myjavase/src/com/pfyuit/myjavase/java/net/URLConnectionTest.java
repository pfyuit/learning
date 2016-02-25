package com.pfyuit.myjavase.java.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Operations for URLConnection: High level operations for web.
 * @author yupengfei
 */
public class URLConnectionTest {

	public static void main(String[] args) {
		HttpURLConnection connection;
		try {
			connection = (HttpURLConnection) new URL("http://www.baidu.com").openConnection();
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			connection.setDoInput(true);
			connection.setDoOutput(false);
			connection.setUseCaches(false); // Applet only
			connection.setAllowUserInteraction(true);// Applet only
			connection.setIfModifiedSince(5000);

			// Set HTTP request method.
			connection.setRequestMethod("GET");

			// Set HTTP headers.
			connection.setRequestProperty("Content-Type", "text/html;charset=utf8");
			connection.connect();

			Thread.sleep(10000);

			// Read HTTP response
			System.out.println(connection.getResponseCode());
			System.out.println(connection.getResponseMessage());

			// Read HTTP header
			System.out.println(connection.getContentType());
			System.out.println(connection.getContentLength());
			System.out.println(connection.getIfModifiedSince());
			System.out.println(connection.getExpiration());
			System.out.println(connection.getLastModified());

			Map<String, List<String>> headers = connection.getHeaderFields();
			for (String headerFieldName : headers.keySet()) {
				System.out.print(headerFieldName + " ");
				List<String> values = headers.get(headerFieldName);
				for (String value : values) {
					System.out.println(value);
				}
			}

			// Read HTTP body
			List<String> output = new ArrayList<String>();
			InputStream is = connection.getInputStream();
			BufferedReader bufreader = new BufferedReader(new InputStreamReader(is));
			while (true) {
				String line = bufreader.readLine();
				if (line == null)
					break;
				output.add(line);
			}

			for (String line : output) {
				System.out.println(line);
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
