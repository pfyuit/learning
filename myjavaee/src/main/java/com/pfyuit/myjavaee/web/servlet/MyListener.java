package com.pfyuit.myjavaee.web.servlet;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A classic Listener defined in Java EE specifications. In old version Java EE,
 * you can also configure it in the web.xml, but we can use annotations since
 * Servlet 3.0.
 * @author yupengfei
 */
@WebListener
public class MyListener implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener,
		HttpSessionActivationListener, HttpSessionBindingListener, ServletRequestListener, ServletRequestAttributeListener {

	private Logger logger = LoggerFactory.getLogger(MyListener.class);

	public MyListener() {
	}

	// //////////////////HttpServletRequest////////////////////////////////
	public void requestInitialized(ServletRequestEvent arg0) {
		logger.info("HttpServletRequest requestInitialized");
	}

	public void requestDestroyed(ServletRequestEvent arg0) {
		logger.info("HttpServletRequest requestDestroyed");
	}

	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		logger.info("HttpServletRequest attributeAdded");
	}

	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		logger.info("HttpServletRequest attributeRemoved");
	}

	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		logger.info("HttpServletRequest attributeReplaced");
	}

	// //////////////////HttpSession////////////////////////////////
	public void sessionCreated(HttpSessionEvent arg0) {
		logger.info("HttpSession sessionCreated");
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		logger.info("HttpSession sessionDestroyed");
	}

	public void attributeAdded(HttpSessionBindingEvent arg0) {
		logger.info("HttpSession attributeAdded");
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		logger.info("HttpSession attributeRemoved");
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		logger.info("HttpSession attributeReplaced");
	}

	public void sessionWillPassivate(HttpSessionEvent arg0) {
		logger.info("HttpSession sessionWillPassivate");
	}

	public void sessionDidActivate(HttpSessionEvent arg0) {
		logger.info("HttpSession sessionDidActivate");
	}

	public void valueBound(HttpSessionBindingEvent arg0) {
		logger.info("HttpSession valueBound");
	}

	public void valueUnbound(HttpSessionBindingEvent arg0) {
		logger.info("HttpSession valueUnbound");
	}

	// //////////////////ServletContext////////////////////////////////
	public void contextInitialized(ServletContextEvent arg0) {
		logger.info("ServletContext contextInitialized");
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		logger.info("ServletContext contextDestroyed");
	}

	public void attributeAdded(ServletContextAttributeEvent arg0) {
		logger.info("ServletContext attributeAdded");
	}

	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		logger.info("ServletContext attributeRemoved");
	}

	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		logger.info("ServletContext attributeReplaced");
	}

}
