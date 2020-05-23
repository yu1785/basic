package com.atguigu.reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

public class ClassLoaderTest {
	
	@Test
	public void test1() {
		
		//�����Զ������ ʹ��ϵͳ����������м���
		ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
		ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
		System.out.println(systemClassLoader);
		System.out.println(classLoader);
		
		//����ϵͳ���������getParent() ��ȡ��չ�������
		ClassLoader classLoader2 = classLoader.getParent();
		System.out.println(classLoader2);
		
		//������չ���������getParent() �޷���ȡ�����������
		// �������������Ҫ�������java�ĺ�����⣬�޷������Զ������
		ClassLoader classLoader3 = classLoader2.getParent();
		System.out.println(classLoader3);
		
		ClassLoader classLoader4 = String.class.getClassLoader();
		System.out.println(classLoader4);
		
	}
	
	@Test
	public void test2() throws Exception {
		
		 Properties properties = new Properties();
		 
		 //��ȡ�����ļ��ķ�ʽһ
//		 FileInputStream fis = new FileInputStream("jdbc.propertise");
		 FileInputStream fis = new FileInputStream("src\\jdbc1.propertise");
		 properties.load(fis);
		 
		//��ȡ�����ļ��ķ�ʽ�� ʹ���������
		 //�����ļ�Ĭ��ʶ��Ϊ ��ǰ���̵�src��
//		 ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
//		 InputStream fi = classLoader.getResourceAsStream("jdbc1.propertise");
//		 properties.load(fi);
		 
		 String user = properties.getProperty("user");
		 String password = properties.getProperty("password");
		 System.out.println(user+"..."+password);
		
	}
	
	
}
