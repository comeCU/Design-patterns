# 代理模式——XML-RPC学习笔记



## 什么是RPC

​	RPC要像调用本地函数一样去调用远程函数。

> https://www.zhihu.com/question/25536695/answer/221638079



## XML-RPC图解

![](https://github.com/comeCU/Design-patterns/raw/master/starUML_files/others/md_image/xml-rpc01.png)

> http://xmlrpc.scripting.com/



![](https://github.com/comeCU/Design-patterns/raw/master/starUML_files/others/md_image/xml-rpc02.png)

> https://www.cnblogs.com/buptzym/archive/2012/11/10/2764342.html





## 原理及底层实现分析

暂无。



## 案例分析(附代码)

通过xml-rpc远程调用服务端的sayHello方法和add方法。

### 项目创建

0. 运行环境：win7、eclipse、jdk8.0、apache-xmlrpc-3.1.3、Tomcat7.0
1. 创建Dynamic Wed Project
2. 将解压后的xmlrpc文件全部jar包添加到项目路径下，add to build path

> apache-xmlrpc-3.1.3官网下载：http://archive.apache.org/dist/ws/xmlrpc/



### 服务器端

#### 业务接口与实现

```java
package com.dong.xmlrpc;
/**
 * 
 * @ClassName: ServicesHandler 
 * @Description: 业务处理接口
 * @author: dong
 * @date: 2018年11月11日 下午3:25:23 
 * @keyword: 
 *
 */
public interface ServicesHandler {
    
    public String sayHello(String str);
    public int add(int num1, int num2);
  
}
```



```java
package com.dong.xmlrpc;
/**
 * 
 * @ClassName: HelloHandler 
 * @Description: 业务接口实现
 * @author: dong
 * @date: 2018年11月11日 下午3:27:10 
 * @keyword: 
 *
 */
public class HelloHandler implements ServicesHandler {

    public String sayHello(String str) {
        // TODO Auto-generated method stub
        return "hello " + str + "!";
    }

    public int add(int num1, int num2) {
        // TODO Auto-generated method stub
        return num1 + num2;
    }
}
```



#### Server

```java
package com.dong.xmlrpc;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.XmlRpcServletServer;

/**
 * 
 * @ClassName: XmlRpcServicesServlet 
 * @Description: 服务端
 * @author: dong
 * @date: 2018年11月11日 下午3:28:09 
 * @keyword: 
 *
 */
public class XmlRpcServicesServlet extends HttpServlet {
	private XmlRpcServletServer  server;
	
    @Override
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        super.init(config);
        try {
            // 创建XmlRpcServicesServlet对象
            server = new XmlRpcServletServer();
            
            //set up handler mapping of XmlRpcServletServer object
            PropertyHandlerMapping pmp = new PropertyHandlerMapping(); 
            pmp.addHandler("HelloHandler", HelloHandler.class);
            server.setHandlerMapping(pmp);
            
            //more config of XmlRpcServletServer object
            XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) server.getConfig();
            serverConfig.setEnabledForExceptions(true);
            serverConfig.setContentLengthOptional(false);
            
        } catch (XmlRpcException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }  
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        
        server.execute(request, response);
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	    server.execute(request, response);
	}
}
```



#### web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" id="WebApp_ID" version="2.5">
  <display-name>Rpc</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  <servlet>
    <description></description>
    <display-name>XmlRpcServicesServlet</display-name>
    <servlet-name>XmlRpcServicesServlet</servlet-name>
    <servlet-class>com.dong.xmlrpc.XmlRpcServicesServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>XmlRpcServicesServlet</servlet-name>
    <url-pattern>/HelloHandler</url-pattern>
  </servlet-mapping>
</web-app>
```



### 客户端Client

```java
package com.dong.xmlrpc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

/**
 * 
 * @ClassName: TestClient 
 * @Description: 客户端
 * @author dong 
 * @date Nov 6, 2018 10:02:43 PM 
 * @keywords : 
 *
 */
public class TestClient {
    public static void main(String[] args) {
        try {
            // 配置客户端
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            // 设置服务端地址
            config.setServerURL(new URL("http://127.0.0.1:8080/Rpc/HelloHandler"));
            // 创建XmlRpc客户端
            XmlRpcClient client = new XmlRpcClient();
            // 绑定以上设置
            client.setConfig(config);
            // 创建参数列表
            Vector<String> params1 = new Vector<String>();
            
            params1.addElement("dong");
            
            Object[] params2 = new Object[2];
            params2[0] = 23;
            params2[1] = 20; 
            
            // 执行xml-rpc请求
            String result1 = (String) client.execute("HelloHandler.sayHello", params1);
            System.out.println("reslut:" + result1);
            
            int result2 = (Integer) client.execute("HelloHandler.add", params2);
            
            System.out.println("result:" + result2);
            
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (XmlRpcException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   
    }
}
```



### 测试

0. 如果没有云服务器，可以采用局域网测试
1. 启动在局域网中的两台电脑，修改URL，分别运行服务端和客户端程序。
2. 在client端查看运行效果



### 结果

![testxml-rpc](https://github.com/comeCU/Design-patterns/raw/master/starUML_files/others/md_image/testxml-rpc.png)



> 官方文档参考：http://ws.apache.org/xmlrpc/client.html



## 总结及其它

当前主流的RPC框架有Google开源的gRpc，阿里巴巴开源的Dubbo，以及nettyRpc等。这是一片广阔而深远的天地，在学习设计模式的代理模式一节中，有幸涉猎，看了很多论文和大牛的博客文章，依旧没能登堂入室。知识需要深入实践，no code，no text。

> https://github.com/grpc/grpc
>
> https://github.com/apache/incubator-dubbo
>
> 案例源码：https://github.com/comeCU/Design-patterns/blob/master/starUML_files/others/Rpc.zip



