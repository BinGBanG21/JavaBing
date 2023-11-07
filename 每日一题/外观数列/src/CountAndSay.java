public class CountAndSay {
    public static void main(String[] args) {

    }

    public String countAndSay(int n) {
        //创建字符串 初始值为1
        String res = "1";
        //从第二个开始
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            //记录对上一个字符串的初始遍历位置
            int index = 0;
            //循环 有相同的就累加 没有就+1 然后拼接字符串 替换
            while (index < res.length()) {
                int count = 1;
                //让当前字符和后面字符比较
                while (index < res.length() - 1 && res.charAt(index) == res.charAt(index + 1)) {
                    count++;
                    index++;
                }
                //拼接字符串
                //因为最外层的for循环只是控制次数 所以index在不同情况下都要++
                sb.append(count).append(res.charAt(index));
                index++;
            }
            res = sb.toString();
        }
        return res;
    }
}
