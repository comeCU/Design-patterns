package com.dong.patterns.structural.adapter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * JDK 源码中适配器模式实例测试
 * Reader(Target),InputStreamReader(Adapter),InputStream(Source)
 * 
 * @ClassName: TestInputStreamReader 
 * @Description: 
 * @author: dong
 * @date: 2018年10月14日 下午6:12:09 
 * @keyword: 
 *
 */
public class TestInputStreamReader {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        InputStreamReader in;
        
        try {
            // aaa.txt文件与TestInputStreamReader文件处于同一目录，用相对路径读取
            in = new InputStreamReader(new FileInputStream(TestInputStreamReader.class.getResource("aaa.txt").getPath()));
            
            int ch;
            while((ch = in.read()) != -1) {
                System.out.print((char)ch);
            }
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
