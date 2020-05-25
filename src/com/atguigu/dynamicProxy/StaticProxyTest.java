package com.atguigu.dynamicProxy;

/**
 * ��̬�������
 * @author zhengxinyu
 *
 */

interface ClothFactory{
	
	void produceCloth();
	
}

//������
class ProxyClothFactory implements ClothFactory{

	private ClothFactory factory;
	
	public ProxyClothFactory(ClothFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void produceCloth() {
		// TODO Auto-generated method stub
		System.out.println("������׼��...");
		factory.produceCloth();
		System.out.println("��������β...");
	}
	
}

//��������
class NikeClothFactory implements ClothFactory{

	@Override
	public void produceCloth() {
		// TODO Auto-generated method stub
		System.out.println("Nike��������...");
	}
	
}

public class StaticProxyTest {
	
	public static void main(String[] args) {
		
		NikeClothFactory factory = new NikeClothFactory();
		
		ProxyClothFactory proxyFactory = new ProxyClothFactory(factory);
		
		proxyFactory.produceCloth();
		
	}
	
}
