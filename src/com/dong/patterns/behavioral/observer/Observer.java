package com.dong.patterns.behavioral.observer;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Observer Pattern
//  @ File Name : Observer.java
//  @ Date : 2018/11/18
//  @ Author : dong
//
//



// ����۲�����
public interface Observer {
    public String getName();
    public void setName(String name);
    public void help();  // ֧Ԯ����
    public void beAttacked(AllyControlCenter acc);  // ���ܹ���
}
