package com.pfyuit.myjavase.java.net;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Operations for URLEncoder
 * @author yupengfei
 */
public class URLEncoderTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws UnsupportedEncodingException {
		String encodedUrl = URLEncoder.encode("http://www.pfyuit.com?state=在线");
		System.out.println(encodedUrl);
		String encodedUrl1 = URLEncoder.encode("http://www.pfyuit.com?state=在线", "UTF8");
		System.out.println(encodedUrl1);

		String decodedUrl = URLDecoder.decode(encodedUrl);
		System.out.println(decodedUrl);
		String decodedUrl1 = URLDecoder.decode(encodedUrl1, "UTF8");
		System.out.println(decodedUrl1);
	}

}
