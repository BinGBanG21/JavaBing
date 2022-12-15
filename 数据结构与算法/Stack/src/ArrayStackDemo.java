/*
    栈(Stack)
        1.栈是一个先入后出(FILO-First In Last Out)的有序列表。
        2.栈(stack)是限制线性表中元素的插入和删除只能在线性表的同一端进行的一种特殊线性表。
          允许插入和删除的一端，为变化的一端，称为栈顶(Top)，
          另一端为固定的一端，称为栈底(Bottom)。
        3.根据栈的定义可知，最先放入栈中元素在栈底，最后放入的元素在栈顶，
          而删除元素刚好相反，最后放入的元素最先删除，最先放入的元素最后删除
    栈的应用场景
        1.子程序的调用：在跳往子程序前，会先将下个指令的地址存到堆栈中，直到子程序执行完后再将地址取出，以回到原来的程序中。
        2.处理递归调用：和子程序的调用类似，只是除了储存下一个指令的地址外，也将参数、区域变量等数据存入堆栈中。
        3.表达式的转换[中缀表达式转后缀表达式]与求值(实际解决)。
        4.二叉树的遍历。
        5.图形的深度优先(depth一first)搜索法。
    栈的实现
        1.使用数组来模拟栈 因为入栈出栈都只操作栈顶的数据 所以只需要一个指针top即可
        2.定义一个top来表示栈顶，初始化为-1
        3.入栈的操作，当有数据加入到栈时，top++; stack[top] = data;
        4.出栈的操作，int value= stack[top]; top-- , return value


* */


public class ArrayStackDemo {
    public static void main(String[] args) {
        //使用栈完成表达式的计算
        //实现思路
        //1.遍历表达式
        //2.如果发现是一个数字,就直接入数栈
        //3.如果发现扫描到是一个符号,就分如下情况
        //  3.1如果发现当前的符号栈为空，就直接入栈
        //  3.2如果符号栈有操作符，就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符，
        //     就需要从数栈中pop出两个数,在从符号栈中pop出一个符号，进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈
        //     如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈.
        //4.当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号，并运行
        //5.最后在数栈只有—个数字,就是表达式的结果
        String exp = "3+2*6-2";
        //创建两个栈 一个数栈 一个符号栈
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);

        int index = 0;  //java中的字符串不可以[]的方式读值 所以用index配合subString截取 charAt
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        char oper = 0;
        char ch = ' ';
        String keepNum = ""; //用于拼接多位数

        while (true) {
            //拿到每一个字符 判断是数字还是符号
            ch = exp.substring(index, index + 1).charAt(0);
            //如果是运算符 就和栈顶的运算符比较优先级
            if (operStack.isOper(ch)) {
                //在比较的时候还分两种情况 栈中是否已经有运算符
                if (!operStack.isEmpty()) {
                    //如果当前的操作符的优先级小于或者等于栈中的操作符(比较的时候是看一眼 不能调用pop方法 查询即可)，
                    //就需要从数栈中pop出两个数,在从符号栈中pop出一个符号，进行运算，
                    //将得到结果，入数栈，然后将当前的操作符入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = (char) operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //把结果push到栈中
                        numStack.push(res);
                        //然后把当前的符号入符号栈
                        operStack.push(ch);
                    } else { //当前符号的优先级大于符号栈中的优先级 直接入栈
                        operStack.push(ch);
                    }
                } else { //如果符号栈不为空
                    operStack.push(ch);
                }
            } else { //扫描到的是数字（其实是字符串 需要转换成数字 而且要注意多位数的情况）
                //处理思路：扫描到一个数字 不要立即入栈 要继续看后面是数字还是符号 做不同的处理
                //拼接数字
                keepNum += ch;
                //然后将index+1 index+2 后探一位 看是否是数字
                //但如果ch是当前字符串中最后一位 那么就不需要后探直接入栈即可 否则会越界
                if (index == exp.length()-1){
                    numStack.push(ch);
                }
                //后探并拼接数字 如果后面是数字 就拼接 如果是符号 就什么都不做
                //因为上面已经做过循环了 所以keepNum会一直拼接
                //循环的结束条件就是后探为运算符 那么就将数字入栈
                if (operStack.isOper(exp.substring(index+1,index+2).charAt(0))){
                    numStack.push(Integer.parseInt(keepNum));
                    //然后把keepNum赋值为''
                    keepNum = "";
                }

                numStack.push(ch - 48);
            }
            index += 1;
            if (index >= exp.length()) {
                break;
            }
        }
        //while循环结束后代表表达式扫描完毕 然后我们循环符号栈和数字栈 得出结果
        while (true) {
            if (operStack.isEmpty()) {
                break;
            } else {
                num1 = numStack.pop();
                num2 = numStack.pop();
                oper = (char) operStack.pop();
                res = numStack.cal(num1, num2, oper);
                numStack.push(res);
            }
        }
        //输出最后的结果
        System.out.printf("%s = %d", exp, numStack.pop());
    }
}

class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        int[] stacks = new int[this.maxSize];
        top = -1;

    }


    //判断栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //判断栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int data) {
        if (!isFull()) {
            stack[++top] = data;
        } else {
            System.out.println("栈满，无法添加");
        }
    }

    //出栈
    public int pop() {
        if (!isEmpty()) {
            int value = stack[top];
            top--;
            return value;
        } else {
            System.out.println("栈空了");
            return -1;
        }
    }

    //查看栈顶的值
    public int peek() {
        return stack[top];
    }

    //栈的遍历
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空 无法遍历");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.println("栈中第" + i + "个元素为" + stack[i]);
            }
        }
    }


    //计算表达式的辅助方法
    //判断运算符的优先级 我们可以用数字去表示加减乘除的优先级 这样好比较 也比较简洁
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1; //我们只考虑加减乘除 不考虑括号的情况
        }
    }

    //判断当前字符是否是运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //用于计算的方法 如果是减法和除法 就要注意顺序
    public int cal(int num1, int num2, char oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1; //因为是先放到栈中 然后取出来赋值 相减 所以要num2 - num1
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }


}