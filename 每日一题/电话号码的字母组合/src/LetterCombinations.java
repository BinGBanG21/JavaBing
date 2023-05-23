import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    public static void main(String[] args) {

    }
//    List<String> res;
//    //数组到字符串的映射表
//    String[] letter_map = {" "," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//    public List<String> letterCombinations(String digits) {
//        res = new ArrayList<String>();
//        //边界处理
//        if(digits.length() ==0 || digits == null){
//            return res;
//        }
//        //如果不是空就调用处理函数 并且返回res
//        handleStr(digits, new StringBuilder(), 0);
//        return res;
//    }
//    public void handleStr(String digits, StringBuilder letter, int index){
//        //说明处理到了最后一个 那么处理 然后return
//        if(index == digits.length()){
//            res.add(letter.toString());
//            return;
//        }
//
//        //拿到数字 截取第一个 转成数字 然后拿到map对应的值
//        int pos = digits.charAt(index) - '0';
//        String str = letter_map[pos];
//
//        //遍历字符串
//        for(int i = 0; i < str.length(); i++){
//            letter.append(str.charAt(i));
//            handleStr(digits,letter,index+1);
//            letter.deleteCharAt(letter.length()-1);
//        }
//    }

    //创建结果
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        //边界处理
        if (digits == null || digits.length() == 0) {
            return result;
        }
        //创建字符映射
        String[] letterMap = {" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits, letterMap, 0);
        return result;
    }

    //用于拼接的字符串
    StringBuilder temp = new StringBuilder();

    public void backTracking(String digits, String[] letterMap, int index) {  //index:遍历到哪个字符了
        //终止条件
        if (index == digits.length()) { //遍历到最后一个字符了
            //收集结果
            result.add(temp.toString());
            return;
        }
        //得到第一个字符串
        String str = letterMap[digits.charAt(index) - '0']; //拿到第一个数字对应的str
        //回溯递归
        for (int i = 0; i < str.length(); i++) {
            //收集结果
            temp.append(str.charAt(i));
            backTracking(digits, letterMap, index + 1);
            //弹出末尾元素
            temp.deleteCharAt(temp.length() - 1);

        }
    }
}
