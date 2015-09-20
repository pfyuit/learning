package com.pfyuit.java.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class URLConnectionTest {

	public static void main(String[] args) {
		HttpURLConnection con;
		try {
			con = (HttpURLConnection) new URL("http://pfyuit.com/about.html").openConnection();
			con.setDoOutput(false);
			con.setDoInput(true);
			con.setUseCaches(false);
			con.setAllowUserInteraction(true);
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "text/html;charset=utf8");
			con.connect();

			Thread.sleep(10000);

			List<String> output = new ArrayList<String>();
			InputStream is = con.getInputStream();
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
