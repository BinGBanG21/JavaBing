/*
    前缀、中缀、后缀表达式(逆波兰表达式)
        前缀表达式(波兰表达式)
            前缀表达式又称波兰式，前缀表达式的运算符位于操作数之前
            举例说明： (3+4)×5-6 对应的前缀表达式就是 - × + 3 4 5 6
        中缀表达式
            中缀表达式就是常见的运算表达式，如(3+4)×5-6
            中缀表达式的求值是我们人最熟悉的，但是对计算机来说却不好操作(前面我们讲的案例就能看的这个问题)
            因此，在计算结果时，往往会将中缀表达式转成其它表达式来操作(一般转成后缀表达式.)
        后缀表达式
            后缀表达式又称逆波兰表达式,与前缀表达式相似，只是运算符位于操作数之后
            中举例说明： (3+4)×5-6 对应的后缀表达式就是 3 4 + 5 × 6 –
        正常的表达式	                        逆波兰表达式
        a+b	                                a b +
        a+(b-c)                         	a b c - +
        a+(b-c)*d	                        a b c – d * +
        a+d*(b-c)	                        a d b c - * +
        a=1+3	                            a 1 3 + =
        后缀表达式的计算机求值
            从左至右扫描表达式，遇到数字时，将数字压入堆栈，遇到运算符时，弹出栈顶的两个数
            用运算符对它们做相应的计算（次顶元素 和 栈顶元素），并将结果入栈
            重复上述过程直到表达式最右端，最后运算得出的值即为表达式的结果
            例如:
            (3+4)×5-6 对应的后缀表达式就是 3 4 + 5 × 6 - ,
            针对后缀表达式求值步骤如下:
                从左至右扫描，将3和4压入堆栈；
                遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
                将5入栈；
                接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
                将6入栈；
                最后是-运算符，计算出35-6的值，即29，由此得出最终结果
        完成一个逆波兰计算器，要求完成如下任务:
           输入一个逆波兰表达式(后缀表达式)，使用栈(Stack), 计算其结果
           支持小括号和多位数整数，只支持对整数的计即可。

* */


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //先定义给逆波兰表达式
        //(3+4)×5-6=>3 4 + 5 * 6-
        //为了方便,逆波兰表达式的数字和符号使用空格隔开
        String suffixExpression = "3 4 + 5 * 6 -";
        //思路
        //1.先将“3 4 + 5 * 6 - " =>放到ArrayList中
        //2.将ArrayList传递给一个方法,遍历ArrayList配合栈完成计算

    }

    //将逆波兰表达式放到ArrayList中
    public static List<String> getStringList(String exp) {
        String[] strings = exp.split(" ");
        //创建一个ArrayList
        ArrayList<String> stringArrayList = new ArrayList<>();
        //把有效数据先放到ArrayList中去
        for (String s : strings) {
            stringArrayList.add(s);
        }
        return stringArrayList;
    }


    //完成对逆波兰表达式的运算*
        /*1)从左至右扫描,将3和4压入堆栈;
          2)遇到+运算符，因此弹出4和3(4为栈顶元素，3为次顶元素〉，计算出3+4的值，得7，再将7入栈;
          3)将5入栈;
          4)接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈;
          5)将6入栈;
          6)最后是-运算符,计算出35-6的值,即29
         */
    public static int calculate(List<String> list) {
        //创建栈 然后遍历集合 判断是数字还是字符 做相应的处理
        Stack<String> stringStack = new Stack<>();
        int num1 = 0;
        int num2 = 0;
        int res = 0;

        for (String s : list) {
            if (s.matches("\\d+")) {
                stringStack.add(s);
            }
            switch (s) {
                case "+":
                    num2 = Integer.parseInt(stringStack.pop());
                    num1 = Integer.parseInt(stringStack.pop());
                    res = num1 + num2;
                    break;
                case "-":
                    num2 = Integer.parseInt(stringStack.pop());
                    num1 = Integer.parseInt(stringStack.pop());
                    res = num1 - num2;
                    break;
                case "*":
                    num2 = Integer.parseInt(stringStack.pop());
                    num1 = Integer.parseInt(stringStack.pop());
                    res = num1 * num2;
                    break;
                case "/":
                    num2 = Integer.parseInt(stringStack.pop());
                    num1 = Integer.parseInt(stringStack.pop());
                    res = num1 / num2;
                    break;
                default:
                    throw new RuntimeException("运算符有误");
            }
            stringStack.push(res + "");
        }
        return Integer.parseInt(stringStack.pop());
    }
}


