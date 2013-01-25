/**
 * HelloWorldDumpTest.java ����7:14:45 2012-9-10
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
	 * <p>java�Ǿ�̬���ԣ�������ͨ���ֽ��빤����ģ�⶯̬���ԣ�������ʱ���ɣ�����չ�� class��</p>
	 * <li>��������ʾ��̬����HelloWorld�ࡣ
	 * <p>1.ʹ��asm�������{@link HelloWorld.java}�õ�{@link HelloWorldDump.java}������İ�װ��ʹ�ÿɲμ���<a href="http://asm.ow2.org/eclipse/index.html">�ٷ���վ</a>��</p>
	 * <p>����ͨ����Ӧ����Ҫ�޸�{@link HelloWorldDump.java}�����ɸ�������HelloWorld.class��</p>
	 * <p>2.����ʱ������ɾ�� {@link HelloWorld.java}����֤����ʱʹ�õ��Ƕ�̬���ɵ�Class��</p>
	 *
	 * @throws Exception
	 */
	@Test
	public void test() throws Exception {
		//�����ֽ���
		byte[] byteCodes = HelloWorldDump.dump();
		// �����ֽ�����Class����
		Class<?> clazz = AsmUtils.defineClass("org.objectweb.asm.demo.HelloWorld", byteCodes, Thread.currentThread().getContextClassLoader());
		// ���������ɵ�Class������ֻ��ͨ��������÷�����
		Method method = clazz.getMethod("sayHello");
		method.invoke(clazz.newInstance());
	}
	

}
