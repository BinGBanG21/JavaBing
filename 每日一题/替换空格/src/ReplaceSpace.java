public class ReplaceSpace {
    public static void main(String[] args) {

    }

    //    public String replaceSpace(String s) {
//        if (s == null || s.length() == 0) {
//            return s;
//        }
//        //对原字符串进行扩容
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == ' ') {
//                sb.append("  ");
//            }
//        }
//        //然后对扩容部分做一个检查
//        if (sb.length() == 0) {
//            return s;
//        }
//        //如果有空格 双指针法
//        //左指针 指向原字符串最后一个字符
//        int left = s.length() - 1;
//        s += sb.toString();
//        //右指针 指向新字符串最后一个字符
//        int right = s.length() - 1;
//        char[] ch = s.toCharArray();
//        while (left >= 0) {
//            if (ch[left] == ' ') {
//                ch[right--] = '0';
//                ch[right--] = '2';
//                ch[right] = '%';
//            } else {
//                ch[right] = ch[left];
//            }
//            left--;
//            right--;
//        }
//        return new String(ch);
//    }
    public String replaceSpace(String s) {
            //错误处理
            if (s == null || s.length() == 0) {
                return s;
            }
            //创建字符数组 假设所有都是空格
            char[] ch = new char[s.length() * 3];
            int index = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    ch[index++] ='%';
                    ch[index++] ='2';
                    ch[index++] ='0';
                } else {
                    ch[index++] =s.charAt(i);
                }
            }
            return new String(ch, 0, index);
    }
}
