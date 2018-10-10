package com.dong.patterns.builder;

/**
 * 角色建造器：抽象建造者
 */
public abstract class ActorBuilder {

    /**
     * Default constructor
     */
    public ActorBuilder() {
    }

    /**
     * 
     */
    protected Actor actor = new Actor();


    /**
     * @return
     */
    public abstract void buildType();

    /**
     * @return
     */
    public abstract void buildSex();

    /**
     * @return
     */
    public abstract void buildFace();

    /**
     * @return
     */
    public abstract void buildCostume();

    /**
     * @return
     */
    public abstract void buildHairstyle();

    /**
     * 工厂方法，返回一个完整的游戏角色对象
     * @return
     */
    public Actor createActor() {
        // TODO implement here
        return actor;
    }

}