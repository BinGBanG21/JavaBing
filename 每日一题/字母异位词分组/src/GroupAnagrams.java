import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        //先对strs进行排序 然后加入ArrayList中
        //用排序后的str做key进行区别
        Map<String, ArrayList> strMap = new HashMap<>();
        //循环strs
        for (String str : strs) {
            char[] c = str.toCharArray();
            //转成字符数组 进行排序
            Arrays.sort(c);
            //转成字符串 当作key
            String key = new String(c);
            if (strMap.get(key) == null) {
                strMap.put(key, new ArrayList<String>());
            }
            strMap.get(key).add(str);
        }
        return new ArrayList(strMap.values());
    }
}
