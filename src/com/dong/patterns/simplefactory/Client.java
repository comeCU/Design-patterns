package com.dong.patterns.simplefactory;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*Shape shape;
		try {
			shape = ShapeFactory.createShape("Circle");
			shape.draw();
			shape.erase();
		} catch (UnsupportedShapeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			System.out.println(e.getMessage());
		}*/
		
		
		//  π”√config.xml
		Shape shape;
		String type = XMLUtil.getChartType();
		try {
			shape = ShapeFactory.createShape(type);
			shape.draw();
			shape.erase();
			
		} catch (UnsupportedShapeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
