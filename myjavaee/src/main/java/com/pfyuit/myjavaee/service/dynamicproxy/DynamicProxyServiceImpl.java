package com.pfyuit.myjavaee.service.dynamicproxy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtNewConstructor;
import javassist.CtNewMethod;
import javassist.NotFoundException;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Static Proxy Pattern: Pre-define the target and proxy, the classes are loaded
 * when JVM start. The application may contain too many proxy classes.
 * <p>
 * Dynamic Proxy Pattern: Pre-define the target, then create proxy at runtime
 * (using bytecode toolkit: JDK, CGLib, Javassist, ASM) and destroy after
 * finished.
 * @author yupengfei
 */
public class DynamicProxyServiceImpl implements DynamicProxyService {

	/**
	 * High level method to dynamically generate dynamic proxy.
	 */
	@Override
	public UserService createJdkDynamicProxy(UserService target) {
		InvocationHandler handler = new JdkHandler(target);
		UserService jdkProxy = (UserService) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] { UserService.class }, handler);
		return jdkProxy;
	}

	/**
	 * High level method to dynamically generate dynamic proxy.
	 */
	@Override
	public UserService createCGlibDynamicProxy(UserService target) {
		MethodInterceptor interceptor = new CGlibInterceptor(target);
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(interceptor);
		enhancer.setInterfaces(new Class[] { UserService.class });
		UserService cglibProxy = (UserService) enhancer.create();
		return cglibProxy;
	}

	/**
	 * Low level method to dynamically generate dynamic proxy.
	 * @throws NotFoundException
	 * @throws CannotCompileException
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	@Override
	public UserService createJavassistDynamicProxyByByteCode(UserService target) throws InstantiationException, IllegalAccessException,
			NotFoundException, CannotCompileException, NoSuchFieldException, SecurityException {
		ClassPool mPool = new ClassPool(true);
		CtClass mCtc = mPool.makeClass(UserService.class.getName() + "JavaassistProxy");
		mCtc.addInterface(mPool.get(UserService.class.getName()));
		mCtc.addConstructor(CtNewConstructor.defaultConstructor(mCtc));
		mCtc.addField(CtField.make("public " + UserService.class.getName() + " target;", mCtc));
		mCtc.addMethod(CtNewMethod.make("public String sayHello(String name) { return target.sayHello(name); }", mCtc));
		Class<?> pc = mCtc.toClass();
		UserService javassistByteCodeProxy = (UserService) pc.newInstance();
		Field filed = javassistByteCodeProxy.getClass().getField("target");
		filed.set(javassistByteCodeProxy, target);
		return javassistByteCodeProxy;
	}

	/**
	 * High level method to dynamically generate dynamic proxy.
	 */
	@Override
	public UserService createJavassistDynamicProxy(UserService target) throws InstantiationException, IllegalAccessException {
		MethodHandler handler = new JavassistHandler(target);
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setInterfaces(new Class[] { UserService.class });
		Class<?> proxyClass = proxyFactory.createClass();
		UserService javassistProxy = (UserService) proxyClass.newInstance();
		((ProxyObject) javassistProxy).setHandler(handler);
		return javassistProxy;
	}

	/**
	 * Low level method to dynamically generate dynamic proxy. Tips: you can
	 * first create the proxy java file and compile, then use javap -c to
	 * decompilier the class file. Write code using ASM following the byte code
	 * instructions.
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	@Override
	public UserService createAsmDynamicProxy(UserService target) throws NoSuchFieldException, SecurityException, InstantiationException,
			IllegalAccessException {
		ClassWriter classWriter = new ClassWriter(0);
		String className = UserService.class.getName() + "AsmProxy";
		String classPath = className.replace('.', '/');
		String interfacePath = UserService.class.getName().replace('.', '/');
		classWriter.visit(Opcodes.V1_7, Opcodes.ACC_PUBLIC, classPath, null, "java/lang/Object", new String[] { interfacePath });

		MethodVisitor constructorVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
		constructorVisitor.visitCode();
		constructorVisitor.visitVarInsn(Opcodes.ALOAD, 0);
		constructorVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
		constructorVisitor.visitInsn(Opcodes.RETURN);
		constructorVisitor.visitMaxs(1, 1);
		constructorVisitor.visitEnd();

		FieldVisitor fieldVisitor = classWriter.visitField(Opcodes.ACC_PUBLIC, "target", "L" + interfacePath + ";", null, null);
		fieldVisitor.visitEnd();

		MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "sayHello", "(Ljava/lang/String;)Ljava/lang/String;", null, null);
		methodVisitor.visitCode();
		methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
		methodVisitor.visitFieldInsn(Opcodes.GETFIELD, classPath, "target", "L" + interfacePath + ";");
		methodVisitor.visitVarInsn(Opcodes.ALOAD, 1);
		methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, interfacePath, "sayHello", "(Ljava/lang/String;)Ljava/lang/String;");
		methodVisitor.visitInsn(Opcodes.ARETURN);
		methodVisitor.visitMaxs(2, 2);
		methodVisitor.visitEnd();
		classWriter.visitEnd();

		byte[] byteCode = classWriter.toByteArray();
		UserService asmProxy = (UserService) new CustomClassLoader().getClass(className, byteCode).newInstance();
		Field filed = asmProxy.getClass().getField("target");
		filed.set(asmProxy, target);
		return asmProxy;
	}

	private static class CustomClassLoader extends ClassLoader {
		public Class<?> getClass(String className, byte[] code) {
			return defineClass(className, code, 0, code.length);
		}
	}

}
