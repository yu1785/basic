package com.atguigu.dynamicProxy;

/**
 * 静态代理举例
 * @author zhengxinyu
 *
 */

interface ClothFactory{
	
	void produceCloth();
	
}

//代理类
class ProxyClothFactory implements ClothFactory{

	private ClothFactory factory;
	
	public ProxyClothFactory(ClothFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void produceCloth() {
		// TODO Auto-generated method stub
		System.out.println("代理工厂准备...");
		factory.produceCloth();
		System.out.println("代理工厂收尾...");
	}
	
}

//被代理类
class NikeClothFactory implements ClothFactory{

	@Override
	public void produceCloth() {
		// TODO Auto-generated method stub
		System.out.println("Nike工厂生产...");
	}
	
}

public class StaticProxyTest {
	
	public static void main(String[] args) {
		
		NikeClothFactory factory = new NikeClothFactory();
		
		ProxyClothFactory proxyFactory = new ProxyClothFactory(factory);
		
		proxyFactory.produceCloth();
		
	}
	
}
