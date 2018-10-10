package com.dong.patterns.builder;

/**
 * 游戏角色常见控制器：指挥者
 */
public class ActorController {

    /**
     * Default constructor
     */
    public ActorController() {
    }

    /**
     * 逐步构建复杂产品对象
     * @param ActorBuilder ab 
     * @return
     */
    public Actor construct(ActorBuilder ab) {
        // TODO implement here
        Actor actor;
        ab.buildType();
        ab.buildSex();
        ab.buildFace();
        ab.buildCostume();
        ab.buildHairstyle();
        actor = ab.createActor();
    
        return actor;
    }

}