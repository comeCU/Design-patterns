package com.dong.patterns.creational.simplefactory;

public class Rectangle implements Shape {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("绘制长方形");
	}

	@Override
	public void erase() {
		// TODO Auto-generated method stub
		System.out.println("擦除长方形");
	}

}
