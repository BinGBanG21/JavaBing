package com.wangbing.filebase;/*
    IO 流原理及流的分类
        Java IO 流原理
            1. I/O是Input/Output的缩写， I/O技术是非常实用的技术， 用于处理数据传输。如读/写文件，网络通讯等。
            2. Java程序中，对于数据的输入/输出操作以”流（stream）”的方式进行。
            3. java.io包下提供了各种“流”类和接口，用以获取不同种类的数据，并通过方法输入或输出数据
            4. 输入input∶读取外部数据（磁盘、光盘等存储设备的数据）到程序（内存）中。
            5. 输出output∶将程序（内存）数据输出到磁盘、光盘等存储设备中
        流的分类
            按操作数据单位不同分为:字节流（8 bit）二进制文件，字符流（按字符）文本文件
            按数据流的流向不同分为∶输入流，输出流
            按流的角色的不同分为∶节点流，处理流/包装流

* */

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

public class InputOutput {
    public static void main(String[] args) {


    }


    /**
     * 单个字符读取文件
     */
    @Test
    public void readFile01() {
        String filePath = "e:\\story.txt";
        FileReader fileReader = null;
        int data = 0;
        //1. 创建 FileReader 对象
        try {
            fileReader = new FileReader(filePath);
            //循环读取 使用 read, 单个字符读取
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 字符数组读取文件
     */
    @Test
    public void readFile02() {
        System.out.println("~~~readFile02 ~~~");
        String filePath = "e:\\story.txt";
        FileReader fileReader = null;
        int readLen = 0;
        char[] buf = new char[8];
        //1. 创建 FileReader 对象
        try {
            fileReader = new FileReader(filePath);
            //循环读取 使用 read(buf), 返回的是实际读取到的字符数
            //如果返回-1, 说明到文件结束
            while ((readLen = fileReader.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
