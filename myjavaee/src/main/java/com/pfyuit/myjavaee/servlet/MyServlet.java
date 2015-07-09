package com.pfyuit.myjavaee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Logger logger = LoggerFactory.getLogger(MyServlet.class);

	public MyServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		logger.info("init");
	}

	public void destroy() {
		logger.info("destrory");
	}

	public ServletConfig getServletConfig() {
		logger.info("getServletConfig");
		return null;
	}

	public String getServletInfo() {
		logger.info("getServletInfo");
		return null;
	}

	// protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// logger.info("service");
	// }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("doGet");

		{
			logger.info("auth type:{}", request.getAuthType());
			logger.info("character encoding:{}", request.getCharacterEncoding());
			logger.info("content length:{}", request.getContentLength());
			logger.info("content type:{}", request.getContentType());
			logger.info("context path:{}", request.getContextPath());

			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					logger.info("cookie:{}-->{}", cookie.getName(), cookie.getValue());
				}
			}

			Enumeration<String> headerNames = request.getHeaderNames();
			if (headerNames != null) {
				while (headerNames.hasMoreElements()) {
					String headerName = headerNames.nextElement();
					String headerValue = request.getHeader(headerName);
					logger.info("header:{}-->{}", headerName, headerValue);
				}
			}

			logger.info("local addr:{}", request.getLocalAddr());

			Locale locale = request.getLocale();
			logger.info("locale:{}", locale);

			logger.info("local name:{}", request.getLocalName());
			logger.info("local port:{}", request.getLocalPort());
			logger.info("method:{}", request.getMethod());

			Enumeration<String> paramNames = request.getParameterNames();
			if (paramNames != null) {
				while (paramNames.hasMoreElements()) {
					String paramName = headerNames.nextElement();
					String paramValue = request.getParameter(paramName);
					logger.info("parameter:{}-->{}", paramName, paramValue);
				}
			}

			logger.info("path info:{}", request.getPathInfo());
			logger.info("path translated:{}", request.getPathTranslated());
			logger.info("protocol:{}", request.getProtocol());
			logger.info("query string:{}", request.getQueryString());
			logger.info("remote addr:{}", request.getRemoteAddr());
			logger.info("remote host:{}", request.getRemoteHost());
			logger.info("remote port:{}", request.getRemotePort());
			logger.info("remote user:{}", request.getRemoteUser());
			logger.info("request session id:{}", request.getRequestedSessionId());
			logger.info("request url:{}", request.getRequestURI());
			logger.info("schema:{}", request.getScheme());
			logger.info("server name:{}", request.getServerName());
			logger.info("server port:{}", request.getServerPort());
			logger.info("servlet path:{}", request.getServletPath());

			ServletContext servletContext = request.getServletContext();
			HttpSession session = request.getSession();
			Principal userPrincipal = request.getUserPrincipal();
		}

		{
			response.addCookie(new Cookie("name", "tom"));
			response.addHeader("sex", "male");
			response.encodeURL("http://www.google.com?a=b");
			logger.info("response character encoding:{}", response.getCharacterEncoding());

			Collection<String> headerNames = response.getHeaderNames();
			if (headerNames != null) {
				for (String headerName : headerNames) {
					String headerValue = request.getHeader(headerName);
					logger.info("header:{}-->{}", headerName, headerValue);
				}
			}

			logger.info("response locale:{}", response.getLocale());
			logger.info("response status:{}", response.getStatus());

			logger.info("response isCommitted:{}", response.isCommitted());

			response.setCharacterEncoding("UTF-8");
			// response.setContentLength(10);
			response.setContentType("text/plain");
			response.setHeader("h", "b");
			response.setLocale(Locale.US);
			response.setStatus(HttpServletResponse.SC_OK);
			// response.sendRedirect("http://www.google.com");
			// response.sendError(HttpServletResponse.SC_BAD_REQUEST, "http://www.google.com");
			
			PrintWriter ps = response.getWriter();
			ps.write("hello");
			ps.flush();
			response.flushBuffer();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("doPost");
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("doPut");
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("doDelete");
	}

	protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("doHead");
	}

	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("doOptions");
	}

	protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("doTrace");
	}

}
