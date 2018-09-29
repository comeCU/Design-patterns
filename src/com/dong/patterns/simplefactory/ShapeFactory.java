package com.dong.patterns.simplefactory;
/**
 * 工厂类
 * @author Administrator
 *
 */
public class ShapeFactory {
	
	public static Shape createShape(String type) throws UnsupportedShapeException {
		if(type.equals("Circle")) {
			return new Circle();
		} else if(type.equals("Rectangle")) {
			return new Rectangle();
		} else if(type.equals("Triangle")) {
			return new Triangle();
		} else {
			throw new UnsupportedShapeException("不支持该形状！");
		}
	}

}
