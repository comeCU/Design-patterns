package com.dong.patterns.abstractfactory;
/**
 * 
 * @ClassName: Client 
 * @Description: 
 * @author: dong
 * @date: 2018年9月30日 上午10:45:33 
 * @keyword: 
 *
 */
public class Client {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        DBFactory dbFactory;
        Connection connection;
        Statement statement;
//        dbFactory = new MySQLFactory();
        dbFactory = (DBFactory) XMLUtil.getBean();
        connection = dbFactory.createConnection();
        statement = dbFactory.createStatement();
        connection.connect();
        statement.executeStatement();
    }

}
