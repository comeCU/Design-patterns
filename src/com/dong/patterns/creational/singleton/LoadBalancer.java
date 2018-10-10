package com.dong.patterns.creational.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 负载均衡器
 * @author Administrator
 *
 */
public class LoadBalancer {

	private static LoadBalancer instance = null;
	private List serverList = null;
	
	// 私有构造方法
	private LoadBalancer() {
		serverList = new ArrayList<>();
	}
	
	/**
	 * 公有静态成员方法，返回唯一实例
	 * @return
	 */
	public static LoadBalancer getLoadBalancer() {
		if(instance == null) {
			return new LoadBalancer();
		}
		return instance;
	}
	
	/**
	 * 增加服务器
	 * @param server
	 */
	public void addServer(String server) {
		serverList.add(server);
	}
	
	/**
	 * 删除服务器
	 * @param server
	 */
	public void removeServer(String server) {
		serverList.remove(server);
	}
	
	/**
	 * 随机返回服务器
	 * @return
	 */
	public String getServer() {
		Random random = new Random();
		int i = random.nextInt(serverList.size());
		return (String)serverList.get(i);
		
	}
	
}
