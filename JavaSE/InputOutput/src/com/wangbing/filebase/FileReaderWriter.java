package com.wangbing.filebase;/*
 * @author WangBing
 * @version 1.0
    FileReader 相关方法：
        1) new FileReader(File/String)
        2）read∶每次读取单个字符，返回该字符，如果到文件末尾返回-1
        3）read（char【】）∶批量读取多个字符到数组，返回读取到的字符数，如果到文件末尾返回-1
        相关API∶
        1）new String（char【】）∶将char【】转换成String
        2）new String（char【】，off，len）∶将char【】的指定部分转换成String
    FileWriter 常用方法
        1）new FileWriter（File/String）∶覆盖模式，相当于流的指针在首端
        2）new FileWriter（File/String，true）∶追加模式，相当于流的指针在尾端
        3）write（int）∶写入单个字符
        4）write（char【】）∶写入指定数组
        5）write（char【】，off，len）∶写入指定数组的指定部分
        6）write（string）∶写入整个字符串7）write（string，off，len）∶写入字符串的指定部分
        相关API: String类  toCharArray将String转换成char【】
        注意∶FileWriter使用后，必须要关闭（close）或刷新（flush），否则写入不到指定的文件!
 **/

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderWriter {
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
