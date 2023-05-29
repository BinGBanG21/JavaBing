import java.util.LinkedList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {

    }

    public List<Integer> partitionLabels(String s) {
        //结果
        List<Integer> list = new LinkedList<>();
        int[] record = new int[26];
        char[] chars = s.toCharArray();
        //记录元素出现最远位置的数组
        for (int i = 0; i < chars.length; i++) {
            record[chars[i] - 'a'] = i;
        }
        int maxIndex = 0;
        //记录截取位置
        int last = 0;
        for (int i = 0; i < chars.length; i++) {
            //遍历时找到范围内的最大出现位置
            maxIndex = Math.max(record[chars[i] - 'a'], maxIndex);
            if (i == maxIndex) {
                //可以分割
                list.add(i - last + 1);
                last = i + 1;
            }
        }
        return list;
    }
}
