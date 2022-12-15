/*
    中缀表达式转换为后缀表达式
        后缀表达式适合计算式进行运算，但是人却不太容易写出来，尤其是表达式很长的情况下，因此在开发中，我们需要将 中缀表达式转成后缀表达式。
        具体步骤如下:
            1.初始化两个栈：运算符栈s1和储存中间结果的栈s2；
            2.从左至右扫描中缀表达式；
            3.遇到操作数时，将其压s2；
            4.遇到运算符时，比较其与s1栈顶运算符的优先级：
                1)如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
                2)否则，若优先级比栈顶运算符的高，也将运算符压入s1；
                3)否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较；
            5.遇到括号时:
                1)如果是左括号“(”，则直接压入s1
                2)如果是右括号“)，则依次弹出s1栈顶的运算符，并压入s立，直到遇到左括号为止，此时将这一对括号丢弃
            6.重复步骤2至5，直到表达式的最右边
            7.将s1中剩余的运算符依次弹出并压入s2
            8.依次弹出s2中的元素并输出，结果的逆潮为中缀表达式对应的后缀表达式

* */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MidToEndExp {
    public static void main(String[] args) {
        //完成将一个中缀表达式转成后缀表达式的功能说明
        //1. 1+((2+3)×4)-5 =>转成1 2 3 +4 × + 5 -
        //2. 因为直接对str，进行操作，不方便，因此先将“1+((2+3)×4)-5”=》中缀的表达式对应的List
        //   即“1+((2+3)×4)-5”=>ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        //3. 将得到的中缀表达式转换成后缀表达式对应的List
        //   即ArrayList [1,+,((,2,+,3,),*,4,),-,5] =》ArrayList [1,2,3,+,4*,+y5-]
        String reg = "1+((2+3)*4)-5";
        //得到中缀表达式
        List<String> midReg = midToList(reg);
        //得到后缀表达式

    }

    //将中缀表达式转成相应的list
    public static List<String> midToList(String reg) {
        ArrayList<String> list = new ArrayList<>();
        int i = 0; //遍历字符串所需要的索引
        char ch = ' ';
        String str = ""; //对多位数做拼接处理
        while (true) {
            if (i == reg.length() - 1) {
                break;
            }
            //如果ch不是数字 直接入栈 index后移
            if ((ch = reg.charAt(i)) < 48 || ((ch = reg.charAt(i)) > 57)) {
                list.add(ch + "");
                i++;
            } else { //如果是一个数字 需要考虑多位数的问题
                //每次判断前将str置空
                str = "";
                //循环 处理多位数的情况
                while ((ch = reg.charAt(i + 1)) <= 48 || ((ch = reg.charAt(i + 1)) >= 57)) {
                    str += ch;
                    i++;
                }
                //拿到数字放入list
                list.add(str);
            }

        }
        return list;
    }

    //根据中缀表达式 得到后缀表达式
    public static List<String> midToEndExp(List<String> list) {
        //定义一个栈存符号 另一个因为没有弹出操作 只需用List即可
        Stack<String> stringStack = new Stack<>();
        ArrayList<String> arrayList = new ArrayList<>();
        //循环list 对字符进行处理
        for (String item : list) {
            if (item.matches("\\d+")) {
                //数字直接入al
                arrayList.add(item);
            } else if (item.equals("(")) { //看是不是一个左括号
                arrayList.add(item);
            } else if (item.equals(")")) { //如果是一个右括号 循环到左括号 一直入栈 然后将左括号弹出
                while (!stringStack.peek().equals("(")) {
                    arrayList.add(item);
                }
                //找到( 记得删除
                stringStack.pop();
            } else { //走到这里 就说明item是运算符
                //如果item的优先级小于等于栈顶的优先级 那么就将栈中的运算符add到list中 然后继续比较
                //其实关键点就只有两个 1.运算符优先级的处理 2.小括号的处理
                while (stringStack.size() != 0 && Operation.getPriority(item) <= Operation.getPriority(stringStack.peek())) {
                    arrayList.add(stringStack.pop());
                }
                stringStack.push(item);
            }
            //然后将栈中剩余的add到al中
            while (stringStack.size() != 0) {
                arrayList.add(stringStack.pop());
            }
        }
        return arrayList;
    }


}

class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getPriority(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }

}