package com.atguigu.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理的举例
 * @author zhengxinyu
 *
 */

interface Human{
	
	String getBelief();
	void eat(String food);
	
}

//被代理类
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
		System.out.println("*********通用方法一*********");
	}
	
	public void method2() {
		System.out.println("*********通用方法二*********");
	}
}

/*
 * 想要实现动态代理    需要解决的问题有：
 * 1  如何根据加载到内存中的被代理类,动态的创建一个代理类及其对象
 * 2  当通过代理类的对象调用方法时,如何动态的去调用被代理类中的同名方法
 */

class ProxyFactory{
	//调用此方法，返回一个代理类的对象  解决问题一
	public static Object getProxyInstance(Object obj) {
		
		MyInvocationHandler handler = new MyInvocationHandler();
		
		handler.bind(obj);
		
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
		
	}
}

class MyInvocationHandler implements InvocationHandler{

	private Object obj;//需要使用被代理类的对象进行赋值
	
	public void bind(Object obj) {
		this.obj = obj;
	}
	
	//当我们通过代理类的对象,调用方法a时,会自动调用如下方法
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		HumanUtil util = new HumanUtil();
		util.method1();
		
		// method  即为代理对象调用的方法
		// obj     被代理类的对象
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
		
		// proxyInstance 代理类的对象
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
 * 接口笔试题
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
		
//		System.out.println(x);   // 错误  x值不明确
		System.out.println(super.x);
		System.out.println(A.x);
		
		
		// 没有重名 可以直接调用
		System.out.println(x1);
		System.out.println(x2);
	}
	
}

