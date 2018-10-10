package com.dong.patterns.builder;
/**
 * 客户端
 * @ClassName: Client 
 * @Description: 
 * @author dong 
 * @date Oct 10, 2018 10:21:52 PM 
 * @keywords : 
 *
 */
public class Client {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ActorBuilder ab;
        ab = (ActorBuilder)XMLUtil.getBean();
        
        ActorController ac = new ActorController();
        Actor actor;
        actor = ac.construct(ab);
        
        String type = actor.getType();
        System.out.println(type + "的外观:");
        System.out.println("性别" + actor.getSex());
        System.out.println("面容" + actor.getFace());
        System.out.println("服饰" + actor.getCostume());
        System.out.println("发型" + actor.getHairstyle());
    }

}
