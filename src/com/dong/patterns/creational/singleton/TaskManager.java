package com.dong.patterns.creational.singleton;
/**
 * 单例模式
 * @author Administrator
 *
 */
public class TaskManager {
	
	private static TaskManager tm = null;
	private static int i = 0;
	
	private TaskManager() {	// 初始化窗口。构造函数私有，在类外无法创建TaskManager对象
		
	}
	
	public void displayProcesses() {
		System.out.println("显示进程");
	}
	
	public void displayServices() {
		System.out.println("显示服务");
	}

	// 获得单一实例
	public static TaskManager getInstance() {
		if(tm == null) {
			return new TaskManager();
		}
		return tm;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaskManager tm = new TaskManager();
		tm.displayProcesses();

	}

}
