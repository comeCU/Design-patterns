package com.dong.patterns.structural.bridge;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Bridge Pattern
//  @ File Name : Image.java
//  @ Date : 2018/10/19
//  @ Author : dong
//
//



// ����ͼ���ࣺ������
public abstract class Image {
    protected ImageImp imp;
    public void setImageImp(ImageImp imp) {
        this.imp = imp;
    }
    
    public abstract void parseFile(String fileName);
}
