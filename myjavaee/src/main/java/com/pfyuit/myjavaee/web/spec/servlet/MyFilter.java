package com.pfyuit.myjavaee.web.spec.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A classic Filter defined in Java EE specifications. In old version Java EE,
 * you can also configure it in the web.xml, but we can use annotations since
 * Servlet 3.0.
 * @author yupengfei
 */
@WebFilter("/*")
public class MyFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(MyFilter.class);

	public MyFilter() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
		logger.info("init");
	}

	public void destroy() {
		logger.info("destroy");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.info("doFilter");

		long start = System.currentTimeMillis();

		chain.doFilter(request, response);

		long end = System.currentTimeMillis();
		logger.info("Http transcation costs {} ms", end - start);
	}

}
