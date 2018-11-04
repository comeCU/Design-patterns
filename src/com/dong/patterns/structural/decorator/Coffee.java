package com.dong.patterns.structural.decorator;
/**
 * 
 * @ClassName: Coffee 
 * @Description: 某咖啡店售卖咖啡时，可以根据顾客的要求在其中加入各种配料，
 *              咖啡店会根据所加入的配料来计算费用。咖啡店所供应的咖啡及配料的种类和价格如下：
 *              —————————————————————————————————————————————————————————————
 *              |     咖啡                              |   价格/杯 ($) |      配料          | 价格/份($) |
 *              |  蒸馏(Espresso)     |   25        | 摩卡(Mocha)  |  10      |
 *              |深度烘焙咖啡(DarkRoast)|   20        | 奶泡(Whip)   |   8      |
 *              —————————————————————————————————————————————————————————————
 * @author: dong
 * @date: 2018年11月4日 下午12:40:30 
 * @keyword: 
 *
 */
public class Coffee {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Beverage beverage = new Espresso();
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);
        System.out.println(beverage.getDescription() + " $ " + beverage.cost());
        
    }

}
