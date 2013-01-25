/**
 * AsmUtils.java ����7:21:58 2012-9-10
 *
 * Copyright(c) 2000-2012 HC360.COM, All Rights Reserved.
 */
package org.objectweb.asm.demo;

import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;

/**
 * <p>�����ֽ���õ�Class����Ĺ����ࡣ</p>
 * 
 * @author dixingxing	
 * @date 2012-9-10
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class AsmUtils {
	private static Method defineClass;
	private static final ProtectionDomain PROTECTION_DOMAIN;

	static {
		PROTECTION_DOMAIN = AccessController.doPrivileged(new PrivilegedAction<ProtectionDomain>() {
					public ProtectionDomain run() {
						return HelloWorldDumpTest.class.getProtectionDomain();
					}
				});

		AccessController.doPrivileged(new PrivilegedAction() {
			public Object run() {
				try {
					Class loader = Class.forName("java.lang.ClassLoader"); // JVM crash w/o this
					defineClass = loader.getDeclaredMethod("defineClass",
							new Class[] { String.class, byte[].class,
									Integer.TYPE, Integer.TYPE,
									ProtectionDomain.class });
					defineClass.setAccessible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} 
				return null;
			}
		});
	}
	
	/**
	 * 
	 * <p>�����ֽ�����Class����</p>
	 *
	 * @param className ��ȫ��
	 * @param b �ֽ���
	 * @param loader 
	 * @return
	 */
	public static Class<?> defineClass(String className, byte[] b,ClassLoader loader) {
		Object[] args = new Object[] { className, b, 0,
				b.length, PROTECTION_DOMAIN };
		try {
			return (Class<?>) defineClass.invoke(loader, args);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
