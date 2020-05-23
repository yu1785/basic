package com.atguigu.reflection;

import java.util.Random;

import org.junit.Test;

/**
 * 	ͨ�����䴴������ʱ��Ķ���
 * @author dell
 *
 */
public class NewInstanceTest {
	
	@Test
	public void test1() throws InstantiationException, IllegalAccessException {
		
		Class cla = Person.class;
		/**
		 * 	newInstance()  ���ô˷��� �� ������Ӧ������ʱ��Ķ���
		 * 	�ڲ�����������ʱ��Ŀղι�����
		 * 
		 * 	Ҫ��˷�������������Ӧ������ʱ��Ķ���  Ҫ��
		 * 	1 ����ʱ������ṩ�ղι�����
		 * 	2 �ղι������ķ���Ȩ�޵ù�  ͨ������Ϊpublic
		 * 
		 * 	javabean ��Ҫ���ṩ�ղι�����  ԭ��
		 * 	1 ����ͨ������ ��������ʱ��Ķ���
		 * 	2 ��������̳д�����ʱ��ʱ  Ĭ�ϵ���super()ʱ ��֤�����д˹����� 
		 */
		Object obj = cla.newInstance();
		System.out.println(obj);
		
	}
	
	// ����Ķ�̬��
	@Test
	public void test2() throws Exception{
		
		for (int i = 0; i < 100; i++) {
			int num = new Random().nextInt(3);
			String classPath = "";
			switch (num) {
				case 0:
					classPath = "java.util.Date";
					break;
				case 1:
					classPath = "java.lang.Object";
					break;
				case 2:
					classPath = "com.atguigu.reflection";
					break;
			}
			
			try {
				Object obj = getInstance(classPath);
				System.out.println(obj);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
//		Class cla = Class.forName("com.atguigu.reflection.Person");
//		Object obj = cla.newInstance();
//		System.out.println(obj);
	}
	
	public Object getInstance(String classPath) throws Exception{
		Class cla = Class.forName(classPath);
		return cla.newInstance();
	}
	
	
	
}
