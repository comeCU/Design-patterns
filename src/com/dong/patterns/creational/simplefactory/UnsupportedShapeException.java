package com.dong.patterns.creational.simplefactory;

/**
 * 自定义异常类
 * @author Administrator
 *
 */
public class UnsupportedShapeException extends Exception {
	
	public UnsupportedShapeException(String message) {
		super(message);
	}
	
}
