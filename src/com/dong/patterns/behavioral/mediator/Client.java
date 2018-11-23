package com.dong.patterns.behavioral.mediator;
/**
 * 
 * @ClassName: Client 
 * @Description: 中介者模式
 * @author: dong
 * @date: 2018年11月23日 下午12:02:02 
 * @keyword: 
 *
 */
public class Client {

    public static void main(String[] args) {
        // 定义中介者对象
        ConcreteMediator mediator;
        mediator = new ConcreteMediator();
        
        // 定义同事对象
        Button addBT = new Button();
        MyList myList = new MyList();
        ComboBox cb = new ComboBox();
        TextBox userNameTB = new TextBox();
        
        addBT.setMediator(mediator);
        myList.setMediator(mediator);
        cb.setMediator(mediator);
        userNameTB.setMediator(mediator);
        
        mediator.addButton = addBT;
        mediator.myList = myList;
        mediator.cb = cb;
        mediator.userNameTextBox = userNameTB;
        
        addBT.changed();
        System.out.println("===================");
        myList.changed();
        
    }

}
