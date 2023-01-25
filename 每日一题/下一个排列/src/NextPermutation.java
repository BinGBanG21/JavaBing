public class NextPermutation {
    public static void main(String[] args) {
        
    }
    public void nextPermutation(int[] nums) {
        //思路：因为是下一个队列 所以这个数要比现在这个数大 同时又要尽可能的小
        // 2 4 5 3 4 4 2 1  ——> 2 4 5 4 1 2 3 4
        //那么应该从后面找到一个较小的数 与后面较大的数交换
        //交换后又要让这个数字尽可能的小 所以要让后面的数字升序排列
        //因为要尽可能小 所以从后面找 第一个升序数字
        int i = nums.length -2;
        while( i >= 0 && nums[i] >= nums[i+1] ){
            i--;
        }
        //找到这个数字后 我们还要找后半部分数组中他大一点的数字交换
        if( i >= 0){
            int j = nums.length -1;
            while( j>=0 && nums[i] >= nums[j] ){
                j--;
            }
            //找到后进行交换
            swap(nums,i,j);
        }
        //把后部分数组升序排列
        reverse(nums, i+1);
    }
    public void swap(int[] nums , int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]= temp;
    }
    public void reverse(int[] nums, int start){
        int left = start ;
        int right = nums.length -1;
        while(left < right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }
}
