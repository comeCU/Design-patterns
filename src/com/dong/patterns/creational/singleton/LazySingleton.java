package com.dong.patterns.creational.singleton;
/**
 * 懒汉式单例模式
 * 优点：无需一直占用系统资源，实现了延迟加载
 * 缺点：必须处理好多线程同时访问问题、性能也将受到一定影响
 * @author Administrator
 *
 */
public class LazySingleton {
	
	private static LazySingleton instance = null;
	
	private LazySingleton() {
		
	}
	
	/**
	 * 线程锁定
	 * 并发环境会大大降低系统性能
	 * @return
	 */
	/*synchronized public static LazySingleton getInstance() {
		if(instance == null) {
			return new LazySingleton();
		}
		return instance;
	}*/
	
	/**
	 * 改进
	 * 只锁定单个语句
	 * 缺点： 如果线程A、B同时调用该方法，判断条件将会出错，产生多个实例，违背单例模式设计思想
	 * @return
	 */
	/*public static LazySingleton getInstance() {
		if(instance == null) {
			synchronized (LazySingleton.class) {	// 信号量
				instance = new LazySingleton();
			}
		}
		return instance;
	}*/
	
	/**
	 * 再改进
	 * 双重检查锁定
	 * @return
	 */
	public static LazySingleton getInstance() {
		if(instance == null) {	// 第一重判断
			synchronized (LazySingleton.class) {
				if(instance == null) {	// 第二重判断
					instance = new LazySingleton();
				}
			}
		}
		return instance;
	}
	
	

}
