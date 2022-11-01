package com.wangbing.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChange {
    public static void main(String[] args) {
        //菜单肯定先展示一次 如果不选择 则继续显示
        //所以用do while循环来做
        boolean isLoop = true;
        Scanner scanner = new Scanner(System.in);
        String choose = "";
        String details = "";
        double money = 0;
        double balance = 0;
        Date date = null;
        String quit = "";

        //消费
        String note = "";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        do {
            System.out.println("========== 零钱通 ==========");
            System.out.println("\t\t1. 零钱明细");
            System.out.println("\t\t2. 收益入账");
            System.out.println("\t\t3. 消 费");
            System.out.println("\t\t4. 退 出");

            System.out.println("请选择（1-4）：");

            choose = scanner.next();

            //使用switch case 接受用户输入的各种情况 然后进行判断

            switch (choose) {
                case "1":
                    if (details == "") {
                        System.out.println("您还没有记账 快去记录几笔吧~");
                    } else {
                        System.out.println(details);
                    }
                    break;
                case "2":
                    System.out.println("请输入收益入账金额：");
                    money = scanner.nextDouble();
                    //在写判断条件的时候 要先写不满足的条件 这样可以减少分支 逻辑清晰 易于维护（游戏闯关）
                    if (money <= 0) {
                        System.out.println("您输入的金额有误，请重新输入");
                        break;
                    }
                    balance += money;
                    date = new Date();
                    details += "\n收益入账\t" + "+" + money + "\t" + sdf.format(date) + "\t" + "余额为：" + balance;
                    System.out.println(details);
                    break;
                case "3":
                    System.out.println("请输入消费事项：");
                    note = scanner.next();
                    System.out.println("请输入消费金额：");
                    money = scanner.nextDouble();
                    if (money <= 0 || money > balance) {
                        System.out.println("你的消费金额应该在 0- " + balance + "之间");
                    }
                    balance -= money;
                    details += "\n\t" + note + "-" + money + "\t" + sdf.format(date) + "\t" + "余额为：" + balance;
                    System.out.println(details);
                    break;
                case "4":
                    while (true) {
                        System.out.println("你确定要退出吗？ y/n");
                        quit = scanner.next();
                        if ("y".equals(quit) || "n".equals(quit)) {
                            break;
                        }
                    }
                    //用户输入正确的yn后 进行判断 n不做处理
                    if ("y".equals(quit)) {
                        isLoop = false;
                    }
                default:
                    System.out.println("您的选择有误，请重新输入");
            }
        } while (isLoop);

        System.out.println("=======您已退出零钱通项目========");

    }
}
