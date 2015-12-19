package com.pfyuit.myjavase.java.lang.instrument;

import java.lang.instrument.Instrumentation;

/**
 * @author yupengfei
 */
public class CustomInstrument {

	private static volatile Instrumentation instrumentation;

	public static void premain(String agentArgs, Instrumentation inst) {
		instrumentation = inst;
	}

	public static void agentmain(String agentArgs, Instrumentation inst) {
		instrumentation = inst;
	}

	public static Instrumentation getInstrumentation() {
		return instrumentation;
	}

}
