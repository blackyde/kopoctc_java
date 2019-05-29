package com.javachobo.jbp;

public class FactoryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Factory fc = new Factory();
		
		Shape shape1 = fc.getShape("circle");
		
		shape1.draw();
		
		Shape shape2 = fc.getShape("square");
		
		shape2.draw();
		
		Shape shape3 = fc.getShape("rectangle");
		
		shape3.draw();
		
	}

}
