package com.dong.patterns.behavioral.chainofresponsibility;
/**
 * 
 * @ClassName: Client 
 * @Description: 客户端
 * @author: dong
 * @date: 2018年11月16日 上午11:17:06 
 * @keyword: 纯的职责链模式
 *
 */
public class Client {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Approver zhangsan,lisi,wangwu,congressA;
        zhangsan = new Director("张三");
        lisi = new VicePresident("李四");
        wangwu = new President("王五");
        congressA = new Congress("董事会A");
        
        // 创建职责链
        zhangsan.setSuccessor(lisi);
        lisi.setSuccessor(wangwu);
        wangwu.setSuccessor(congressA);
        
        // 创建采购单
        PurchaseRequest pr1 = new PurchaseRequest(2000.0d, 1, "购买打印机");
        zhangsan.processRequest(pr1);
        
        PurchaseRequest pr2 = new PurchaseRequest(60000.0d, 2, "采购电脑");
        zhangsan.processRequest(pr2);
        
        PurchaseRequest pr3 = new PurchaseRequest(160000.0d, 3, "租用云服务器");
        zhangsan.processRequest(pr3);
        
        PurchaseRequest pr4 = new PurchaseRequest(50000000.0d, 4, "建厂房");
        zhangsan.processRequest(pr4);
        
    }

}
