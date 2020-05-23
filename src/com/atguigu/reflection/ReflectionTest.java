package com.atguigu.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class ReflectionTest {
	
	//反射之前
	@Test
	public void test1() {
		
	}
	
	//反射之后 对于Person 类的操作
	@Test
	public void test2() throws Exception {
		// 通过反射创建对象
		Class cla = Person.class;
		Constructor cons = cla.getConstructor(String.class,int.class);
		Object object = cons.newInstance("Tom",22);
		Person person = (Person) object;
		System.out.println(person.toString());
		
		// 通过反射调用属性
		Field age = cla.getDeclaredField("age");
		age.set(object, 25);
		System.out.println(object.toString());
		
		// 通过反射调用方法
		Method show = cla.getDeclaredMethod("show");
		show.invoke(object);
		
		System.out.println("*****下面调用私有属性方法*****");
		
		Constructor cons1 = cla.getDeclaredConstructor(String.class);
		cons1.setAccessible(true);
		Person person2 = (Person) cons1.newInstance("Herry");
		System.out.println(person2);
		
		Field name = cla.getDeclaredField("name");
		name.setAccessible(true);
		name.set(person2, "Jerry");
		System.out.println(person2);
		
		Method showNation = cla.getDeclaredMethod("showNation", String.class);
		showNation.setAccessible(true);
		showNation.invoke(person2, "China");
		
	}
	
	//获取 class 实例的方法
	@Test
	public void test3() throws ClassNotFoundException {
		//调用运行时类的属性
		Class cla1 = Person.class;
		System.out.println(cla1);
		
		//通过运行时类的对象 调用getClass方法
		Person person = new Person();
		Class cla2 = person.getClass();
		System.out.println(cla2);
		
		//调用class的静态方法 forName()
		//该方式用的更多
		Class cla3 = Class.forName("com.atguigu.reflection.Person");
		System.out.println(cla3);
		
		//使用类的加载器
		ClassLoader classLoader = ReflectionTest.class.getClassLoader();
		Class cla4 = classLoader.loadClass("com.atguigu.reflection.Person");
		System.out.println(cla4);
	}
	
}
