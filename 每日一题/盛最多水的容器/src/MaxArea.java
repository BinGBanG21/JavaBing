public class MaxArea {
    public static void main(String[] args) {

    }
    public int maxArea(int[] height) {
        //由题意可知 容量 = min ( heigth[r] , height[l] ) * ( heigth[r] - height[l])
        //采用双指针 l < r
        //如果l < r 那么动l 因为r在最后边 左移长度会减少 面积会缩小
        int l = 0;
        int r = height.length -1;
        int max = 0;
        int curMax = 0;
        while(l < r){
            curMax = Math.min(height[l],height[r]) * (r - l);
            max = Math.max(max,curMax);
            //递归表达式
            //如果右面高 移动左边
            if( height[r] >= height[l] ){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
}
