package com.dong.patterns.structural.bridge;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

/**
 * XML工具类读取配置文件
 * @ClassName: XMLUtil 
 * @Description: 
 * @author: dong
 * @date: 2018年9月30日 上午11:03:20 
 * @keyword: 
 *
 */
public class XMLUtil {

	public static Object getBean(int nodeNum) {
		DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			
			Document doc;
			doc = builder.parse(new File("src\\com\\dong\\patterns\\structural\\bridge\\config.xml"));
			// /Design-patterns/src/com/dong/patterns/factorymethod/config.xml
			// src\\com\\dong\\patterns\\factorymethod\\config.xml
			
			NodeList nl = doc.getElementsByTagName("className");
			Node classNode = nl.item(nodeNum).getFirstChild();   // 传入结点参数 反射获取相应的实例
			String cName = "com.dong.patterns.structural.bridge." + classNode.getNodeValue().trim();   // 拼接类路径			
			
			// 通过类名生成实例对象并将其返回
			Class c = Class.forName(cName);
			Object obj = c.newInstance();
			return obj;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
