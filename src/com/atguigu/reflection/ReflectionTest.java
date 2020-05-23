package com.atguigu.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class ReflectionTest {
	
	//����֮ǰ
	@Test
	public void test1() {
		
	}
	
	//����֮�� ����Person ��Ĳ���
	@Test
	public void test2() throws Exception {
		// ͨ�����䴴������
		Class cla = Person.class;
		Constructor cons = cla.getConstructor(String.class,int.class);
		Object object = cons.newInstance("Tom",22);
		Person person = (Person) object;
		System.out.println(person.toString());
		
		// ͨ�������������
		Field age = cla.getDeclaredField("age");
		age.set(object, 25);
		System.out.println(object.toString());
		
		// ͨ��������÷���
		Method show = cla.getDeclaredMethod("show");
		show.invoke(object);
		
		System.out.println("*****�������˽�����Է���*****");
		
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
	
	//��ȡ class ʵ���ķ���
	@Test
	public void test3() throws ClassNotFoundException {
		//��������ʱ�������
		Class cla1 = Person.class;
		System.out.println(cla1);
		
		//ͨ������ʱ��Ķ��� ����getClass����
		Person person = new Person();
		Class cla2 = person.getClass();
		System.out.println(cla2);
		
		//����class�ľ�̬���� forName()
		//�÷�ʽ�õĸ���
		Class cla3 = Class.forName("com.atguigu.reflection.Person");
		System.out.println(cla3);
		
		//ʹ����ļ�����
		ClassLoader classLoader = ReflectionTest.class.getClassLoader();
		Class cla4 = classLoader.loadClass("com.atguigu.reflection.Person");
		System.out.println(cla4);
	}
	
}
