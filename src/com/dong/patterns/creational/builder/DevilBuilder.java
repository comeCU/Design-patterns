package com.dong.patterns.creational.builder;

/**
 * 恶魔角色建造器：具体建造者
 */
public class DevilBuilder extends ActorBuilder {

    @Override
    public void buildType() {
        // TODO Auto-generated method stub
        actor.setType("恶魔");
    }

    @Override
    public void buildSex() {
        // TODO Auto-generated method stub
        actor.setSex("妖");
    }

    @Override
    public void buildFace() {
        // TODO Auto-generated method stub
        actor.setFace("丑陋");
    }

    @Override
    public void buildCostume() {
        // TODO Auto-generated method stub
        actor.setCostume("黑衣");
    }

    @Override
    public void buildHairstyle() {
        // TODO Auto-generated method stub
        actor.setHairstyle("光头");
    }

   

}