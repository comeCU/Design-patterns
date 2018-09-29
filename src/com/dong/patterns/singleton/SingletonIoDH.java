package com.dong.patterns.singleton;

/**
 * IoDH
 * 基于Java语言特性，在单例类中增加一个静态内部类
 * 
 * 优点：既可以实现延迟加载，又可以保证线程安全，不影响系统性能
 * 缺点：受限于编程语言特性
 * @author Administrator
 *
 */
public class SingletonIoDH {
	
	private SingletonIoDH() {
		
	}
	
	// 静态内部类
	private static class HolderClass {
		private final static SingletonIoDH instance = new SingletonIoDH();
		
	}

	public static SingletonIoDH getInstance() {
		return HolderClass.instance;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingletonIoDH s1, s2;
		s1 = SingletonIoDH.getInstance();
		s2 = SingletonIoDH.getInstance();
		
		System.out.println(s1 == s2);

	}

}
