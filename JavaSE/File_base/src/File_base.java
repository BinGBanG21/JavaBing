import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/*
    文件流
        文件在程序中是以流的形式来操作的
            输出流∶数据在数据源（文件）和程序（内存）之间经历的路径
            输入流∶数据从数据源（文件）到程序（内存）的路径
        常用的文件操作
            创建文件对象相关构造器和方法
               相关方法
                    new File（String pathname）               //根据路径构建一个File对象
                    new File（File parent，String child）     //根据父目录文件+子路径构建
                    new File（String parent，String child）   //根据父目录+子路径构建
                    createNewFile                            //创建新文件
        获取文件的相关信息
            getName、getAbsolutePath、getParent、length、exists、isFile、isDirectory
* */
public class File_base {
    public static void main(String[] args) {
    }

    //方式 1 new File(String pathname)
    @Test
    public void create01() {
        String filePath = "e:\\news1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式 2 new File(File parent,String child) //根据父目录文件+子路径构建
    //e:\\news2.txt
    @Test
    public void create02() {
        File parentFile = new File("e:\\");
        String fileName = "news2.txt";
        //这里的 file 对象，在 java 程序中，只是一个对象
        //只有执行了 createNewFile 方法，才会真正的，在磁盘创建该文件
        File file = new File(parentFile, fileName);
        try {
            file.createNewFile();
            System.out.println("创建成功~");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式 3 new File(String parent,String child) //根据父目录+子路径构建
    @Test
    public void create03() {
        //String parentPath = "e:\\";
        String parentPath = "e:\\";
        String fileName = "news4.txt";
        File file = new File(parentPath, fileName);
        try {
            file.createNewFile();
            System.out.println("创建成功~");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //下面四个都是抽象类
    //InputStream
    //OutputStream
    //Reader //字符输入流
    //Writer //字符输出流
}