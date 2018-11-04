package com.dong.patterns.structural.decorator;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Decorator Pattern
//  @ File Name : Mocha.java
//  @ Date : 2018/11/4
//  @ Author : dong
//
//



// ����װ���ࣺ���� Mocha
public class Mocha extends CondimentDecorator {
    private final int MOCHA_PRISE = 10;
    
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }
    
    public String getDescription() {
        return this.beverage.getDescription() + ", Mocha";
    }
    
    public int cost() {
        return MOCHA_PRISE + this.beverage.cost();
    }
}