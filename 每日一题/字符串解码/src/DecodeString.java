public class DecodeString {
    public static void main(String[] args) {

    }

    public String decodeString(String s) {
        return dfs(s, 0)[0];
    }


    //String[]的含义：第一个元素为']'的下标 方便里层[]跳过 更新索引 第二个元素为子字符串
    //如果不是']' 那么就是字符串 存为第一个元素即可 所以当长度为1时:第一个元素为字符串
    public String[] dfs(String s, int i) {
        StringBuffer str = new StringBuffer();
        //字符串的重复字数
        int multi = 0;

        //开始循环处理 如果遇到数字 那么记录
        //如果遇到'[' 那么递归处理
        //如果遇到字母 构建子字符串
        //如果遇到']' 储存索引 返回构建完毕含数字的字符串
        while (i < s.length()) {
            //数字 有可能出现2位3位 所以要multi * 10
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            } else if (s.charAt(i) == '[') {  //左括号 递归(要从'['的下一位开始)
                String[] tempStr = dfs(s, i + 1);
                i = Integer.parseInt(tempStr[0]);
                //构建含数字的子字符串
                while (multi > 0) {
                    str.append(tempStr[1]);
                    multi--;
                }
            } else if (s.charAt(i) == ']') { //右括号 返回字串结尾下标和处理结果
                return new String[]{String.valueOf(i), str.toString()};
            } else {  //字母
                str.append(String.valueOf(s.charAt(i)));
            }
            //i后移
            i++;
        }
        return new String[]{str.toString()};
    }
}
