package com.dong.patterns.structural.decorator;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Decorator Pattern
//  @ File Name : Beverage.java
//  @ Date : 2018/11/4
//  @ Author : dong
//
//



// ���󹹼�������
public abstract class Beverage {
    public String description = "Unknow Becerage";
    
    public String getDescription() {
        return description;
    }
    
    public abstract int cost();
}
