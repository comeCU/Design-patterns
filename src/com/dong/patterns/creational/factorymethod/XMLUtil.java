package com.dong.patterns.creational.factorymethod;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

/**
 * XML工具类读取配置文件
 * @author Administrator
 *
 */
public class XMLUtil {

	public static Object getBean() {
		DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			
			Document doc;
			doc = builder.parse(new File("src\\com\\dong\\patterns\\factorymethod\\config.xml"));
			// /Design-patterns/src/com/dong/patterns/factorymethod/config.xml
			// src\\com\\dong\\patterns\\factorymethod\\config.xml
			
			NodeList nl = doc.getElementsByTagName("className");
			Node classNode = nl.item(0).getFirstChild();
			String cName = classNode.getNodeValue().trim();
			
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
