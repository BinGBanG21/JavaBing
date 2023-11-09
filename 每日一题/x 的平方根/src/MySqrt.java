public class MySqrt {
    public static void main(String[] args) {

    }

    public int mySqrt(int x) {
        //二分查找
        //我们需要找到 a^2 <= x < (a+1)^2
        //0 1特殊处理
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        int left = 1;
        int right = x / 2; //一个数的平方比他一半小

        //循环查找
        while (left < right) {
            int mid = left + (right - left + 1) / 2; //+1 向上取整 防止死循环
            if (mid > x / mid) {  //证明mid比x大
                right = mid - 1;
            } else if (mid == x / mid) {  //本题特殊性
                return mid;
            } else {
                left = mid;
            }
        }
        //到最后left = right = mid
        return left;
    }
}
