package com.dong.patterns.creational.simplefactory;

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

	public static String getChartType() {
		DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			
			Document doc;
			doc = builder.parse(new File("D:\\Users\\Administrator\\Documents\\eclipse_for_javaWeb_workspace\\Design-patterns\\src\\com\\dong\\patterns\\creational\\simplefactory\\config.xml"));
			// 绝对路径
			
			NodeList nl = doc.getElementsByTagName("chartType");
			Node classNode = nl.item(0).getFirstChild();
			String chartType = classNode.getNodeValue().trim();
			
			return chartType;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
