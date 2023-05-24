import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public static void main(String[] args) {

    }

    //结果
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        //剪枝 最大为12
        if (s.length() > 12) {
            return result;
        }
        backTracking(s, 0, 0);
        return result;
    }

    public void backTracking(String s, int startIndex, int pointSum) {
        //终止条件 : 3个. 并且区间合法
        if (pointSum == 3) {
            //判断第4段是否合法
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(s);
                return;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            //收集结果
            if (isValid(s, startIndex, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointSum++;
                backTracking(s, i + 2, pointSum);
                //回溯 并删除.
                pointSum--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            } else {
                break;
            }

        }
    }

    public boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(0) == '0' && start != end) { // 除0外 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { //非数字不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0'); //超过255不合法
            if (num > 255) {
                return false;
            }
        }
        return true;

    }

}
