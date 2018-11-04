package com.dong.patterns.structural.decorator;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Decorator Pattern
//  @ File Name : Whip.java
//  @ Date : 2018/11/4
//  @ Author : dong
//
//



//具体装饰类：配料 Whip
public class Whip extends CondimentDecorator {
    private final int WHIP_PRISE = 8;
    
    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }
    
    public String getDescription() {
        return this.beverage.getDescription() + ", Whip";
    }
    
    public int cost() {
        return WHIP_PRISE + this.beverage.cost();
    }
}
