package com.atguigu.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ��̬����ľ���
 * @author zhengxinyu
 *
 */

interface Human{
	
	String getBelief();
	void eat(String food);
	
}

//��������
class SuperMan implements Human{

	@Override
	public String getBelief() {
		// TODO Auto-generated method stub
		return "I can fly...";
	}

	@Override
	public void eat(String food) {
		// TODO Auto-generated method stub
		System.out.println("I like "+ food);
	}
	
}

class HumanUtil{
	
	public void method1() {
		System.out.println("*********ͨ�÷���һ*********");
	}
	
	public void method2() {
		System.out.println("*********ͨ�÷�����*********");
	}
}

/*
 * ��Ҫʵ�ֶ�̬����    ��Ҫ����������У�
 * 1  ��θ��ݼ��ص��ڴ��еı�������,��̬�Ĵ���һ�������༰�����
 * 2  ��ͨ��������Ķ�����÷���ʱ,��ζ�̬��ȥ���ñ��������е�ͬ������
 */

class ProxyFactory{
	//���ô˷���������һ��������Ķ���  �������һ
	public static Object getProxyInstance(Object obj) {
		
		MyInvocationHandler handler = new MyInvocationHandler();
		
		handler.bind(obj);
		
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
		
	}
}

class MyInvocationHandler implements InvocationHandler{

	private Object obj;//��Ҫʹ�ñ�������Ķ�����и�ֵ
	
	public void bind(Object obj) {
		this.obj = obj;
	}
	
	//������ͨ��������Ķ���,���÷���aʱ,���Զ��������·���
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		HumanUtil util = new HumanUtil();
		util.method1();
		
		// method  ��Ϊ���������õķ���
		// obj     ��������Ķ���
		Object returnValue = method.invoke(obj, args);
		
		util.method2();
		
		return returnValue;
	}
	
}

public class DynamicProxyTest {
	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		int x = 0;
		
		SuperMan superMan = new SuperMan();
		
		// proxyInstance ������Ķ���
		Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
		String belief = proxyInstance.getBelief();
		System.out.println(belief);
		proxyInstance.eat("hotpot");
		
		System.out.println("*********************");
		
		NikeClothFactory nikeClothFactory = new NikeClothFactory();
		ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
		proxyClothFactory.produceCloth();
	}
}


/*
 * �ӿڱ�����
 */
interface A{
	int x = 0;
	int x1 = 0;
}

class B{
	int x = 1;
	int x2 = 1;
}

class C extends B implements A{
	
	public void show() {
		
//		System.out.println(x);   // ����  xֵ����ȷ
		System.out.println(super.x);
		System.out.println(A.x);
		
		
		// û������ ����ֱ�ӵ���
		System.out.println(x1);
		System.out.println(x2);
	}
	
}

