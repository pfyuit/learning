package com.pfyuit.myjavase.java.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Operations for URLConnection
 * @author yupengfei
 */
public class URLConnectionTest {

	public static void main(String[] args) {
		HttpURLConnection connection;
		try {
			connection = (HttpURLConnection) new URL("http://www.baidu.com").openConnection();
			connection.setDoOutput(false);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setAllowUserInteraction(true);

			// Set HTTP request method.
			connection.setRequestMethod("GET");

			// Set HTTP headers.
			connection.setRequestProperty("Content-Type", "text/html;charset=utf8");
			connection.connect();

			Thread.sleep(10000);

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
