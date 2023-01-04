/*
    KMP算法
        应用场景-字符串匹配问题
            1.有一个字符串 str1= ""硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好""，和一个子串 str2="尚硅谷你尚硅你"
            2.现在要判断 str1 是否含有 str2, 如果存在，就返回第一次出现的位置, 如果没有，则返回-1
        暴力匹配算法
            1.如果用暴力匹配的思路，并假设现在str1匹配到 i 位置，子串str2匹配到 j 位置，则有:
            2.如果当前字符匹配成功（即str1[i] == str2[j]），则i++，j++，继续匹配下一个字符
            3.如果失配（即str1[i]! = str2[j]），令i = i - (j - 1)，j = 0。相当于每次匹配失败时，i 回溯，j 被置为0。
            4.用暴力方法解决的话就会有大量的回溯，每次只移动一位，若是不匹配，移动到下一位接着判断，浪费了大量的时间。(不可行!)
        KMP算法介绍
            1.KMP是一个解决模式串在文本串是否出现过，如果出现过，最早出现的位置的经典算法
            2.Knuth-Morris-Pratt 字符串查找算法，简称为 “KMP算法”，常用于在一个文本串S内查找一个模式串P 的出现位置，
              这个算法由Donald Knuth、Vaughan Pratt、James H. Morris三人于1977年联合发表，故取这3人的姓氏命名此算法.
            3.KMP方法算法就利用之前判断过信息，通过一个next数组，保存模式串中前后最长公共子序列的长度，每次回溯时，通过next数组找到
              前面匹配过的位置，省去了大量的计算时间


* */

public class KMP {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
    }

    public static int violenceMatch(String str1, String str2) {
        //得到字符串对应的字符数组
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        //字符串下标的最大值 为什么不用-1 因为下面while匹配成功就++ 成功匹配完后i j应该等于length
        int s1len = s1.length;
        int s2len = s2.length;

        //定义两个下标
        int i = 0;
        int j = 0;

        while (i < s1len && j < s2len) {
            if (s1[i] == s2[j]) {
                //匹配成功 往后走
                i++;
                j++;
            } else { //没有匹配成功 j重置为0  i退回j位 然后往后错一位 继续判断
                j = 0;
                i = i - j + 1;
            }
        }
        //走出whlie循环后 判读是否找到 如果找到就返回 找不到就-1
        if (j == s2len) {
            return i - j;

        } else {
            return -1;
        }
    }

    public static int kmp(String str1, String str2) {
        
    }
}
