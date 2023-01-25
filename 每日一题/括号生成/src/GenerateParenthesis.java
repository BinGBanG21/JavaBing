import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {

    }
    public List<String> generateParenthesis(int n) {
        //保存结果
        List<String> result = new ArrayList<String>();
        backtrack( n,result, 0, 0, new StringBuffer());
        return result;
    }
    public void backtrack(int total, List<String> list, int left, int right, StringBuffer str){
        // 如果字符串的长度==总数*2 证明有结果了 收集结果集
        if( str.length() == total *2){
            list.add(str.toString());
            return;
        }
        //递进条件
        //有效的括号组合规律 左括号数量<total 右括号<左括号
        if(left < total){
            str.append('(');
            backtrack(total,list,left+1,right,str);
            // 如果没走通 删除str的最后一位 然后走下一个条件判断
            str.deleteCharAt(str.length()-1);
        }
        if(right < left){
            str.append(')');
            backtrack(total,list,left,right+1,str);
            str.deleteCharAt(str.length()-1);
        }
    }
}
