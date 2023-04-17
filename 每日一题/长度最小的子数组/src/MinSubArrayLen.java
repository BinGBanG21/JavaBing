public class MinSubArrayLen {
    public static void main(String[] args) {

    }

//    public int minSubArrayLen(int target, int[] nums) {
//        //滑动窗口解决
//        int start = 0;
//        int end = nums.length;
//        int result = Integer.MAX_VALUE;
//        int sum = 0;
//        int i = 0;
//        //i起始位置 j终止位置
//        for (int j = 0; j < nums.length; j++) {
//            sum += nums[j];
//            while (sum >= target) {
//                int subL = j - i + 1;
//                result = Math.min(result, subL);
//                sum -= nums[i];
//                i++;
//            }
//        }
//        return result == Integer.MAX_VALUE ? 0 : result;
//    }
    public int minSubArrayLen(int s , int[] nums){
        //思路：暴力解 双重for循环 i 0 j i 开始 记录和 >= s 记录长度 j - 1 + 1；
        //优化解法 滑动窗口 不断更改起始位置的值 找到结果
        //举例 1 1 3 4  s8  for循环的话 1134合适 还会再次循环一遍 发现134也满足
        //但是滑动窗口的话 1 1 3 4 满足后 直接 -1就可以
        int result = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;
        for(int end = start; end < nums.length; end++){
            //收集和
            sum += nums[end];
            //如果满足 则循环 进一步缩小窗口 取最优解
            //不满足就继续for循环 继续累加
            while(sum >= s){
                result = Math.min(result,end - start + 1);
                //移动窗口起始位置 缩小窗口 看是否满足 不满足就继续走for循环
                sum -= nums[start++];
            }
        }
        //如果不满足 结果为0
        return result == Integer.MAX_VALUE ? 0 : result;

    }

}
