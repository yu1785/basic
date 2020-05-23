package com.atguigu.reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

public class ClassLoaderTest {
	
	@Test
	public void test1() {
		
		//对于自定义的类 使用系统类加载器进行加载
		ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
		ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
		System.out.println(systemClassLoader);
		System.out.println(classLoader);
		
		//调用系统类加载器的getParent() 获取扩展类加载器
		ClassLoader classLoader2 = classLoader.getParent();
		System.out.println(classLoader2);
		
		//调用扩展类加载器的getParent() 无法获取引导类加载器
		// 引导类加载器主要负责加载java的核心类库，无法加载自定义类的
		ClassLoader classLoader3 = classLoader2.getParent();
		System.out.println(classLoader3);
		
		ClassLoader classLoader4 = String.class.getClassLoader();
		System.out.println(classLoader4);
		
	}
	
	@Test
	public void test2() throws Exception {
		
		 Properties properties = new Properties();
		 
		 //读取配置文件的方式一
//		 FileInputStream fis = new FileInputStream("jdbc.propertise");
		 FileInputStream fis = new FileInputStream("src\\jdbc1.propertise");
		 properties.load(fis);
		 
		//读取配置文件的方式二 使用类加载器
		 //配置文件默认识别为 当前工程的src下
//		 ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
//		 InputStream fi = classLoader.getResourceAsStream("jdbc1.propertise");
//		 properties.load(fi);
		 
		 String user = properties.getProperty("user");
		 String password = properties.getProperty("password");
		 System.out.println(user+"..."+password);
		
	}
	
	
}
