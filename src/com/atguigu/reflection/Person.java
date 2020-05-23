package com.atguigu.reflection;

public class Person {
	private String name;
	public int age;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age) {
//		super();
		this.name = name;
		this.age = age;
	}
	
	private Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public void show() {
		System.out.println("hello,I'm a person");
	}
	
	private String showNation(String nation) {
		System.out.println("I'm from "+ nation);
		return nation;
	}
	
	
}
