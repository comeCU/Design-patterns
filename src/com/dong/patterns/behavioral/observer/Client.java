package com.dong.patterns.behavioral.observer;
/**
 * 
 * @ClassName: Client 
 * @Description: 客户端
 * @author: dong
 * @date: 2018年11月18日 下午7:11:58 
 * @keyword: 
 *
 */
public class Client {

    public static void main(String[] args) {
        // 定义观察目标对象
        AllyControlCenter acc;
        acc = new ConcreteAllyControlCenter("金庸群侠");
        // 定义观察者
        Observer player1, player2, player3, player4;
        
        player1 = new Player("杨过");
        acc.join(player1);
        
        player2 = new Player("小龙女");
        acc.join(player2);
        
        player3 = new Player("郭靖");
        acc.join(player3);
        
        player4 = new Player("黄蓉");
        acc.join(player4);
        
        player1.beAttacked(acc);
        
    }

}
