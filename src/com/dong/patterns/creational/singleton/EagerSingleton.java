package com.dong.patterns.creational.singleton;

/**
 * 饿汉式单例
 * 优点：调用速度、反应时间快，无需考虑多线程访问的情况，可以确保实例的唯一性
 * 缺点：需要消耗更多的系统资源、加载时间更长
 * @author Administrator
 *
 */
public class EagerSingleton {
	
	private static final EagerSingleton instance = new EagerSingleton();	// 在类加载时自行实例化
	private EagerSingleton() {
		
	}
	
	public static EagerSingleton getInstance() {
		return instance;
	}

}
