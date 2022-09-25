// hello world

// jdk jre jvm的关系
// JDK（java development kit）
// JDK是Java开发工具包,是整个Java的核心，包括了Java运行环境JRE、Java工具和Java基础类库。
// JRE（java runtime environment）
// JRE是Java的运行环境，包括JVM标准实现及Java核心类库。
// JVM（java virtual machine）
// JVM是java虚拟机，是整个java实现跨平台的最核心的部分，能够运行以Java语言写作的软件程序。
// 三者的关系
// JDK=JRE+其他
// JRE=JVM+其他

//环境变量配置及其作用
//配置环境变量是为了在任意位置 可以去使用jdk中的java命令 例如 javac java
//JAVA_HOME = 安装的路径
//然后Path中的 %JAVA_HOME%\bin  %%的作用 其实就是相当与一个路径变量

//java的编写步骤
//1.编写java的源代码
//2.编译java的代码为class文件
//3.运行的本质就是把class类加载到jvm中运行


public class Practice01{
	public static void main(String[] args){
		System.out.println("hello world");
		System.out.println("姓名\t姓名\t姓名\t姓名\r\nwangbing\twangbing\twangbing\twangbing");
		System.out.println("");
	}
}
