package com.pfyuit.myjavaee.servlet;

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

@WebListener
public class MyListener implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener, HttpSessionActivationListener,
		HttpSessionBindingListener, ServletRequestListener, ServletRequestAttributeListener {

	private Logger logger = LoggerFactory.getLogger(MyListener.class);

	public MyListener() {
	}

	// //////////////////HttpServletRequest////////////////////////////////
	public void requestInitialized(ServletRequestEvent arg0) {
		logger.info("requestInitialized");
	}

	public void requestDestroyed(ServletRequestEvent arg0) {
		logger.info("requestDestroyed");
	}

	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		logger.info("attributeAdded");
	}

	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		logger.info("attributeRemoved");
	}

	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		logger.info("attributeReplaced");
	}

	// //////////////////HttpSession////////////////////////////////
	public void sessionCreated(HttpSessionEvent arg0) {
		logger.info("sessionCreated");
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		logger.info("sessionDestroyed");
	}

	public void attributeAdded(HttpSessionBindingEvent arg0) {
		logger.info("attributeAdded");
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		logger.info("attributeRemoved");
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		logger.info("attributeReplaced");
	}

	public void sessionWillPassivate(HttpSessionEvent arg0) {
		logger.info("sessionWillPassivate");
	}

	public void sessionDidActivate(HttpSessionEvent arg0) {
		logger.info("sessionDidActivate");
	}

	public void valueBound(HttpSessionBindingEvent arg0) {
		logger.info("valueBound");
	}

	public void valueUnbound(HttpSessionBindingEvent arg0) {
		logger.info("valueUnbound");
	}

	// //////////////////ServletContext////////////////////////////////
	public void contextInitialized(ServletContextEvent arg0) {
		logger.info("contextInitialized");
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		logger.info("contextDestroyed");
	}

	public void attributeAdded(ServletContextAttributeEvent arg0) {
		logger.info("attributeAdded");
	}

	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		logger.info("attributeRemoved");
	}

	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		logger.info("attributeReplaced");
	}

}
