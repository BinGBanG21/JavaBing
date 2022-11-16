/*
 * */
public class Practice13 {
    public static void main(String[] args) {
        String str = "abcdef";
        try {
            String s = strReverse(str, 1, 4);
            System.out.println(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //将字符串中指定部分进行反转。比如将"a bcde f"反转为"a edcb f"
    //因为String的不可变性 所以要把str转成 char[] 然后交换
    //双指针 分别指交换数组的头尾index 然后左指针++ 右指针-- 左指针<右指针 就进行交换
    public static String strReverse(String str, int sIndex, int eIndex) {
        //对输入的参数越界判断
        if (!(str != null && sIndex >= 0 && eIndex <= str.length() - 1 && eIndex > sIndex)) {
           throw new RuntimeException("参数输入有误");
        }
        char[] chars = str.toCharArray();
        while (true) {
            if (sIndex < eIndex) {
                char temp;
                temp = chars[sIndex];
                chars[sIndex] = chars[eIndex];
                chars[eIndex] = temp;
                sIndex++;
                eIndex--;
            } else {
                break;
            }
        }
        return new String(chars);
    }
}
