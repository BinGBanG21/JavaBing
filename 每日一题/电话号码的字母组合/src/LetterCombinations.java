import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    public static void main(String[] args) {

    }
    List<String> res;
    //数组到字符串的映射表
    String[] letter_map = {" "," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<String>();
        //边界处理
        if(digits.length() ==0 || digits == null){
            return res;
        }
        //如果不是空就调用处理函数 并且返回res
        handleStr(digits, new StringBuilder(), 0);
        return res;
    }
    public void handleStr(String digits, StringBuilder letter, int index){
        //说明处理到了最后一个 那么处理 然后return
        if(index == digits.length()){
            res.add(letter.toString());
            return;
        }

        //拿到数字 截取第一个 转成数字 然后拿到map对应的值
        int pos = digits.charAt(index) - '0';
        String str = letter_map[pos];

        //遍历字符串
        for(int i = 0; i < str.length(); i++){
            letter.append(str.charAt(i));
            handleStr(digits,letter,index+1);
            letter.deleteCharAt(letter.length()-1);
        }
    }
}
