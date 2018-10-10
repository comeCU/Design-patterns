package com.dong.patterns.creational.simplefactory;

public class Triangle implements Shape {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("绘制三角形");
	}

	@Override
	public void erase() {
		// TODO Auto-generated method stub
		System.out.println("擦除三角形");
	}

}
