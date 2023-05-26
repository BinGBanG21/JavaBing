import java.util.Arrays;

public class FindContentChildren {
    public static void main(String[] args) {

    }

    //    public int findContentChildren(int[] g, int[] s) {
//        Arrays.sort(g);
//        Arrays.sort(s);
//        int m = g.length, n = s.length;
//        int count = 0;
//        for (int i = 0, j = 0; i < m && j < n; i++, j++) {
//            while (j < n && g[i] > s[j]) {
//                j++;
//            }
//            if (j < n) {
//                count++;
//            }
//        }
//        return count;
//    }
    public int findContentChildren(int[] g, int[] s) {
        //对数组进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        //循环胃口数组 进行分发
        //最大的饼干
        int cookies = s.length - 1;
        //饼干一定小于等于胃口 所以先遍历胃口数组
        for (int i = g.length - 1; i >= 0; i--) {
            //如果饼干大于胃口 那么饼干--
            //如不大于 那么胃口在for循环中--了 饼干不需要动 继续比较即可
            if (cookies >= 0 && s[cookies] >= g[i]) {
                cookies--;
                result++;
            }
        }
        return result;
    }
}
}
