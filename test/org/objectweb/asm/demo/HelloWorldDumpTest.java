/**
 * HelloWorldDumpTest.java 下午7:14:45 2012-9-10
 *
 * Copyright(c) 2000-2012 HC360.COM, All Rights Reserved.
 */
package org.objectweb.asm.demo;

import java.lang.reflect.Method;

import org.junit.Test;

/**
 * <p></p>
 * 
 * @author dixingxing	
 * @date 2012-9-10
 */
public class HelloWorldDumpTest {

	
	/**
	 * <p>java是静态语言，但可以通过字节码工具来模拟动态语言，在运行时生成（或扩展） class。</p>
	 * <li>本例仅演示动态生成HelloWorld类。
	 * <p>1.使用asm插件根据{@link HelloWorld.java}得到{@link HelloWorldDump.java}。插件的安装及使用可参见：<a href="http://asm.ow2.org/eclipse/index.html">官方网站</a>。</p>
	 * <p>（在通常的应用中要修改{@link HelloWorldDump.java}来生成更加灵活的HelloWorld.class）</p>
	 * <p>2.测试时可以先删除 {@link HelloWorld.java}，保证运行时使用的是动态生成的Class。</p>
	 *
	 * @throws Exception
	 */
	@Test
	public void test() throws Exception {
		//生成字节码
		byte[] byteCodes = HelloWorldDump.dump();
		// 根据字节码获得Class对象
		Class<?> clazz = AsmUtils.defineClass("org.objectweb.asm.demo.HelloWorld", byteCodes, Thread.currentThread().getContextClassLoader());
		// 由于是生成的Class，所以只能通过反射调用方法。
		Method method = clazz.getMethod("sayHello");
		method.invoke(clazz.newInstance());
	}
	

}
