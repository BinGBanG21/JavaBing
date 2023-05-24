

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Partition {
    public static void main(String[] args) {

    }

    //创建结果
    List<List<String>> result = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return result;
    }

    public void backTracking(String s, int startIndex) {
        //终止条件 : 分割到了最后
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        //单层递归逻辑 其实分割和组合问题一样 只不过是每次分割出的区间就是我们想要的结果 [startIndex,i]
        for (int i = startIndex; i < s.length(); i++) {
            //如果是回文串 再加入
            if (isPalindrome(s, startIndex, i) == true) {
                path.add(s.substring(startIndex, i + 1));
            } else { //不是就跳过 不需要再继续分割了
                continue;
            }
            backTracking(s, i + 1);
            //回溯
            path.remove(path.size() - 1);
        }
    }

    //双指针判断是否为回文串
    public boolean isPalindrome(String str, int start, int end) {
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
