package com.dong.patterns.structural.bridge;

public class Client {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Image image;
        ImageImp imp;
        image = (Image) XMLUtil.getBean(0);
        imp = (ImageImp) XMLUtil.getBean(1);
        
        image.setImageImp(imp);
        image.parseFile("bridge");
    }

}
