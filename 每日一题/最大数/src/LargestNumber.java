import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {

    }

    public String largestNumber(int[] nums) {
        //转化成字符串 然后比较 确定顺序
        //特殊情况处理
        if (nums == null || nums.length == 0) {
            return "";
        }
        //结果
        String[] res = new String[nums.length];
        //将所有数字转化成字符串 两两相加比较 确定顺序
        for (int i = 0; i < nums.length; i++) {
            res[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        });
        //特殊情况处理 降序排列后 数组中首个元素最大 如果是0 那么直接返回0
        if (res[0].charAt(0) == '0') {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : res) {
            sb.append(s);
        }

        return sb.toString();
    }
}
