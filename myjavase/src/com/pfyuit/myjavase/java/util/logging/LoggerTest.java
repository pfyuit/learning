package com.pfyuit.myjavase.java.util.logging;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Logger--Level--Handler--Filter--Formatter
 * @author yupengfei
 */
public class LoggerTest {

	private static final Logger globalLogger = Logger.getGlobal();
	private static final Logger loggerWithoutResourceBundle = Logger.getLogger("LoggerWithoutResourceBundle");
	private static final Logger loggerWithResourceBundle = Logger.getLogger("LoggerWithResourceBundle",
			"com.pfyuit.myjavase.java.util.logging.messages");

	public static void main(String[] args) throws SecurityException, IOException {
		Handler consoleHandler = new ConsoleHandler();
		Handler fileHandler = new FileHandler();

		testGlobalLogger(consoleHandler, fileHandler);
		testLoggerWithoutResourceBundle(consoleHandler, fileHandler);
		testLoggerWithResourceBundle(consoleHandler, fileHandler);
	}

	private static void testGlobalLogger(Handler consoleHandler, Handler fileHandler) {
		System.out.println("=>testGlobalLogger");
		globalLogger.addHandler(consoleHandler);
		globalLogger.addHandler(fileHandler);

		globalLogger.setLevel(Level.ALL);

		globalLogger.finest("Finest logging message");
		globalLogger.finer("Finer logging message");
		globalLogger.fine("Fine logging message");
		globalLogger.config("Config logging message");
		globalLogger.info("Info logging message");
		globalLogger.warning("Warning logging message");
		globalLogger.severe("Severe logging message");
		globalLogger.throwing("com.pfyuit.myjavase.java.util.logging.LoggerTest", "testGlobalLogger", new RuntimeException("runtime exception"));

		globalLogger.log(Level.FINEST, "Finest logging message");
		globalLogger.log(Level.FINER, "Finer logging message");
		globalLogger.log(Level.FINE, "Fine logging message");
		globalLogger.log(Level.CONFIG, "Config logging message");
		globalLogger.log(Level.INFO, "Info logging message");
		globalLogger.log(Level.WARNING, "Warning logging message");
		globalLogger.log(Level.SEVERE, "Severe logging message");
		globalLogger.log(Level.SEVERE, "Excpetion logging message", new RuntimeException("runtime exception"));
	}

	private static void testLoggerWithoutResourceBundle(Handler consoleHandler, Handler fileHandler) {
		System.out.println("=>testLoggerWithoutResourceBundle");
		loggerWithoutResourceBundle.addHandler(consoleHandler);
		loggerWithoutResourceBundle.addHandler(fileHandler);

		loggerWithoutResourceBundle.setLevel(Level.ALL);

		loggerWithoutResourceBundle.finest("Finest logging message");
		loggerWithoutResourceBundle.finer("Finer logging message");
		loggerWithoutResourceBundle.fine("Fine logging message");
		loggerWithoutResourceBundle.config("Config logging message");
		loggerWithoutResourceBundle.info("Info logging message");
		loggerWithoutResourceBundle.warning("Warning logging message");
		loggerWithoutResourceBundle.severe("Severe logging message");
		loggerWithoutResourceBundle.throwing("com.pfyuit.myjavase.java.util.logging.LoggerTest", "testGlobalLogger", new RuntimeException(
				"runtime exception"));

		loggerWithoutResourceBundle.log(Level.FINEST, "Finest logging message");
		loggerWithoutResourceBundle.log(Level.FINER, "Finer logging message");
		loggerWithoutResourceBundle.log(Level.FINE, "Fine logging message");
		loggerWithoutResourceBundle.log(Level.CONFIG, "Config logging message");
		loggerWithoutResourceBundle.log(Level.INFO, "Info logging message");
		loggerWithoutResourceBundle.log(Level.WARNING, "Warning logging message");
		loggerWithoutResourceBundle.log(Level.SEVERE, "Severe logging message");
		loggerWithoutResourceBundle.log(Level.SEVERE, "Excpetion logging message", new RuntimeException("runtime exception"));
	}

	private static void testLoggerWithResourceBundle(Handler consoleHandler, Handler fileHandler) {
		System.out.println("=>testLoggerWithResourceBundle");
		loggerWithResourceBundle.addHandler(consoleHandler);
		loggerWithResourceBundle.addHandler(fileHandler);

		loggerWithResourceBundle.setLevel(Level.ALL);

		loggerWithResourceBundle.finest("Finest logging message");
		loggerWithResourceBundle.finer("Finer logging message");
		loggerWithResourceBundle.fine("Fine logging message");
		loggerWithResourceBundle.config("Config logging message");
		loggerWithResourceBundle.info("Info logging message");
		loggerWithResourceBundle.warning("Warning logging message");
		loggerWithResourceBundle.severe("Severe logging message");
		loggerWithResourceBundle.throwing("com.pfyuit.myjavase.java.util.logging.LoggerTest", "testGlobalLogger", new RuntimeException(
				"runtime exception"));

		loggerWithResourceBundle.log(Level.FINEST, "Finest logging message");
		loggerWithResourceBundle.log(Level.FINER, "Finer logging message");
		loggerWithResourceBundle.log(Level.FINE, "Fine logging message");
		loggerWithResourceBundle.log(Level.CONFIG, "Config logging message");
		loggerWithResourceBundle.log(Level.INFO, "Info logging message");
		loggerWithResourceBundle.log(Level.WARNING, "Warning logging message");
		loggerWithResourceBundle.log(Level.SEVERE, "Severe logging message");
		loggerWithResourceBundle.log(Level.SEVERE, "Excpetion logging message", new RuntimeException("runtime exception"));

		loggerWithResourceBundle.log(Level.INFO, "key", new Object[] { "tom" });
	}

}
